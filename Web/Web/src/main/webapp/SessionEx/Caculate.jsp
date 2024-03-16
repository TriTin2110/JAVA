<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		display: flex;
		flex-direction: row;
		justify-content: center;
		height: 100%;
	}
</style>
</head>
<body>

<form action="..//transport" method="get">
<table>
		<tr>
			<td>Số thứ nhất</td>
			<td>
				<input id="input-1" placeholder="Số thứ 1" name="number1" type="text"/>
			</td>
		</tr>
		
		<tr>
			<td>Số thứ hai</td>
			<td>
				<input id="input-1" placeholder="Số thứ 2" name="number2" type="text"/>
			</td>
		</tr>
		
		<tr style="text-align: center;">	
			<td colspan="2">
				<input type="submit" value="Tính tổng"/>
			</td>
		</tr>
	</table>
</form>
	
</body>
</html>