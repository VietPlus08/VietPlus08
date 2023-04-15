
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Product description</td>
        <td>${description}</td>
    </tr>
    <tr>
        <td>List price</td>
        <td>${price}</td>
    </tr>
    <tr>
        <td>Discount percent (%)</td>
        <td>${discount}</td>
    </tr>
    <tr>
        <td>Discount Amount</td>
        <td>${discount * price * 0.01}</td>
    </tr>
    <tr>
        <td>Discount Price</td>
        <td>${price - (discount * price * 0.01)}</td>
    </tr>
</table>
</body>
</html>
