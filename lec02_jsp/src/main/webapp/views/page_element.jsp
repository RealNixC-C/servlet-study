<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이부분에 import문 작성 --%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 태그</title>
</head>
<body>
	<%
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("바나나");
	%>
	<h2>바구니 크기 : <%= list.size() %></h2>
	<%-- 1번째 방법 (유지보수 구림) --%>
	<ul>
		<li><%= list.get(0) %></li>
		<li><%= list.get(1) %></li>
	</ul>
	<%-- 2번째 방법 반복문 --%>
	<ul>
		<%
			for(int i = 0; i < list.size(); i ++) {
				out.println("<li>" + list.get(i) + "<li>");
			}
		%>
	</ul>
	<%-- 3번째 방법 중괄호 위치 중요 --%>
	<ul>
		<% for (int i = 0; i < list.size(); i++) {%>
			<li><%=list.get(i) %></li>
		<% } %>
	</ul>
</body>
</html>