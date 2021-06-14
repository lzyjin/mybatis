package com.mybatis.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;


@WebServlet("/selectStudentMap")
public class MybatisSelectStudentMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisSelectStudentMapServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Map student = new MybatisService().selectStudentMap(no);
		
				System.out.println(student);
				
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("/views/student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
