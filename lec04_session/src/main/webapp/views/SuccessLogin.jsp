<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = "";
	if (session != null) {
		Account account = (Account) session.getAttribute("account");
				name = account.getName();
	}
	if (session == null) {
		name = "비어있습니다";
	}
	%>
	<p><%=name%>님 환영합니다!</p>
	<a href="/logout">로그아웃</a>

</body>
</html>