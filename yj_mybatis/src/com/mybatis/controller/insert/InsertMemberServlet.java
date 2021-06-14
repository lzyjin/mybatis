package com.mybatis.controller.insert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MemberService;
import com.mybatis.model.vo.Member;

@WebServlet("/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertMemberServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("username");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String hobby = request.getParameter("hobby");
		
		Member m = Member.builder().userid(id).password(pw).username(name)
									.gender(gender).age(Integer.parseInt(age)).email(email)
									.phone(phone).address(addr).hobby(hobby).build();
		
				System.out.println("InsertMemberServlet, m : " + m);
		
		
		int result = new MemberService().insertMember(m);
		
		response.getWriter().append(result > 0 ? "success" : "fail");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
