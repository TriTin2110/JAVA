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
		<h1>Đăng nhập</h1>
		<form action="ProcessLogin" method="post">
			<div class="FormContent">
				<label for="userName">Tài khoản:</label>
				<input id="userName" name="userName" type="text"/>
			</div>
				
			<div class="FormContent">
				<label for="userPassword">Mật khẩu:</label>
				<input id="userPassword" name="userPassword" type="password"/>
			</div>
			<div style="margin-bottom: 20px;">
				<input type="submit" value="Đăng nhập"/>
			</div>
			<div >
				<a href="SignUpForm.jsp">Đăng ký</a>
			</div>
		</form>
	</div>
</body>
</html>