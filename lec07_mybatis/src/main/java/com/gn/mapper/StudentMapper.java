package com.gn.mapper;

import java.util.List;

import com.gn.dto.Student;

public interface StudentMapper {
	List<Student> selectAll();
	
	Student selectOne(int studentNo);
	
	List<Student> selectByName(String studentName);
	
	int insert(Student param);
	
	int updateStudent(Student student);
	// updateStudent 메소드 정의 반환 타입 int
	// 반환형 : int
	// 매개변수 : Student student
	
	int deleteStudent(int studentNo);
	
}
