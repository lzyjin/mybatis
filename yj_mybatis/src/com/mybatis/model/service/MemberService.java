package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MemberDao;
import com.mybatis.model.vo.Member;

import static com.mybatis.common.SqlSessionTemplate.getSession;

public class MemberService {
	
	
	
	private MemberDao dao = new MemberDao();

	
	
	public List<Member> selectMemberList() {
		
		SqlSession session = getSession();
		
		List<Member> list = dao.selectMemberList(session);
		
		session.close();
		
		return list;
	}



	public List<Map> selectMemberList2() {
		
		SqlSession session = getSession();
		
		List<Map> list2 = dao.selectMemberList2(session);
		
		session.close();
		
		return list2;
	}



	public List<Member> searchMemberName(String name) {
		
		SqlSession session = getSession();
		
		List<Member> list1 = dao.searchMemberName(session, name);
		
		session.close();
		
		return list1;
	}
	
	public List<Member> searchMemberAddr(String addr) {
		
		SqlSession session = getSession();
		
		List<Member> list2 = dao.searchMemberAddr(session, addr);
		
		session.close();
		
		return list2;
	}
	



	public Member searchMemberId(String id) {
		
		SqlSession session = getSession();
		
		Member member = dao.searchMemberId(session, id);
		
		session.close();
		
		return member;
	}



	public int insertMember(Member m) {
		
		SqlSession session = getSession();
		
		int result = dao.insertMember(session, m);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int updateMember(Member m) {
		
		SqlSession session = getSession();
		
		int result = dao.updateMember(session, m);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	public int deleteMember(String id) {
		
		SqlSession session = getSession();
		
		int result = dao.deleteMember(session, id);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}



	



	
	

}
