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
		
		// List<Map>으로 받음
//		List<Map> list = new EmployeeService().selectEmpList();
//		
//		request.setAttribute("list", list);
//		
//		request.getRequestDispatcher("/views/result.jsp").forward(request, response);
		
		
		
		// 210617 페이징처리해서 전체회원 가져오기
		
		 int cPage;
		 int numPerPage;
		 
		 try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		 } catch (NumberFormatException e) {
			cPage = 1;
		 }
		 
		 try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		 } catch (NumberFormatException e) {
			numPerPage = 5;
		 }
		 
		 
		 int totalData = new EmployeeService().selectEmpCount();
		 int totalPage = (int)Math.ceil((double)totalData / numPerPage);
		 
		 int pageBarSize = 5;
		 
		 int pageNo = ((cPage-1)/pageBarSize)*pageBarSize + 1;
		 int pageEnd = pageNo + pageBarSize-1;
		 
		 
		 
		 // 부트스트랩 사용!! 
		 String pageBar = "<ul class='pagination justify-content-center pagination-sm'>"; // class가 3개
		 
		 
		 
		 if(pageNo == 1) {
			 pageBar += "<li class='page-item disabled'>";
			 pageBar += "<a class='page-link' href='#' tabindex='-1'>이전</a>";
			 pageBar += "</li>";
		 } else {
			 pageBar += "<li class='page-item'>";
			 pageBar += "<a class='page-link' href='javascript:fn_paging(" + (pageNo-1) + ")' tabindex='-1'>이전</a>"; // ajax로 페이징처리하려면 이렇게 자바스크립트 사용해야함
			 pageBar += "</li>";
		 }
		 
		 
		 
		 
		 while( !(pageNo > pageEnd || pageNo > totalPage)) {
			if(pageNo == cPage) {
				 pageBar += "<li class='page-item active'>";
				 pageBar += "<a class='page-link'>" + pageNo + "</a>";
				 pageBar += "</li>";
			} else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='javascript:fn_paging(" + pageNo + ")'>" + pageNo + "</a>";
				pageBar += "</li>";
			}
			pageNo++;
		 }
		 
		 
		 if(pageNo > totalPage) {
			 pageBar += "<li class='page-item disabled'>";
			 pageBar += "<a class='page-link'>다음</a>";
			 pageBar += "</li>";
		 } else {
			 pageBar += "<li class='page-item'>";
			 pageBar += "<a class='page-link' href='javascript:fn_paging(" + pageNo + ")'>다음</a>";
			 pageBar += "</li>";
		 }
		 
		 pageBar += "</ul>";
		 
		 
		 pageBar += "<script>";
		 pageBar += "function fn_paging(cPage) {";
		 pageBar += "location.assign('" + request.getRequestURI() + "?cPage=' + cPage)"; // 마지막 cPage는 변수라서 ''로 감싸지 않음
		 pageBar += "}";
		 pageBar += "</script>";
		 
		 request.setAttribute("pageBar", pageBar);
		 
		 
		 List<Map> list = new EmployeeService().selectEmpList(cPage, numPerPage);

		 
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("/views/result.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
