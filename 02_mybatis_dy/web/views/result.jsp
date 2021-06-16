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

<style>
	td{
		border : solid 1px pink;
		text-align : center;
	}
	table{
		border-collapse : collapse;
	}
	th{
		background-color : pink;
		border : solid 1px black;
		text-align : center;
	}
	
</style>
</head>

<body>

	<h1>사원 조회</h1>
	
	<div id="search-container">
	
		<form action="${ path }/searchEmp" method="post">
		
		<table>
			<tr>
				<td>
					검색타입<select name="searchType">
							<%-- <option value="검색 타입" disabled selected>검색 타입</option>
							<option value="emp_id" <c:out value= "${ not empty requestScope.searchType and requestScope.searchType == 'emp_id' ? 'selected' : '' }"/> >사번</option>
							<option value="emp_name" <c:out value= "${ not empty requestScope.searchType and requestScope.searchType == 'emp_name' ? 'selected' : '' }"/>>이름</option>
							<option value="email" <c:out value= "${ not empty requestScope.searchType and requestScope.searchType == 'email' ? 'selected' : '' }"/>>이메일</option>
							<option value="phone" <c:out value= "${ not empty requestScope.searchType and requestScope.searchType == 'phone' ? 'selected' : '' }"/>>전화번호</option> --%>
							<option value="검색 타입" disabled selected>검색 타입</option>
							<option value="emp_id">사번</option>
							<option value="emp_name">이름</option>
							<option value="email">이메일</option>
							<option value="phone">전화번호</option>
					</select>
					<br>
					검색어<input type="search" name="searchKeyword" value="${ requestScope.searchKeyword }">
				</td>
			</tr>
			<tr>
				
				<td>
					급여
					<input type="number" name="salary" min="1800000" step="100000">
					<label><input type="radio" name="le_ge" value="le">이하</label>
					<label><input type="radio" name="le_ge" value="ge">이상</label>
				</td>
			</tr>
			
			<tr>
				<td>
					성별
					<%-- <label><input type="radio" name="gender" value="F" <c:out value="${ requestScope.gender != null and requestScope.gender eq 'F' ? 'checked' : '' }"/> >여</label>
					<label><input type="radio" name="gender" value="M" <c:out value="${ requestScope.gender != null and requestScope.gender eq 'M' ? 'checked' : '' }"/> >남</label> --%>
					<label><input type="radio" name="gender" value="F">여</label>
					<label><input type="radio" name="gender" value="M">남</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					입사일
					<input type="date" name="hiredate">
					<label><input type="radio" name="h_le_ge" value="le">이전</label>
					<label><input type="radio" name="h_le_ge" value="ge">이후</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="조회"> 
				</td>
			</tr>
			</table>
		</form>
	</div>
	
	<br>
	
	<table>
		<tr>
			<th>사원번호</th>
			<th>직원명</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직급코드</th>
			<th>급여등급</th>
			<th>급여</th>
			<th>보너스율</th>
			<th>관리자사번</th>
			<th>입사일</th>
		<!-- <th>퇴사일</th>
			<th>재직여부</th>	 -->
			<th>성별</th>	
		</tr>
	
		<c:if test="${ not empty requestScope.list }">
			
				<c:forEach var="e" items="${ requestScope.list }" varStatus="vs">
					<tr>
						
						<%-- <td><c:out value="${ e.empId }"/></td>
						<td><c:out value="${ e.empName }"/></td>
						<td><c:out value="${ e.empNo }"/></td>
						<td><c:out value="${ e.email }"/></td>
						<td><c:out value="${ e.phone }"/></td>
						<td><c:out value="${ e.deptCode }"/></td>
						<td><c:out value="${ e.jobCode }"/></td>
						<td><c:out value="${ e.salLevel }"/></td>
						<td><fmt:formatNumber value="${ e.salary }" type="currency"/></td>
						<td><fmt:formatNumber value="${ e.bonus }" type="percent"/></td>
						<td><c:out value="${ e.managerId }"/></td>
						<td><fmt:formatDate value="${ e.hireDate }" type="date" dateStyle="long"/></td>
						<td><fmt:formatDate value="${ e.hireDate }" type="date" pattern="yyyy/MM/dd"/></td>
						<td><fmt:formatDate value="${ e.entDate }" type="date" dateStyle="short"/></td>
						<td><c:out value="${ e.entYn }"/></td>
						 --%>
						 
						 <td><c:out value="${e['EMP_ID'] }"/></td>
						<td><c:out value="${e['EMP_NAME'] }"/></td>
						<td><c:out value="${e['EMP_NO'] }"/></td>
						<td><c:out value="${e['EMAIL'] }"/></td>
						<td><c:out value="${e['PHONE'] }"/></td>
						<td><c:out value="${e['DEPT_CODE'] }"/></td>
						<td><c:out value="${e['JOB_CODE'] }"/></td>
						<td><c:out value="${e['SAL_LEVEL'] }"/></td>
						<td><fmt:formatNumber value="${e['SALARY'] }" type="currency"/></td>
						<td><fmt:formatNumber value="${e['BONUS'] }" type="percent"/></td>
						<td><c:out value="${e['MANAGER_ID'] }"/></td>
						<td><fmt:formatDate value="${e['HIRE_DATE'] }" pattern="yyyy년 MM월 dd일 E요일"/></td>
						<td><c:out value="${e['GENDER'] }"/></td>
					</tr>
				</c:forEach>
			
		</c:if>
	</table>
</body>
</html>