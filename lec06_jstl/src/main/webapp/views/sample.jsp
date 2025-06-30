<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample page</title>
</head>
<body>

	<c:set var="dark" value="dark"/>
	<c:set var="light" value="light"/>

	<c:choose>
		<c:when test="${theme eq dark}">
			<div style="background-color: #222; color: white; min-height: 100vh; padding: 2rem; text-align: center;">
			    <h2 style="font-size: 2rem;">🌙 다크모드가 적용되었습니다.</h2>
			    <p style="font-size: 1.2rem;">눈의 피로를 줄이고 차분한 분위기를 제공합니다.</p>
			</div>
		</c:when>
		<c:when test="${theme eq light}">
			<div style="background-color: #f0f0f0; color: #222; min-height: 100vh; padding: 2rem; text-align: center;">
			    <h2 style="font-size: 2rem;">☀️ 라이트모드가 적용되었습니다.</h2>
			    <p style="font-size: 1.2rem;">밝고 선명한 화면을 제공합니다.</p>
			</div>
		</c:when>
	</c:choose>

</body>
</html>