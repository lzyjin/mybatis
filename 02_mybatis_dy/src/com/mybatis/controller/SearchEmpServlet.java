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
		
		//210617 
		String[] deptcode = request.getParameterValues("deptcode");
		
		// 보내야할 값이 여러개 .. 어떡하지?
		// map 사용! 
		
//		Map<String, String> param = Map.of("key", col, "val", val);
//		Map<String, String> param = Map.of("key", col, "val", val, "gender", gender != null ? gender : "");
				
//		Map<String, String> param = new HashMap<>();
		
		Map<String, Object> param = new HashMap<>();
		
		param.put("key", col);
		param.put("val", val);
		
		param.put("gender", gender);
		
		param.put("le_ge", lege);
		param.put("salary", salary);
		
		param.put("h_le_ge", hlege);
		param.put("hireDate", hireDate);
		
		// 210617
		// Map의 밸류로 배열을 담기 위해 param의 제네릭타입을 String,Object로 바꾼다
		
		param.put("deptcode", deptcode);
		
				System.out.println(param);
		
				
				
				// 실행해보기 
		String depts = String.join(",", deptcode);
		
				System.out.println(depts);
				
		// 페이징처리		
		int cPage;
		int numPerPage;

		
		// "?searchType=" + col + "&searchKeyword=" + val + "&gender=" + gender + "&salary=" + salary + "&le_ge=" + le_ge + "&hiredate=" + hiredate + "&h_le_ge=" + h_le_ge + "&deptcode=" + deptcode
		
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
		
		int totalData = new EmployeeService().selectSearchEmpCount(param);
		int totalPage = (int) Math.ceil((double)totalData/numPerPage);
		
//				System.out.println("totalData : " + totalData);
		
		int pageBarSize = 5;
		
		int pageNo =  ( (cPage-1)/pageBarSize ) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize-1;
		
		
		
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
		 pageBar += "location.assign('" + request.getRequestURI() + "?cPage=' + cPage" +
																	"&searchType=" + col + 
		 															"&searchKeyword=" + val + 
		 															"&gender=" + gender + 
		 															"&salary=" + salary + 
		 															"&le_ge=" + lege + 
		 															"&hiredate=" + hireDate + 
		 															"&h_le_ge=" + hlege 
//		 															"&deptcode=" + deptcode 
		 																					+ "')"; // 마지막 cPage는 변수라서 ''로 감싸지 않음
		 pageBar += "}";
		 pageBar += "</script>";
		 
		
		param.put("cPage", cPage);
		param.put("numPerPage", numPerPage);
		 
		 
		List<Map> result = new EmployeeService().searchEmp(param);
		
		request.setAttribute("pageBar", pageBar);
		
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
