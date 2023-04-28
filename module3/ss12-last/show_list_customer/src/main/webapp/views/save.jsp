<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:url value="/customer?action=doSave" var="${urlSave}"/>--%>

<div class="container">
    <form action="/customer?action=doSave" method="post">
        <div style="margin-top: 8px;">
            <h1>Registry Form</h1>
        </div>
        <div>
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example1">Id</label>
            <input class="form-control" id="form1Example1" type="number" name="id" value="${item.id != null ? item.id : ""}"/>
            <c:if test="${error != null}">${error.get("id")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example2">Name</label>
            <input class="form-control" id="form1Example2" type="text" name="name" value="${item.name != null ? item.name : ""}"/>
            <c:if test="${error != null}">${error.get("name")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example3">Age</label>
            <input class="form-control" id="form1Example3" type="text" name="age" value="${item.age != null ? item.age : ""}"/>
            <c:if test="${error != null}">${error.get("age")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example4">Point</label>
            <input class="form-control" id="form1Example4" type="text" name="point" value="${item.point != null ? item.point : ""}"/>
            <c:if test="${error != null}">${error.get("point")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example5">Image</label>
            <input class="form-control" id="form1Example5" type="text" name="img" value="${item.img != null ? item.img : ""}"/>
        </div>
        <div>
            <button class="btn btn-primary btn-block" type="submit">Submit</button>
        </div>
    </form>
</div>


</body>
</html>
