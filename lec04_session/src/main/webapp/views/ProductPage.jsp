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
<title>상품 목록</title>
</head>
<body>

<%
	List<Product> list = (ArrayList<Product>)session.getAttribute("productList");
%>

	<form action="/addToCart" method="post">
		<select id="products" name="product">
		<% for (Product p : list) {%>
		  <option value=<%= p.getCode() %>><%= p.getName() %></option>
		<% }%>
		</select>
		<input type="submit" value="장바구니에 추가">
	</form>
	<form action="/cartList" method="get">
		<input type="submit" value="장바구니 목록">
	</form>
	
	
	
	
</body>
</html>