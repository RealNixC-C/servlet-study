package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 모든 필드값의 매개변수 생성자
@Getter // getter만 생성
public class Account {
	private int no;
	private String name;
}
