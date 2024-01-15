<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<style>
.rq {
	color: red;
}
</style>
</head>

<body>
	<%
	
		//productResult = request.getAttribute(product)
		String[] product = {"productId", "productName", "inputPrice", "outputPrice", "dateExpired", "productType", "description", "errorMessage"};
		String[] productResult = new String[product.length];

		for(int i = 0; i <product.length; i++)
		{
			productResult[i] = (String) request.getAttribute(product[i]);
		}
		
		for(int i = 0; i <product.length; i++)
		{
			if(productResult[i] == null)
				productResult[i] = "";
		}
	%>

	<div class="container mt-3">
		<form class="row" action="CheckingInputProduct" method="post">
			<div class="col-12 row">
				<div class="col-6">
					<label for="validationServer01">Mã sản phẩm<span class="rq">*</span></label>
					<input type="text" class="form-control is-valid" id="ProductID"
						name="ProductID" placeholder="Mã sản phẩm" value="<%=productResult[0]%>" required>
				</div>

				<div class="col-6">
					<label for="validationServer01">Tên sản phẩm<span
						class="rq">*</span></label> <input type="text"
						class="form-control is-valid" id="ProductName" name="ProductName"
						placeholder="Tên sản phẩm" value="<%=productResult[1]%>" required>
				</div>
			</div>

			<div class="col-12 row mt-3">
				<div class="col-6">
					<label for="validationServer01">Giá nhập<span class="rq">*</span></label>
					<input type="number" class="form-control is-valid" id="inputPrice"
						name="inputPrice" value="<%=productResult[2]%>" required>
				</div>

				<div class="col-6">
					<label for="validationServer01">Giá bán<span class="rq">*</span></label>
					<input type="number" class="form-control is-valid" id="outputPrice"
						name="outputPrice" value="<%=productResult[3]%>" required>
				</div>
			</div>

			<div class="col-12 row mt-3">
				<div class="col-6">
					<label for="validationServer01">Ngày hết hạn</label> <input
						type="date" class="form-control is-valid" id="dateExpired"
						name="dateExpired" value="<%=productResult[4]%>">
				</div>

				<div class="col-6">
					<label for="validationServer01">Loại hàng</label> <select
						id="productType" name="productType" class="form-control is-valid">
						<option value="Điện tử">Điện tử</option>
						<option value="Thực phẩm">Thực phẩm</option>
						<option value="Gia dụng">Gia dụng</option>
					</select>
				</div>
			</div>

			<div class="col-12 row mt-3">
				<label for="">Mô tả sản phẩm</label>
				<textarea class="form-control is-valid" name="productDescription"
					id="productDescription" cols="15" rows="5"><%=productResult[6]%></textarea>
			</div>

			<input onclick="checkValidInput()" type="submit"
				class="form-control mt-3 is-valid" value="Xác nhận">
		</form>
	</div>
	<div class="text-danger" style="text-align: center; margin-top: 3px; font-weight: bold;"><%=productResult[7]%></div>
</body>
<script>
	function checkValidInput() {
		//Thông tin không được để trống
		//Giá bán phải cao hơn giá nhập
		var info = document.getElementById("ProductID").value;
		if (info.length == 0) {
			alert("Bạn chưa nhập mã sản phẩm!")
			return

		}
		info = document.getElementById("ProductName").value
		if (info.length == 0) {
			alert("Bạn chưa nhập tên sản phẩm!")
			return
		}

		var inputPrice = document.getElementById("inputPrice").value
		var outputPrice = document.getElementById("outputPrice").value
		if (inputPrice.length == 0) {
			alert("Bạn chưa nhập giá đầu vào!")
			return
		}
		if (outputPrice.length == 0) {
			alert("Bạn chưa nhập giá bán vào!")
			return
		}
		if(inputPrice > outputPrice)
		{
			alert("Giá đầu vào không thể lớn hơn giá bán ra!")
		}
	}
</script>

</html>