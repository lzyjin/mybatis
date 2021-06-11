package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.vo.Student;
public class MybatisService {
	
	
	
	private MybatisDao dao = new MybatisDao();
	
	

	public int insertStudent() {
		
		
		SqlSession session=getSession();
		
		int result=dao.insertStudent(session);
		
		if(result>0) {
			
			session.commit();
			
		} else {
			
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int insertStudentName(String name) {
		
		SqlSession session=getSession();
		
		int result=dao.insertStudentName(session, name);
		
		if(result>0) {
			
			session.commit();
			
		} else {
			
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int insertEmail(String email) {
		
		SqlSession session = getSession();
		
		int result = dao.insertEmail(session, email);
		
		if(result>0) {
			
			session.commit();
			
		} else {
			
			session.rollback();
		}

		session.close();
		
		return result;
	}



	public int insertParamAll(Student s) {
		
		SqlSession session = getSession();
		
		int result = dao.insertParamAll(session, s);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int insertParamMap(Map<String, String> param) {
		
		SqlSession session = getSession();
		
		int result = dao.insertParamMap(session, param);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int updateStudent(Student s) {
		
		SqlSession session = getSession();
		
		int result = dao.updateStudent(session, s);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;

	}



	public int deleteStudent(String name) {
		
		SqlSession session = getSession();
		
		int result = dao.deleteStudent(session, name);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int selectCount() {
		
		SqlSession session = getSession();
		
		int result = dao.selectCount(session);
		
		session.close();
		
		return result;
	}



	public Student selectStudent(int no) {
		
		SqlSession session = getSession();
		
		Student s = dao.selectStudent(session, no);
		
		session.close();
		
		return s;
	}
}
