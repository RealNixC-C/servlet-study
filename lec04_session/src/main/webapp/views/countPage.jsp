<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>	당신은 이 페이지를 
	<strong> <%= request.getAttribute("count") %> </strong>번 방문했습니다.
	</p>
</body>
</html>