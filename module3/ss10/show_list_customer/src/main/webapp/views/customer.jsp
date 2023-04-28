<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<html>
<head>
    <title>Show list</title>
</head>
<body>
    <c:url var="urlRegistryPage" value="/customer?action=goRegistryPage"/>
    <c:url var="urlUpdatePage" value="/customer?action=goUpdatePage"/>
    <c:url var="urlDelete" value="/customer?action=delete"/>

    <a href="${urlRegistryPage}"><button>Add new</button></a>
    <form action="/customer?action=search" method="post">
        <input type="search" placeholder="search by id or name" name="searchName">
        <button type="submit">Search</button>
    </form>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Point</th>
            <th>Img</th>
            <th colspan="2">Status</th>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.point}</td>
                <td><img src="${item.img}" height="50" width="50"></td>
                <td><button><a href="${urlUpdatePage}&id=${item.id}">Update</a></button></td>
                <td><button><a href="${urlDelete}&id=${item.id}">Delete</a></button></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
