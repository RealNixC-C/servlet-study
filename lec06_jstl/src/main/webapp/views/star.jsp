<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별찍기</title>
</head>
<body>
	
	<c:set var="star" value="⭐"/>
	<c:forEach var="i" begin="1" end="${starNum}" step="1">
		<c:forEach var="j" begin="1" end="${i}" step="1">
			${star}
		</c:forEach>
		<br>
	</c:forEach>
	
</body>
</html>