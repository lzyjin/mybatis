<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>전체 회원 목록(vo)</h4>
	<table>
	
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>취미</th>
			<th>가입날짜</th>
		</tr>
		<c:if test="${ not empty list }">
			<c:forEach var="m" items="${ list }">
				<tr>
					<td><c:out value="${ m.userid }"/></td>
					<td><c:out value="${ m.username }"/></td>
					<td><c:out value="${ m.gender }"/></td>
					<td><c:out value="${ m.age }"/></td>
					<td><c:out value="${ m.email }"/></td>
					<td><c:out value="${ m.phone }"/></td>
					<td><c:out value="${ m.address }"/></td>
					<td><c:out value="${ m.hobby }"/></td>
					<td><c:out value="${ m.enrolldate }"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<h4>전체 회원 목록(map)</h4>
	<table>
	
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>취미</th>
			<th>가입날짜</th>
		</tr>
		<c:if test="${ not empty list2 }">
			<c:forEach var="m" items="${ list2 }">
				<tr>
					<td><c:out value="${ m['USERID'] }"/></td>
					<td><c:out value="${ m['USERNAME'] }"/></td>
					<td><c:out value="${ m['GENDER'] }"/></td>
					<td><c:out value="${ m['AGE'] }"/></td>
					<td><c:out value="${ m['EMAIL'] }"/></td>
					<td><c:out value="${ m['PHONE'] }"/></td>
					<td><c:out value="${ m['ADDRESS'] }"/></td>
					<td><c:out value="${ m['HOBBY'] }"/></td>
					<td><c:out value="${ m['ENROLLDATE'] }"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>