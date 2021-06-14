<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mtybatis 연습 과제</title>
</head>
<body>
	<h1>1. 전체회원 조회</h1>
	<p><a href="${ path }/selectMemberList">전체회원조회(vo 이용)</a></p>
	<p><a href="${ path }/selectMemberList">전체회원조회(map 이용)</a></p>
	
	<h1>2. 회원 검색 </h1>
	<p>이름으로 검색</p>
	<form action="${ path }/searchMemberName">
		이름<input type="text" name="name">
		<input type="submit" value="검색">
	</form>
	
	<p>주소로 검색</p>
	<form action="${ path }/searchMemberAddress">
		주소<input type="text" name="addr">
		<input type="submit" value="검색">
	</form>
	
	
	<h1>3.아이디 조회</h1>
	<form action="${ path }/searchMemberId">
		아이디<input type="text" name="id">
		<input type="submit" value="검색">
	</form>
	
	
	<h1>4. 회원 등록</h1>
	<form action="${ path }/insertMember" method="post">
		<input type="text" name="id" placeholder="아이디" required><br>
		<input type="text" name="pw" placeholder="비밀번호" required><br>
		<input type="text" name="username" placeholder="이름" required><br>
		<input type="text" name="gender" placeholder="성별(M / F)" required><br>
		<input type="text" name="age" placeholder="나이" required><br>
		<input type="email" name="email" placeholder="이메일" required><br>
		<input type="text" name="phone"  placeholder="전화번호" required><br>
		<input type="text" name="addr" placeholder="주소" required><br>
		<input type="text" name="hobby" placeholder="취미(,로 여러개 작성)" required><br>
		<input type="submit" value="등록">
	</form>
	
	<h1>5. 회원 수정</h1>
	<form action="${ path }/updateMember" method="post">
		<input type="text" name="id" placeholder="아이디" required><br>
		<input type="text" name="usernamne" placeholder="이름" required><br>
		<input type="text" name="age" placeholder="나이" required><br>
		<input type="text" name="email" placeholder="이메일" required><br>
		<input type="submit" value="수정">
	</form>
	
	
	<h1>6 회원 삭제</h1>
	<form action="${ path }/deleteMember" method="post">
		삭제할 회원의 아이디<input type="text" name="id">
		<input type="submit" value="삭제">
	</form>
</body>
</html>