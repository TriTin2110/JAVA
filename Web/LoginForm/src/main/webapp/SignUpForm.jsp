<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="UserForm">
		<h1>Đăng ký tài khoản</h1>
		<form action="ProcessSignUp" method="post">
			<div class="FormContent">
				<label for="userName">Tài khoản:</label>
				<input id="userName" name="userName" id="userName" type="text"/>
			</div>
				
			<div class="FormContent">
				<label for="userPassword">Mật khẩu:</label>
				<input id="userPassword" name="userPassword" type="password"/>
			</div>
			<div style="margin-bottom: 20px;">
				<input type="submit" value="Đăng ký" onclick="checking()"/>
			</div>
			<div >
				<a href="LoginForm.jsp">Đăng nhập</a>
			</div>
		</form>
	</div>
</body>
</html>