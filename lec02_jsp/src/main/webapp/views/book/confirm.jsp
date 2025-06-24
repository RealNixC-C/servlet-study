<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 미리 변수에 담기 --%>
<%-- 반환 타입이 객체이므로 변환할것 --%>
<%
	String phone = (String)request.getAttribute("phone");
	String email = (String)request.getAttribute("email");
	String bookTitle = (String)request.getAttribute("bookTitle");
	int period = (int)request.getAttribute("period");
	int bookPrice = (int)request.getAttribute("bookPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명: <%= request.getAttribute("name") %></li>
		<li>전화번호: <%= phone %></li>
		<li>이메일: <%= email %></li>
	</ul>
	
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= bookTitle %></li>
		<li>대출 기간: <%= period %>일</li>
	</ul>

	<h3>대출 금액: <%= bookPrice %>원</h3>

</body>
</html>