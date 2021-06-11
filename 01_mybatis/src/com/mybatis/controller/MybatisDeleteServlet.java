package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SqlSessionTemplate;
import com.mybatis.model.service.MybatisService;


@WebServlet("/delete")
public class MybatisDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisDeleteServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// map 이용 방식
//		Map<String, Object> param = new HashMap<>();
//		
//		SqlSessionTemplate.getParamMap(param, request.getParameterMap());
//			System.out.println(param);
		
		
		
		request.setCharacterEncoding("utf-8");
		
		
		
		String name = request.getParameter("name");
		
//				System.out.println(name);
		
		int result = new MybatisService().deleteStudent(name);
		
		response.getWriter().append(result > 0 ? "success" : "fail");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
