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
    <form action="/ProductServlet?action=doSave" method="post">
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
            <input class="form-control" id="form1Example1" type="number" name="id"
                   value="${item.id != null ? item.id : ""}"
                    ${item.id != null ? "readonly" : ""} />
            <c:if test="${error != null}">${error.get("id")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example2">Name</label>
            <input class="form-control" id="form1Example2" type="text" name="name" value="${item.name != null ? item.name : ""}"/>
            <c:if test="${error != null}">${error.get("name")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example3">Price</label>
            <input class="form-control" id="form1Example3" type="text" name="price" value="${item.price != null ? item.price : ""}"/>
            <c:if test="${error != null}">${error.get("price")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example4">Quantity</label>
            <input class="form-control" id="form1Example4" type="text" name="quantity" value="${item.quantity != null ? item.quantity : ""}"/>
            <c:if test="${error != null}">${error.get("quantity")}</c:if>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example5">Color</label>
            <input class="form-control" id="form1Example5" type="text" name="color" value="${item.color != null ? item.color : ""}"/>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example6">Description</label>
            <input class="form-control" id="form1Example6" type="text" name="description" value="${item.description != null ? item.description : ""}"/>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form1Example7">Category</label>
            <select class="form-control" id="form1Example7" name="categoryId" >
                <option value="1">Phone</option>
                <option value="2">Television</option>
                <option value="3">Ipad</option>
                <option value="4">Laptop</option>
            </select>
        </div>


        <div>
            <button class="btn btn-primary btn-block" type="submit">Submit</button>
        </div>
    </form>
</div>


</body>
</html>
