 package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;


@WebServlet("/searchStudent")
public class MybatisSearchEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisSearchEmailServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		List<Student> list = new MybatisService().searchEmail(email);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/studentList.jsp").forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
