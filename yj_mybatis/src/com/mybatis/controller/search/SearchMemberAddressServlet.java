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


@WebServlet("/searchMemberAddress")
public class SearchMemberAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchMemberAddressServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String addr = request.getParameter("addr");
		
		List<Member> list_addr = new MemberService().searchMemberAddr(addr);
		
		request.setAttribute("list_addr", list_addr);
		
		request.getRequestDispatcher("/views/member.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
