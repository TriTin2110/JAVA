<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        #cpu, #ram
        {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 150px;
        }
    </style>
</head>

<body>
    <form action="ProcessBuyingItem.jsp" method="post">
        <div id="cpu">
            <h2>CPU</h2>
            <div>
                <input type="radio" name="cpu" value="Core I9"><span>Core I9</span>
            </div>
            <div><input type="radio" name="cpu" value="Core I7"><span>Core I7</span></div>
            <div><input type="radio" name="cpu" value="Core I5"><span>Core I5</span></div>
        </div>

        <div id="ram">
            <h2>Ram</h2>
            <div>
                <input type="radio" name="ram" value="8GB"><span>Ram 8GB</span>
            </div>
            <div><input type="radio" name="ram" value="16GB"><span>Ram 16GB</span></div>
            <div><input type="radio" name="ram" value="32GB"><span>Ram 32GB</span></div>
        </div>

        <div id="monitor">
            <h2>Monitor</h2>
            <div>
                <input type="checkbox" name="monitor" value="monitor"><span>Monitor</span>
            </div>
        </div>

        <div id="MoreItem">
            <h2>More Item</h2>
            <select name="selectItem" id="selectItem">
            	<option></option>
                <option value="Scanner">Scanner</option>
                <option value="Printer">Printer</option>
            </select>
        </div>

        <input style="margin-top: 20px;" type="submit" value="Xác nhận">
    </form>
</body>
</html>