package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;


@WebServlet("/insertStudentTest")
public class MyBatisExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyBatisExpServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = new MybatisService().insertStudent();
		
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().append(result>0 ? "success" : "fail");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
