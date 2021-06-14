package com.mybatis.controller.search;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MemberService;
import com.mybatis.model.vo.Member;


@WebServlet("/selectMemberList")
public class SelectMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectMemberListServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Member> list = new MemberService().selectMemberList();
		
		List<Map> list2 = new MemberService().selectMemberList2();
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("/views/memberlist.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
