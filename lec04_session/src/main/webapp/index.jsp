<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<% Account account = (Account)session.getAttribute("account"); %>
	<% if(account == null) {%>
	<form action="/login" method="post">
		<label for="user_id">아이디 : </label> 
		<input type="text" id="user_id"	name="user_id"> 
		<br> 
		<label for="user_pw">비밀번호 :</label> 
		<input type="password" id="user_pw" name="user_pw"> 
		<input type="submit" value="로그인">
	</form>
	<% } else { %>
	<p></p> <%= account.getName() %>님 환영합니다!
	<a href="/logout">로그아웃</a>
	<%} %>
	<%-- 쿠키는 브라우저를 닫는다고 사라지지 않음 --%>
	<h1>Cookie</h1>
	<ul>
		<li><a href="/makeCookie">쿠키 생성</a></li>
		<li><a href="/editCookie">쿠키 수정</a></li>
		<li><a href="/deleteCookie">쿠키 삭제</a></li>
		<li><a href="/practiceCookie">닉네임 생성</a></li>
		<li><a href="/changePage">방문 횟수 추적하기</a></li>
	</ul>
	<h2>현재 쿠키 값 확인</h2>
	<%
	// 1. 클라이언트가 보낸 쿠키 배열 가져오기
	Cookie[] cookies = request.getCookies();
	String userId = "쿠키 없음";

	// 2. 쿠키 배열에서 원하는 쿠키 찾기
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("user_id")) {
		userId = c.getValue();
		break;
			}
		}
	}
	%>
	<p>
		user_id 쿠키값 :
		<%=userId%></p>

	<h1>Session</h1>
	<ol>
		<li><a href="/createSession">세션 생성</a></li>
		<li><a href="/updateSession">세션 수정</a></li>
		<li><a href="/removeSession">세선 삭제</a></li>
	</ol>

	<%
	String memberId = "세션 없음";
	if (session != null) {
		if (session.getAttribute("member_id") != null) {
			memberId = (String) session.getAttribute("member_id");
		}
	}
	%>
	<p>세션 정보 :	<%=memberId%></p>
	
	<a href="/productList">상품 목록</a>
	
</body>
</html>