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
    <title>Dictionary App</title>
  </head>
  <body>
  <form action="/change" method="get">
    <label for="">Input word (English): </label>
    <input type="text" name="findWord">

    <button type="submit">Find</button>
  </form>
  <label for="">The word is found (Vietnamese): </label>
  <input type="text" name="resultWord" value="${resultWord}">
  </body>
</html>
