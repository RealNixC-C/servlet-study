package com.gn.dto;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	// 삽입과 수정만 하게되는 
//	private String reg_date;
//	private String reg_mod_date;
//	private String boardRegDate;
	private String regDate;
	private String modDate;
}
