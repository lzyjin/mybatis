package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmployeeService;
import com.mybatis.model.vo.Employee;


@WebServlet("/selectOneEmp")
public class SelectOneEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectOneEmpServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		Employee e = new EmployeeService().selectOneEmp(no);
		
				System.out.println("e : " + e);
		
		request.setAttribute("e", e);
		
		request.getRequestDispatcher("/views/emp/test.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
