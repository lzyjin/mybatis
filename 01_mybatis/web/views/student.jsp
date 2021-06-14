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
	
	
	<h3>Map 출력</h3>
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
			<!-- mapper에서 select태그가 map으로 반환할때 키값을 대문자 컬럼명으로 반환하므로, 대소문자까지 맞춰줘야함  -->
			<td>${ student.STUDENT_NO }</td>
			<td>${ student.STUDENT_NAME }</td>
			<td>${ student.STUDENT_TEL }</td>
			<td>${ student.STUDENT_EMAIL }</td>
			<td>${ student.STUDENT_ADDR }</td>
			<td>${ student.REG_DATE }</td> 
		</tr>
	</table>
</body>
</html>