<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis 사용하기</title>
</head>

<body>

	<h2>마이바티스</h2>
	<a href="${path }/insertStudentTest">학생입력</a>
	
	
	<!-- 210611 금 -->
	<h3>학생 이름 등록하기</h3>
	
	<form action="${ path }/paramMybatis" method="post">
		<input type="text" name="name">
		<input type="submit" value="이름저장">
	</form>
	
	
	
	
	<h3>학생 이메일 등록하기</h3>
	
	<form action="${ path }/insertEmail" method="post">
		<input type="email" name="email">
		<input type="submit" value="이메일등록">
	</form>
	
	
	
	<h3>여러개의 파라미터 저장하기</h3>
	
	<form action="${ path }/paramAll" method="post">
		이름 <input type="text" name="name">
		전화번호 <input type="text" name="phone">
		이메일 <input type="email" name="email">
		주소 <input type="text" name="addr">
		<input type="submit" value="학생정보등록">
	</form>
	
	
	
	
	<h3>등록된 회원의 이름, 주소, 전화번호를 받아서 수정해보자</h3>
	
	<%-- <form action="${ path }/update" method="post">
		이름 <input type="text" name="name" value="">
		주소 <input type="text" name="addr" value="">
		전화번호 <input type="text" name="phone" value="">
		<input type="submit" value="정보수정">
	</form> --%>
	
	
	
	<h3>등록된 회원의 이름을 받아 삭제를 해보세요</h3>
	
	<form action="${ path }/delete" method="post">
		이름 <input type="text" name="name" value="">
		<input type="submit" value="회원삭제">
	</form>
	
	
	
	<h1>DB에 저장된 데이터 조회하기</h1>
	
	<p>select문을 사용해보자</p>
	
	<ul>
		<li>1개의 row만 가져오는 select문</li>
		<li>여러개의 row들을 가져오는 select문</li>
		<li>여러개의 row들을 부분별로 가져오는 select문 ( paging 처리 )</li>
	</ul>
	
	
	
	<h2>기본 select문을 이용해서 데이터 가져오기</h2>
	
	<h3>student 테이블의 학생 수 가져오기</h3>
	
	<h4><a href="${ path }/selectCount">전체 학생수 표시</a></h4>
	
	<h4><a href="${ path }/selectStudent?no=1">1번학생 호출</a></h4>
	
	
	<!-- 210614 -->
	<h4><a href="${ path }/selectStudentlist">전체학생조회</a></h4>
	
	
	
	<h2>vo객체를 이용하지 않고 데이터 가져오기</h2>
	
	<p>
		vo객체를 MAP객체로 대체해서 DB의 데이터를 가져올 수 있다
		Map : key가 컬럼명, value가 값
	</p>
	
	<h4><a href="${ path }/selectStudentMap?no=1">Map형식으로 학생 1명 조회</a></h4>
	
	<h4><a href="${ path }/selectStudentListMap">Map형식으로 전체 학생 조회</a></h4>
	
	
	
	
</body>
</html>