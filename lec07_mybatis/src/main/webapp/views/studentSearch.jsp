<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="s" items="${list }">
		<p>번호 : ${s.studentNo }</p>
		<p>이름 : ${s.studentName }</p>
		<p>나이 : ${s.studentAge }</p>
	</c:forEach>
</body>
</html>