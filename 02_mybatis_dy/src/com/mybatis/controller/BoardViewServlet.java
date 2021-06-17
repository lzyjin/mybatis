package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmployeeService;
import com.mybatis.model.vo.Board;


@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardViewServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		Board b = new EmployeeService().selectBoard(no);
		
				System.out.println("b : " + b);
				System.out.println("b.getComments : " + b.getComments());
				System.out.println("b.getComments.size : " + b.getComments().size());
				
				
		request.setAttribute("board", b);	
		
		request.getRequestDispatcher("/views/emp/test.jsp").forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
