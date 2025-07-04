package com.gn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/filePath")
public class FilePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    public FilePathServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attachNo =Integer.parseInt(request.getParameter("no"));
		
		Attach attach = service.selectAttachByAttachNo(attachNo);
		// DB에서 attachNo와 일치하는 데이터를 조회하여 아래 4개의 컬럼을 조회
		// attach_no, board_no, ori_name, re_name
		if(attach != null) {
			System.out.println(attach);
			System.out.println("attach성공적으로 가져옴");
		}
		
		// 1. 파일의 경로 지정
		// 만약 위에 호출한 service.selectAttachByAttachNo값이 null이면
		// 아래 코드에서 NPE발생
		String filePath = "C:\\upload\\board\\" + attach.getReName();
		
		// 2. 파일 정보가 없는 경우 에러 발생
		if (filePath == null || filePath.trim().equals("")) {
			// 400 에러
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 3. 파일이 존재하는지 확인
		File file = new File(filePath);
		if(!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 4. 파일 타입 지정
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) mimeType = "application/octet-stream";
		response.setContentType(mimeType);
		
		// 5. 파일 정보 브라우저에게 전송
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream out = response.getOutputStream();) {
				// 1kb씩 전송
				byte[] buffer = new byte[1024];
				int byteRead;
				while((byteRead = fis.read(buffer)) != -1) {
					out.write(buffer, 0 ,byteRead);
				}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
