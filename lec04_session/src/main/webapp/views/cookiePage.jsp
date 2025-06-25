<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임</title>
</head>
<body>
	<form action="/saveNick" method="post"> 
	<label for="saveNick">저장할 닉네임: </label>
	<input type="text" id="saveNick" name="saveNick">
	<input type="submit" value="저장"> 
	</form>
	<form action="/removeNick" method="post">
	<input type="submit" value="닉네임 삭제"> 
	</form>

	<% 
		Cookie[] cookies = request.getCookies();
		String nickname = "_____";
		if(cookies != null) {
			for (Cookie c : cookies) {
				if("nickname01".equals(c.getName())) {
				nickname = c.getValue();
				break;
				}
			}
		}
	%>
	<p>닉네임 : <%= nickname %></p>
	
</body>
</html>