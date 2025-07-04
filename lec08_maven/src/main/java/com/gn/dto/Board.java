package com.gn.dto;

import com.gn.common.vo.Paging;

import lombok.Data;

@Data
public class Board extends Paging{
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	// 삽입과 수정만 하게되는 경우 Data 객체로 받지 않아도됨
	private String regDate;
	private String modDate;
	
	private String memberId;
	private String keyword;
}
