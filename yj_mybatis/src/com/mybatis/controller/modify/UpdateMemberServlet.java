package com.mybatis.controller.modify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MemberService;
import com.mybatis.model.vo.Member;


@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateMemberServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("usernamne");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		Member m = Member.builder().userid(id).username(name).email(email).age(Integer.parseInt(age)).build();
		
				System.out.println("UpdateMemberServlet, m : " + m);
		
		int result = new MemberService().updateMember(m);
		
		response.getWriter().append(result > 0 ? "success" : "fail");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
