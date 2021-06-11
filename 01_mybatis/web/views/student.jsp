<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>가입일</th>
		</tr>
		<tr>
			<%-- <td>${ student.student_No }</td>
			<td>${ student.student_Name }</td>
			<td>${ student.student_Tel }</td>
			<td>${ student.student_Email }</td>
			<td>${ student.student_Addr }</td>
			<td>${ student.reg_Date }</td> --%>
			
			<td>${ student.studentNo }</td>
			<td>${ student.studentName }</td>
			<td>${ student.studentTel }</td>
			<td>${ student.studentEmail }</td>
			<td>${ student.studentAddr }</td>
			<td>${ student.regDate }</td>
		</tr>
	</table>
</body>
</html>