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
<title>mybatis 동적 Query</title>
</head>

<body>

	<h3><a href="${ path }/selectEmpList">전체회원조회</a></h3>
	
	<!-- 210617  -->
	
	<h3><a href="${ path }/selectOneEmp?no=200">사원조회</a></h3>
	
	<!-- db계정 WEB으로 바꿈 ( driver.properties )  -->
	<h3><a href="${ path }/boardView?no=36">게시글조회</a></h3>
	
</body>
</html>