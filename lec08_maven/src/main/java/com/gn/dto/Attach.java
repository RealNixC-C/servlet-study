package com.gn.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Attach {

	private int attachNo; // 첨부파일 번호
	private int boardNo; // 어느 게시판인지 확인하는 게시판 번호
	private String oriName; // 사용자가 작성한 파일명
	private String reName; // 개발자가 중복되지 않게 새로 작명한 파일명
	private String regDate;
	
	// 파일은 수정한다는 개념이 없기때문에 modDate는 작성하지 않음
	// 기존 파일을 삭제하고 새 파일을 업로드 하는 형식으로 사용함
}
