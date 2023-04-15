<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/solution" method="post">
    Product description <input type="text" name="description" value="">
    List price <input type="number" name="price" value="">
    Discount percent (%) <input type="number" name="discount" value="">
    <input type="submit" value="Calculate discount">
</form>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>