<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생조회결과</h1>
	
	<!-- 210614 -->
	<h2>이메일로 학생 조회</h2>
	<form action="${ path }/searchStudent" method="post">
		<input type="text" name="email">
		<input type="submit" value="조회">
	</form>
	
	
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${ not empty list1 }">
			<c:forEach var="s" items="${ list1 }">
				<tr>
					<td><c:out value="${ s.studentNo }"/></td>
					<td><c:out value="${ s.studentName }"/></td>
					<td><c:out value="${ s.studentTel }"/></td>
					<td><c:out value="${ s.studentEmail }"/></td>
					<td><c:out value="${ s.studentAddr }"/></td>
					<td><c:out value="${ s.regDate }"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	
	<h2>map형식으로 받은 학생 리스트 출력</h2>
	
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		
		<c:if test="${ not empty list }">
			<c:forEach var="s" items="${ list }">
			
				<%-- <tr>
					<td><c:out value="${ s.STUDENT_NO }"/></td>
					<td><c:out value="${ s.STUDENT_NAME }"/></td>
					<td><c:out value="${ s.STUDENT_TEL }"/></td>
					<td><c:out value="${ s.STUDENT_EMAIL }"/></td>
					<td><c:out value="${ s.STUDENT_ADDR }"/></td>
					<td><c:out value="${ s.REG_DATE }"/></td>
				</tr> --%>
				
				
				<!--  또 다른 방법  -->
				<!--  컬럼명을 map의 key값으로, 한 행의 데이터를 value값으로 -->
				<tr>
					<td><c:out value="${ s['STUDENT_NO'] }"/></td>
					<td><c:out value="${ s['STUDENT_NAME'] }"/></td>
					<td><c:out value="${ s['STUDENT_TEL'] }"/></td>
					<td><c:out value="${ s['STUDENT_EMAIL'] }"/></td>
					<td><c:out value="${ s['STUDENT_ADDR ']}"/></td>
					<td><c:out value="${ s['REG_DATE'] }"/></td>
				</tr>
				
				
			</c:forEach>
		</c:if>
	</table>
	
	
</body>
</html>