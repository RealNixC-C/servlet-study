package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {

	public List<Student> selectAll(){
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		return list;
	}
	
	public Student selectOne(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		session.close();
		return student;
	}
	
	public List<Student> searchStudentByName(String studentName) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectByName", studentName);
		session.close();
		return list;
	}
	
	public int insert(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		session.close();
		return result;
	}
	
	public int update(Student param) {
		// Service한테 Student를 전달받음
		// 전달 받은 정보를 가지고 update 세션 메소드 사용
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", param);
		session.close();
		return result;
		
	}
	
	public int delete(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.deleteStudent", studentNo);
		session.close();
		return result;
		
	}
	
	
	
	
	
}
