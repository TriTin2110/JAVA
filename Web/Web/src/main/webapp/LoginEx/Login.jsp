<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		width: 300px;
		margin-top: 20px;
	}
</style>
</head>
<body>
	<form action="..\\LoginExController" method="post">
		<h1>Chương trình đăng nhập</h1>
		<div><label for="input-1">User:</label>
		<input name="user" placeholder="user" type="text"/></div>
		
		
		<div><label for="input-2">Password:</label>
		<input name="password" placeholder="password" type="password"/></div>		
		
		<div><input type="submit" value="Đăng nhập" id="button-1"/></div>
		
	</form>
</body>
</html>