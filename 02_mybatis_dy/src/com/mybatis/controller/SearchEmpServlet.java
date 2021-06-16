package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmployeeService;


@WebServlet("/searchEmp")
public class SearchEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchEmpServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String col = request.getParameter("searchType");
		String val = request.getParameter("searchKeyword");
		
		String gender = request.getParameter("gender");
		
//				System.out.println(gender); // 남
				
		String salary = request.getParameter("salary");
		String lege = request.getParameter("le_ge");
		
		String hireDate = request.getParameter("hiredate");
		String hlege = request.getParameter("h_le_ge");
		
		// 보내야할 값이 여러개 .. 어떡하지?
		// map 사용! 
		
//		Map<String, String> param = Map.of("key", col, "val", val);
//		Map<String, String> param = Map.of("key", col, "val", val, "gender", gender != null ? gender : "");
				
		Map<String, String> param = new HashMap<String, String>();
		
		param.put("key", col);
		param.put("val", val);
		
		param.put("gender", gender);
		
		param.put("le_ge", lege);
		param.put("salary", salary);
		
		param.put("h_le_ge", hlege);
		param.put("hireDate", hireDate);
		
		
				
				System.out.println(param);
				
		List<Map> result = new EmployeeService().searchEmp(param);
		
		request.setAttribute("list", result);
		
		request.setAttribute("searchType", col);
		request.setAttribute("searchKeyword", val);
		
		request.setAttribute("gender", gender);
		
		request.getRequestDispatcher("/views/result.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
