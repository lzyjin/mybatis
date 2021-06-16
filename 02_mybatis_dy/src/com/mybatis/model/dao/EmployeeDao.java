package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class EmployeeDao {

//	public List<Employee> selectEmpList(SqlSession session) {
//		
//		return session.selectList("emp.selectEmpList");
//	}
	
public List<Map> selectEmpList(SqlSession session) {
		
		return session.selectList("emp.selectEmpList");
	}

	public List<Map> searchEmp(SqlSession session, Map<String, String> param) {
		
		return session.selectList("emp.searchEmp", param);
	}
	
	

}
