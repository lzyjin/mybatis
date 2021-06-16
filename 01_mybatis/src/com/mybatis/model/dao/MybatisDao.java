package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class MybatisDao {
	
	
	
	public int insertStudent(SqlSession session) {
		
		// session이 제공하는 sql실행 메소드를 호출하면 끝 
		
		
		// mapper 선택하기 
		
		// namespace명.태그(insert, update, delete, select ..)의 id값
	
		int result = session.insert("student.insertStudent");
		
		return result;
	}
	
	

	public int insertStudentName(SqlSession session, String name) {
		
		// 보통 sql문의 id와 메소드명을 통일시킨다 
		return session.insert("student.insertStudentName", name);
		
	}



	public int insertEmail(SqlSession session, String email) {
		
		return session.insert("student.insertStudentEmail", email);
	}



	public int insertParamAll(SqlSession session, Student s) {
		
		return session.insert("student.insertParamAll", s);
	}



	public int insertParamMap(SqlSession session, Map<String, String> param) {
		
		return session.insert("student.insertParamMap", param);
	}



	public int updateStudent(SqlSession session, Student s) {
		
		return session.update("student.updateStudent", s);
	}



	public int deleteStudent(SqlSession session, String name) {
		
		return session.delete("student.deleteStudent", name);
	}



	public int selectCount(SqlSession session) {
		
		// select문을 실행한 결과 1개의 row만 가져올 경우 ( max가 1 ) -> selectOne() 메소드를 이용
		// -> 사용자가 지정한 반환타입으로 반환
		
		
		// select문을 실행한 결과 2개 이상의 row를 가져올 경우 -> selectList() 메소드를 이용 
		// -> List로 반환, 단 Generic 타입을 정할 수 있다
		// -> List<클래스명> : mapper에서도 제네릭에 들어갈 클래스를 속성에 적어줘야한다
		
		
		return session.selectOne("student.selectCount"); // 반환타입이 메소드의 반환타입으로 자동으로 맞춰진다
	}



	public Student selectStudent(SqlSession session, int no) {
		
		return session.selectOne("student.selectStudent", no);
	}



	
	// 210614 
	public List<Student> selectStudentList(SqlSession session) {

		return session.selectList("student.selectStudentList");
	}



	public List<Student> searchEmail(SqlSession session, String email) {
	
		return session.selectList("student.searchEmail", email);
	}



	public Map selectStudentMap(SqlSession session, int no) {
		
		return session.selectOne("student.selectStudentMap", no);

	}



	public List<Map> selectStudentListMap(SqlSession session) {
		
		return session.selectList("student.selectStudentListMap");
	}

}
