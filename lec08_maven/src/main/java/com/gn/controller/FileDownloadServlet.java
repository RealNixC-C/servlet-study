package com.gn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();

	public FileDownloadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int attachNo = Integer.parseInt(request.getParameter("no"));
		Attach attach = service.selectAttachByAttachNo(attachNo);

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
		if (!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 4. 다운로드용 응답 헤더 설정
		response.setContentType("application/octet-stream");
		response.setContentLength((int)file.length());
		
		// 5. 파일명 인코딩
		String encodedName = URLEncoder.encode(attach.getOriName(), "utf-8").replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ encodedName + "\"");
		
		// 6. 파일 데이터 전송
		// 파일의 미리보기든 다운로드든 브라우저한테는 똑같은 정보이다
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream out = response.getOutputStream();){
				byte[] buffer = new byte[1024];
				int byteRead;
				while((byteRead = fis.read(buffer)) != -1) {
					out.write(buffer,0,byteRead);
				}
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
