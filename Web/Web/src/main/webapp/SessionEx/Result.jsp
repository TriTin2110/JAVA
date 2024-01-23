<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1
	{
		text-align: center;
	}
</style>
</head>
<%
	int a = (int) session.getAttribute("num1");
	int b = (int) session.getAttribute("num2");
	int sum = a+b;
%>
<body>
	<h1><%=a %> +  <%=b %> = <%=sum%></h1>
</body>
</html>