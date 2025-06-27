<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<label for="visitor_name">이름</label>
	<input type="text" id="visitor_name">
	<label for="visitor_message">메세지</label>
	<input type="text" id="visitor_message">
	<input type="button" id="visitor_register" value="등록">
	<ul id="message_list">
		
	</ul>

	<script>
		$(document).ready(function () {
			$("#visitor_register").click(function () {
				const visitorName = $("#visitor_name").val();
				const visitorMsg = $("#visitor_message").val();
				console.log(visitorName);
				console.log(visitorMsg);
				$.ajax({
					url : "/VisitorList",
					type : "post",
					data : {
						visitorName : visitorName,
						visitorMsg : visitorMsg
					},
					datatype : "json",
					success : function(data){
						console.log("servlet으로부터 데이터 받아옴")
						const name = data.visitorName;
						const msg = data.visitorMsg;
						const date = data.nowDate;
						console.log(name);
						console.log(msg);
						console.log(date);
						if(data != null) {
							$("#message_list").append("<li>방문자 이름 : " + name + "메세지 : " + msg + "등록날짜 : " + date + "</li>");
						}
					}
				})
			});
		});
	</script>

</body>
</html>