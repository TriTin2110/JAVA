<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td, tr, th {
  	border: 1px solid black;
}

table {
  border-collapse: collapse;
  width: 100%;
}

td {
  text-align: center;
}
</style>
</head>
<body>
	<%
	//productResult = request.getAttribute(product)
	String[] product = { "productId", "productName", "inputPrice", "outputPrice", "dateExpired", "productType",
			"description", "errorMessage" };
	String[] productResult = new String[product.length];

	for (int i = 0; i < product.length; i++) {
		productResult[i] = (String) request.getAttribute(product[i]);
	}

	for (int i = 0; i < product.length; i++) {
		if (productResult[i] == null)
			productResult[i] = "";
	}
	%>

	<table id="table-1" style="">
		<thead>
			<tr>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Giá nhập vào</th>
				<th>Giá nhập bán</th>
				<th>Ngày hết hạn</th>
				<th>Loại hàng</th>
				<th>Mô tả</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=productResult[0]%></td>
				<td><%=productResult[1]%></td>
				<td><%=productResult[2]%></td>
				<td><%=productResult[3]%></td>
				<td><%=productResult[4]%></td>
				<td><%=productResult[5]%></td>
				<td><%=productResult[6]%></td>
				<td><%=productResult[7]%></td>
			</tr>
		</tbody>
	</table>
</body>
</html>