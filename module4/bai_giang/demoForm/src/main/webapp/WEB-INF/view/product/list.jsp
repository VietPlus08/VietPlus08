<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 5/24/2023
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
    <h1>List product</h1>
    <h3><a href="/product/create">Create new product</a></h3>
    <fmt:setLocale value="vi_VN" />
    <table>
        <tr>
            <th>ID</th>
            <th>Product name</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Date release</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.category.categoryName}</td>
                <td>${p.quantity}</td>
                <td><fmt:formatDate value="${p.dateRelease}" pattern="dd/MM/yyyy" /></td>
                <td><fmt:formatNumber value="${p.price}" type="currency" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
