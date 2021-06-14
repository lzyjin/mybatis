package com.mybatis.controller.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MemberService;
import com.mybatis.model.vo.Member;


@WebServlet("/searchMemberId")
public class SearchMemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchMemberIdServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Member idSearchResult = new MemberService().searchMemberId(id);
		
		request.setAttribute("idSearchResult", idSearchResult);
		
		request.getRequestDispatcher("/views/member.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
