package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;


@WebServlet("/paramMybatis")
public class MybatisInsertNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisInsertNameServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		int result = new MybatisService().insertStudentName(name);
		
		response.getWriter().append( result > 0 ? "success" : "fail" );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
