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
    <title>Calculate App</title>
  </head>
  <body>
  <form action="/change" method="get">
    <label for="">Input number (USD): </label>
    <input type="text" name="sourceNumber">

    <button type="submit">Change</button>
  </form>
  <label for="">The money is changed (VND): </label>
  <input type="text" name="resultNumber" value="${resultNumber}">
  </body>
</html>
