<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원정보</h1>
	<ul>
		<li>${ e.emp_id }</li>
		<li>${ e.emp_name }</li>
		<li>${ e.phone }</li>
		<li>${ e.email }</li>
		<li>${ e.salary }</li>
		<li>${ e.bonus }</li>
		
		<ul>부서정보
			<li>${ e.dept.dept_id }</li>
			<li>${ e.dept.dept_title }</li>
			<li>${ e.dept.location_id }</li>
		</ul>
		
	</ul>
	
	
	<h3>게시글, 댓글 출력</h3>
	<table>
		<tr>
			<td>제목</td>
			<td>${ board.boardTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${ board.boardWriter }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${ board.boardDate }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${ board.boardContent }</td>
		</tr>
	</table>
	
	<ul>
		<c:forEach var="c" items="${ board.comments }">
			<li>${ c.commentWriter }   ${ c.commentContent }</li>
		</c:forEach>
	</ul>
	
	
</body>
</html>