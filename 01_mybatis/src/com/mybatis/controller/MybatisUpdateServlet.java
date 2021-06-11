package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;


@WebServlet("/update")
public class MybatisUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisUpdateServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		Student s = new Student();
		
		s = Student.builder().studentName(name).studentAddr(addr).studentTel(phone).build();
		
		int result = new MybatisService().updateStudent(s);
		
		response.getWriter().append(result > 0 ? "success" : "fail");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
