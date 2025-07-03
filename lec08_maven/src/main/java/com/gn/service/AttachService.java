package com.gn.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import com.gn.dto.Attach;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class AttachService {

	// 1. 업로드할 디렉토리 반환
	public static File getUploadDirectory() {
		String dirPath="C://upload/board";
		
		// 파일을 업로드할 디렉토리 생성
		File uploadDir = new File(dirPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		return uploadDir;
	}
	
	// 2. 정보 중에서 파일 추출
	public static Attach handleUploadFile(HttpServletRequest request,
			File uploadDir) {
		// 파일이 있는지 확인
		// commons-io - 파일의 존재 유무를 확인해주는 libarary
		// form에서 파일 가져오기 -> name 속성 기준
		Attach result = null;
		try {
			Part filePart = request.getPart("boardFile");
			if (filePart.getSize() > 0) {
				result = getFileMeta(filePart, uploadDir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 3. 서버에 파일 자체 저장 & 파일 메타 데이터 추출
	public static Attach getFileMeta(Part part, File uploadDir) {
		// 원본 파일 이름
		String oriName = part.getSubmittedFileName();
		// ex) a.png -> 앎잳래ㅑ더ㅐㅎㅁ.png
		// 파일 확장자 추출
		String ext = FilenameUtils.getExtension(oriName);
		// 확장자 제외 파일 이름
		String fileName = oriName.substring(0, oriName.indexOf("."));
		// UUID 사용 -> 중복 방지
		// UUID는 agawg-oiiew-ijeiw 식으로 되어있기 때문에 하이픈 제거
		String saveName = UUID.randomUUID().toString().replace("-", "");
		// 중복 방지 파일명 + 확장자
		// 내용없는 새로운 파일 생성
		File file = new File(uploadDir, saveName + "." + ext);
		
		// 파일 서버에 저장
		try(InputStream input = part.getInputStream();
			OutputStream output = Files.newOutputStream(file.toPath())) {
			
			// output 경로에 input에 담긴 데이터 보내기
			input.transferTo(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Attach a = new Attach();
		a.setOriName(oriName);
		a.setReName(saveName + "." + ext);
		
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
