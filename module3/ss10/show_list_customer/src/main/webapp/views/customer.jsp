<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<html>
<head>
    <title>Show list</title>
</head>
<body>
    <c:url var="urlRegistryPage" value="/customer?action=goRegistryPage"/>
    <c:url var="urlUpdatePage" value="/customer?action=goUpdatePage"/>
    <c:url var="urlDelete" value="/customer?action=delete"/>

    <a name="" id="" class="btn btn-primary" href="${urlRegistryPage}" role="button">Add new</a>

    <%--    <a href="${urlRegistryPage}"><button>Add new</button></a>--%>
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
                <td><a href="${urlUpdatePage}&id=${item.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                </svg></a></td>
<%--                <td><button><a href="${urlDelete}&id=${item.id}">Delete</a></button></td>--%>
                <td><a href="${urlDelete}&id=${item.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eraser-fill" viewBox="0 0 16 16">
                    <path d="M8.086 2.207a2 2 0 0 1 2.828 0l3.879 3.879a2 2 0 0 1 0 2.828l-5.5 5.5A2 2 0 0 1 7.879 15H5.12a2 2 0 0 1-1.414-.586l-2.5-2.5a2 2 0 0 1 0-2.828l6.879-6.879zm.66 11.34L3.453 8.254 1.914 9.793a1 1 0 0 0 0 1.414l2.5 2.5a1 1 0 0 0 .707.293H7.88a1 1 0 0 0 .707-.293l.16-.16z"/>
                </svg></a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
