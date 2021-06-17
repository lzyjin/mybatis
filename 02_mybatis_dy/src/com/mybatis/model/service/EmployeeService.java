package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmployeeDao;
import com.mybatis.model.vo.Board;
import com.mybatis.model.vo.Employee;

import oracle.net.aso.c;

import static com.mybatis.common.SqlSessionTemplate.getSession;

public class EmployeeService {
	
	
	
	private EmployeeDao dao = new EmployeeDao();
	
	

//	public List<Employee> selectEmpList() {
//		
//		SqlSession session = getSession();
//		
//		List<Employee> list = dao.selectEmpList(session);
//		
//		session.close();
//		
//		return list;
//	}
	
	
	
//	public List<Map> selectEmpList() {
//		
//		SqlSession session = getSession();
//		
//		List<Map> list = dao.selectEmpList(session);
//		
//		session.close();
//		
//		return list;
//	}

	
	// 210617
	// 페이징처리 추가
	
	public List<Map> selectEmpList(int cPage, int numPerPage) {
		
		SqlSession session = getSession();
		
		List<Map> list = dao.selectEmpList(session, cPage, numPerPage);
		
		session.close();
		
		return list;
	}
	
	
	
	
//	public List<Map> searchEmp(Map<String, String> param) {
	public List<Map> searchEmp(Map<String, Object> param) {
		
		SqlSession session = getSession();
		
		List<Map> list = dao.searchEmp(session, param);
		
		session.close();
		
		return list;
	}




	public int selectEmpCount() {
		
		SqlSession session = getSession();
		
		int result = dao.selectEmpCount(session);
		
		session.close();
		
		return result;
	}




	public int selectSearchEmpCount(Map<String, Object> param) {
		
		SqlSession session = getSession();
		
		int result = dao.selectSearchEmpCount(session, param);
		
		session.close();
		
		return result;
	}




	public Employee selectOneEmp(String no) {
		
		SqlSession session = getSession();
		
		Employee e = dao.selectOneEmp(session, no);
		
		session.close();
		
		return e;
	}




	public Board selectBoard(String no) {
		
		SqlSession session = getSession();
		
		Board b = dao.selectBoard(session, no);
		
		session.close();
		
		return b;
	}

	
	

}
