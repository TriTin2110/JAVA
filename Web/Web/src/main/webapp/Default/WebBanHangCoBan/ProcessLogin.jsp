<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		if(user.equals("nguyentritin") && password.equals("123"))
		{
			String nextPage = "Store.jsp";
			response.sendRedirect(nextPage);
		}else{%>
			<h1>Đăng nhập không thành công!</h1>
	<%} %>
</body>
</html>