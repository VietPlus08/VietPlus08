<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<html>
<head>
    <title>Show list</title>
</head>
<body>
<c:url var="urlRegistryPage" value="/product?action=goRegistryPage"/>
<c:url var="urlUpdatePage" value="/product?action=goUpdatePage"/>
<c:url var="urlDelete" value="/product?action=delete"/>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarTogglerDemo03"
                    aria-controls="navbarTogglerDemo03"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${urlRegistryPage}"> (+) Add new product </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/product">Home</a>
                    </li>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/login?action=logout">Logout</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link disabled"
                        >Disabled</a
                        >
                    </li>
                </ul>

                <form action="/product" class="d-flex input-group w-auto" method="get">
                    <input type="hidden" name="action" value="search">
                    <input
                            aria-label="Search"
                            class="form-control"
                            placeholder="find by id"
                            type="search"
                            name="searchId"
                    />
                    <input
                            aria-label="Search"
                            class="form-control"
                            placeholder="find by name"
                            type="search"
                            name="searchName"
                    />
                    <button
                            class="btn btn-outline-primary"
                            type="submit"
                            data-mdb-ripple-color="dark"
                    >
                        Search
                    </button>
                </form>
            </div>
        </div>
    </nav>

    <div class="p-5 text-center bg-light" style="margin-top: 8px;">
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
                <th colspan="2">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.point}</td>
                    <td><img src="${item.img}" height="30" width="30"></td>
                    <td><a href="${urlUpdatePage}&id=${item.id}">
                        <i class="fa-regular fa-pen-to-square fa-2x"></i>
                    </a></td>
                    <td><a href="${urlDelete}&id=${item.id}">
                        <i class="fa-regular fa-circle-xmark fa-2x"></i>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <nav aria-label="...">
            <ul class="pagination">
                <c:if test="${index == 1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Previous</a>
                    </li>
                </c:if>
                <c:if test="${index != 1}">
                    <li class="page-item ">
                        <a class="page-link" href="/customer?index=${index - 1}">Previous</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${pages}" var="item">
                    <li class="${index == item ? "page-item active" : "page-item"}">
                        <a class="page-link" href="/customer?index=${item}">${item}</a>
                    </li>
                </c:forEach>

                <c:if test="${index == pages}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </c:if>
                <c:if test="${index != pages}">
                    <li class="page-item ">
                        <a class="page-link" href="/customer?index=${index + 1}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>



</div>
</body>
</html>
