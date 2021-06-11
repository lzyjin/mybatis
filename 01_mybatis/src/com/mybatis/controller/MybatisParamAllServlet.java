package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.vo.Student;


@WebServlet("/paramAll")
public class MybatisParamAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MybatisParamAllServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		Student s = new Student();
		
		s.setStudentName(name);
		s.setStudentEmail(email);
		s.setStudentAddr(addr);
		s.setStudentTel(phone);
		
		// builder 이용
		// 필요한값만 쓰면 된다. 안쓴 값은 default(0또는 null)로 들어감
//		s = Student.builder().studentName(name)
//							 .studentEmail(email)
//							 .studentTell(phone)
//							 .studentAddr(addr).build();
		
		// builder 패턴의 장점 
		// 개수가 다른 생성자쓰려면 각각 만들어줘야하는데 builder패턴은 그 과정 없이 바로 생성자를 쓸 수 있다 
		
		
		
		
		Map<String, String[]> param = request.getParameterMap();
		
		Map<String, String> param2 = new HashMap<>();
		
//		param2.put("name", param.get("name")[0]);
//		param2.put("phone", param.get("phone")[0]);
//		param2.put("email", param.get("email")[0]);
//		param2.put("addr", param.get("addr")[0]);
		
		for(String key : param.keySet()) {
			param2.put(key, param.get(key)[0]);
		};
		
		
		
		
		//mybatis 데이터 전송
//		response.getWriter().append(new MybatisService().insertParamAll(s) > 0 ? "success" : "fail");
		
		response.getWriter().append(new MybatisService().insertParamMap(param2) > 0 ? "success" : "fail");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
