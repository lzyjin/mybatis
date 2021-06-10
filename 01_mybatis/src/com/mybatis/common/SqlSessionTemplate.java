package com.mybatis.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSession() {
		
		SqlSession session = null;
		
		// mybatis 설정 xml을 가져온다
		String resource = "/mybatis-config.xml"; //  ????? resources폴더 바로 밑에 있어서 이렇게 쓰는것.
		
		try {
			
			// mybatis-config.xml파일을 inputstream으로 가져옴
			InputStream is = Resources.getResourceAsStream(resource);
			
			// SqlSessionFactoryBuilder 클래스 생성
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			
			// sfb.build(mybatis-config.xml) 로 SqlSessionFactory 클래스를 생성
			SqlSessionFactory ssf = sfb.build(is);
			
			// SqlSession 생성하기
			session = ssf.openSession(false);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return session;
		
	}
}