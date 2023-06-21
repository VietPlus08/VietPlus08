<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 5/24/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
    <h1>Create new product</h1>
    <form:form action="/product/create" method="post" modelAttribute="product">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Category</td>
                <td><form:select path="category.categoryId" items="${categories}"
                    itemLabel="categoryName" itemValue="categoryId" /></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><form:input path="quantity" /></td>
            </tr>
            <tr>
                <td>Date release</td>
                <td><form:input path="dateRelease" placeholder="dd/MM/yyyy" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="Register"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
