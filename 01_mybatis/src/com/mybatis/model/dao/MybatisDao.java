package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public class MybatisDao {
	
	public int insertStudent(SqlSession session) {
		
		// session이 제공하는 sql실행 메소드를 호출하면 끝 
		
		
		// mapper 선택하기 
		// namespace명.태그(insert, update, delete, select ..)의 id값
		int result = session.insert("student.insertStudent");
		
		return result;
	}

}
