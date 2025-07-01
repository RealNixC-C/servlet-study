package com.gn.service;

import java.util.ArrayList;
import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {
	// DAO 한테 부탁해서 데이터베이스에서 정보를 조회, 등록, 수정, 삭제 (CRUD)
	private StudentDao dao = new StudentDao();
	
	public List<Student> getStudentList() {
		List<Student> list = dao.selectAll();
		return list;
	}
	
	public Student getStudentDetail(int studentNo) {
		Student student = dao.selectOne(studentNo);
		return student;
	}
	
	public List<Student> searchStudentByName(String studentName) {
		List<Student> list = dao.searchStudentByName(studentName);
		return list;
	}
	
	public int insertStudent(String name, int age) {
		// 2가지의 바구니 상황별 사용 용도
		// 1. Map : DTO에 없는 필드가 있을 경우, 3개 이하 일때 사용 
		// 2. DTO(Student)
		Student param = new Student();
		param.setStudentName(name);
		param.setStudentAge(age);
		
		return dao.insert(param);
	}
	
	public int updateStudent(int studentNo, String studentName, int studentAge) {
		// 수정 -> 번호, 이름 나이 전달 받아옴
		// DAO한테 부탁할때는 Student 바구니에 담아서 전달
		// 결과는 int로 반환
		Student param = new Student();
		param.setStudentNo(studentNo);
		param.setStudentName(studentName);
		param.setStudentAge(studentAge);
		
		return dao.update(param);
	}
	
	public int deleteStudent(int studentNo) {
		return dao.delete(studentNo);
	}
	
	
	
	
}