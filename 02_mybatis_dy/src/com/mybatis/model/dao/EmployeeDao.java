package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Board;
import com.mybatis.model.vo.Employee;


public class EmployeeDao {
	
	
	

//	public List<Employee> selectEmpList(SqlSession session) {
//		
//		return session.selectList("emp.selectEmpList");
//	}
	
	
	
	
//	public List<Map> selectEmpList(SqlSession session) {
//		
//		return session.selectList("emp.selectEmpList");
//	}

	
	
	// 210617 
	// 페이징처리 추가
	public List<Map> selectEmpList(SqlSession session, int cPage, int numPerPage) {
		
		// RowBounds 클래스는 생성시 매개변수값으로 page의 범위를 결정한다
		// 2개의 매개변수 
		// offset : 시작 : (cPage-1)*numPerPage 
		// limit : 범위 : numPerPage
		
		RowBounds row = new RowBounds( (cPage-1)*numPerPage, numPerPage );
		
		return session.selectList("emp.selectEmpList", null, row);
	}
	
	
	
//	public List<Map> searchEmp(SqlSession session, Map<String, String> param) {
//	public List<Map> searchEmp(SqlSession session, Map<String, Object> param) {
//	
//		return session.selectList("emp.searchEmp", param);
//	}
	
	
	

	// 페이징처리 
	public List<Map> searchEmp(SqlSession session, Map<String, Object> param) {
		
		int cPage = (int) param.get("cPage");
		int numPerPage = (int) param.get("numPerPage");
		
		RowBounds row = new RowBounds( (cPage-1)*numPerPage, numPerPage );
		
		return session.selectList("emp.searchEmp", param, row);
	}
	
	
	


	public int selectEmpCount(SqlSession session) {

		return session.selectOne("emp.selectEmpCount");
	}



	public int selectSearchEmpCount(SqlSession session, Map<String, Object> param) {
		
		return session.selectOne("emp.selectSearchEmpCount", param);
	}



	public Employee selectOneEmp(SqlSession session, String no) {
		
		return session.selectOne("emp.selectOneEmp", no);
	}



	public Board selectBoard(SqlSession session, String no) {
		
		return session.selectOne("emp.selectBoard", no);
	}
	
	

}
