<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="java.util.ArrayList" 	
	import="java.util.List"
	import="com.gn.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 장바구니 목록</title>
</head>
<body>

	<% 
	List<Product> list = (ArrayList<Product>)session.getAttribute("myList");
	%>	
	<% for (Product p : list) {%>
		<p>상품 이름: <%= p.getName() %>, 상품 가격: <%= p.getPrice() %>원</p><br>
	<% } %>
</body>
</html>