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
	
	<h3>이름으로 검색한 결과</h3>
	<c:if test="${ not empty list_name }">
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
				<c:forEach var="m" items="${ list_name }">
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
		</table>
	</c:if>
		<c:if test="${ empty list_name }">
			<p>검색 결과가 없습니다</p>
		</c:if>
	
	<h3>주소로 검색한 결과</h3>
	<c:if test="${ not empty list_addr }">
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
				<c:forEach var="m" items="${ list_addr }">
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
		</table>
	</c:if>
		<c:if test="${ empty list_addr }">
			<tr>
				<td>검색 결과가 없습니다</td>
			</tr>
	</c:if>
	
	<h3>아이디로 검색한 결과</h3>
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
		<c:if test="${ not empty idSearchResult }">
				<tr>
					<td><c:out value="${ idSearchResult.userid }"/></td>
					<td><c:out value="${ idSearchResult.username }"/></td>
					<td><c:out value="${ idSearchResult.gender }"/></td>
					<td><c:out value="${ idSearchResult.age }"/></td>
					<td><c:out value="${ idSearchResult.email }"/></td>
					<td><c:out value="${ idSearchResult.phone }"/></td>
					<td><c:out value="${ idSearchResult.address }"/></td>
					<td><c:out value="${ idSearchResult.hobby }"/></td>
					<td><c:out value="${ idSearchResult.enrolldate }"/></td>
				</tr>
		</c:if>
		<c:if test="${ empty idSearchResult }">
			<tr>
				<td>검색 결과가 없습니다</td>
			</tr>
		</c:if>
	</table>
</body>
</html>