package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;


@WebServlet("/selectCount")
public class MybatisStudentCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisStudentCountServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = new MybatisService().selectCount();
		
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		response.getWriter().append("학생 수 : " + result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
