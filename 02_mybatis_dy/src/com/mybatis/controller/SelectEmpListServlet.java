package com.mybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmployeeService;
import com.mybatis.model.vo.Employee;


@WebServlet("/selectEmpList")
public class SelectEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectEmpListServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Employee> list = new EmployeeService().selectEmpList();
		List<Map> list = new EmployeeService().selectEmpList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/result.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
