<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        div
        {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 300px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <form action="ProcessLogin.jsp" method="post">
        <div>
            <label for="">Tài khoản</label>
            <input type="text" name="user" id="user">
        </div>

        <div>
            <label for="">Mật khẩu</label>
            <input type="password" name="password" id="password">
        </div>

        <input style="margin-top: 20px" type="submit" name="" id="">
    </form>
    
	
</body>
</html>