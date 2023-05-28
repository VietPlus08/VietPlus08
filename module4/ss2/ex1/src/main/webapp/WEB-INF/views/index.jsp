<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/05/2023
  Time: 9:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments App</title>
</head>
<body>
<h1>Sandwich Condiments App</h1>
<form:form action="/save" method="get" modelAttribute="condiment">
<%--    <form:label path="name"> Name condiment: </form:label>--%>
    <form:checkboxes path="name" items="${condimentNames}" delimiter="|"/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
