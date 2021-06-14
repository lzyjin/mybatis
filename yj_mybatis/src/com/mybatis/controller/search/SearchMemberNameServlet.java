package com.mybatis.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MemberService;
import com.mybatis.model.vo.Member;


@WebServlet("/searchMemberName")
public class SearchMemberNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchMemberNameServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		List<Member> list_name = new MemberService().searchMemberName(name);
		
		request.setAttribute("list_name", list_name);
		
		request.getRequestDispatcher("/views/member.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
