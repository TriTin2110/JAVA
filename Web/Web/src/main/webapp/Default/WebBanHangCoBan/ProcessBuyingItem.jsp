<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		tr
		{
			display: flex;
			flex-direction: row;
			justify-content: space-between;
			width: 300px;
		}
	</style>
</head>
<body>
	<%
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String monitor = request.getParameter("monitor");
		String selectItem = request.getParameter("selectItem");
		double total = 0;
		
		//Xử lý mua CPU
		double cpuPrice = 0;
		if(cpu!=null)	//Người dùng đã chọn mua CPU
		{
			switch(cpu){
			case "Core I9":
				cpuPrice = 15000000;
				break;
			case "Core I7":
				cpuPrice = 12500000;
				break;
			case "Core I5":
				cpuPrice = 8000000;
				break;
			}
			total+=cpuPrice;
		}
		
		//Xử lý mua Ram
		double ramPrice = 0;
		if(ram!=null)	//Người dùng đã chọn mua CPU
		{
			switch(ram){
			case "8GB":
				ramPrice = 800000;
				break;
			case "16GB":
				ramPrice = 1200000;
				break;
			case "32GB":
				ramPrice = 2500000;
				break;
			}
			total += ramPrice;
		}
		
		//Xử lý mua monitor
		double monitorPrice = 0;
		if(monitor != null)
		{
			monitorPrice = 2000000;
			total+= 2000000;
		}
		
		//Xử lý mua thêm
		double moreItem = 0;
		if(selectItem != null)
		{
			if(selectItem.equals("Scanner"))
			{
				moreItem = 8000000;
				total+= 8000000;
			}
				
			else if(selectItem.equals("Printer"))
			{
				moreItem = 18000000;
				total+= 18000000;
			}
		}
		
	%>
	
	<div>
		<h2>Tổng đơn hàng của bạn là:</h2>
		
		<table>
			<tr>
				<td>Sản phẩm</td>
				<td>Giá</td>
			</tr>
			<%if(cpu !=null) {%>
				<tr>
					<td><%=cpu%></td>
					<td><%=Math.round(cpuPrice)%></td>
				</tr>
			
			<%} if(ram !=null){%>
				<tr>
					<td><%=ram%></td>
					<td><%=Math.round(ramPrice)%></td>
				</tr>
			
			<%} if(monitor !=null){%>	
				<tr>
					<td>Monitor:</td>
					<td><%=Math.round(monitorPrice)%></td>
				</tr>
			
			<%} if(selectItem !=null){%>
				<tr>
					<td><%=selectItem%></td>
					<%if(moreItem != 0) {%>
						<td><%=Math.round(moreItem)%></td>
					<%} %>
				</tr>
			<%} %>
			<tr>
				<td>Tổng tiền là: <%=Math.round(total)%></td>
			</tr>
		</table>
	</div>
</body>
</html>