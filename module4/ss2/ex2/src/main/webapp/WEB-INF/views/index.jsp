<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Calculation App</title>
</head>
<body>

<form action="/" method="get">
    <input type="number" name="firstNum" value="${calculator.firstNum}"/>
    <input type="number" name="secondNum" value="${calculator.secondNum}"/><br>
    <button type="submit" value="add" name="calculation">(+) addition</button>
    <button type="submit" value="sub" name="calculation">(-) subtraction</button>
    <button type="submit" value="mul" name="calculation">(x) multiplication</button>
    <button type="submit" value="div" name="calculation">(-) division</button>
</form>
    Result: <span>${result}</span>


</body>
</html>
