package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;


@WebServlet("/selectStudent")
public class MybatisSelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisSelectStudentServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		Student s = new MybatisService().selectStudent(no);
		
			System.out.println(s);
			
		request.setAttribute("student", s);
		
		request.getRequestDispatcher("/views/student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
