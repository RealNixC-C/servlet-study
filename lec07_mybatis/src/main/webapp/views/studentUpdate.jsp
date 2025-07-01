<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
</head>
<body>
	<form action="/student/update" method="post">
		<!-- studentNo는 사용자가 바꾸면 안되는정보 -->
	    <input type="hidden" name="studentNo" value="${student.studentNo}">
	    이름 : <input type="text" name="studentName" value="${student.studentName}"><br>
	    나이 : <input type="number" name="studentAge" value="${student.studentAge}"><br>
	    <input type="submit" value="수정">
	</form>
</body>
</html>