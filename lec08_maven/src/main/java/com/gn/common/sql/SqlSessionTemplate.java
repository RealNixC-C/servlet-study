package com.gn.common.sql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		try {
			// 1. SqlSessionFactoryBuilder
			// mybatis-config.xml의 설정 정보를 통해 객체 생성
			String path = "/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(path);
			
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			
			// 2. SqlSessionFactory 객체 생성
			// SqlSessionFactoryBuilder의 build() 메소드를 활용
			// 매개변수로 mybatis-config.xml 파일 정보 전달
			SqlSessionFactory factory = sfb.build(is);
			
			// 3. SqlSession 객체 생성
			// SqlSessionFactory의 openSession() 메소드 사용
			// true : autoCommit 켜기 -> 데이터 변경 자동 반영
			// false : 끄기(명시적으로 commit 호출) -> 수동
			// getSqlSession 메소드 호출시 받은 매개변수를 openSession의 매개값으로 사용(Boolean타입)
			session = factory.openSession(autoCommit);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
