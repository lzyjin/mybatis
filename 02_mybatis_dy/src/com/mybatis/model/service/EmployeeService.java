package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmployeeDao;

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
	
	public List<Map> selectEmpList() {
		
		SqlSession session = getSession();
		
		List<Map> list = dao.selectEmpList(session);
		
		session.close();
		
		return list;
	}


	public List<Map> searchEmp(Map<String, String> param) {
		
		SqlSession session = getSession();
		
		List<Map> list = dao.searchEmp(session, param);
		
		session.close();
		
		return list;
	}
	
	

}
