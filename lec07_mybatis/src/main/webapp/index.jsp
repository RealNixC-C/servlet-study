<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스</title>
</head>
<body>
	<!-- 1. index.jsp에 목록조회 a태그 생성
		 2. 목록조회 요청을 받는 Servlet(Controller) -->
	<ol>
		<li>
			<a href="<c:url value='/student/list'/>">학생 목록 조회</a>
		</li>
	</ol>
	
	<form action="<c:url value='/student/search'/>" method="get">
		<input type="text" name="student_name">
		<input type="submit" value="이름 기준 검색">
	</form>
</body>
</html>