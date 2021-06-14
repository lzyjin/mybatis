package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Member;

public class MemberDao {

	public List<Member> selectMemberList(SqlSession session) {
		
		return session.selectList("member.selectMemberList");
	}

	public List<Map> selectMemberList2(SqlSession session) {
		
		return session.selectList("member.selectMemberList2");
	}

	public List<Member> searchMemberName(SqlSession session, String name) {
		
		return session.selectList("member.searchMemberName", name);
	}
	
	public List<Member> searchMemberAddr(SqlSession session, String addr) {
		
		return session.selectList("member.searchMemberAddr", addr);
	}
	
	public Member searchMemberId(SqlSession session, String id) {
		
		return session.selectOne("member.searchMemberId", id);
	}

	public int insertMember(SqlSession session, Member m) {
		
		return session.insert("member.insertMember", m);
	}

	public int updateMember(SqlSession session, Member m) {
		
		return session.update("member.updateMember", m);
	}

	public int deleteMember(SqlSession session, String id) {
		
		return session.delete("member.deleteMember", id);
	}

	

	

}
