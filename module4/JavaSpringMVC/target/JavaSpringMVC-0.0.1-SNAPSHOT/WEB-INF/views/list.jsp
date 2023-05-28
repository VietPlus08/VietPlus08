<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>ID: ${customer.id}</p>
<p>Name: ${customer.name}</p>
<p>Phone: ${customer.phone}</p>
<p>Email: ${customer.email}</p>
<p>Hobbits:
    <c:if test="${not empty customer.hobbits}">
        <c:forEach var="favorite" items="${customer.hobbits}"> ${favorite} </c:forEach>
    </c:if>
</p>

<p>Marries: ${customer.marries}</p>
<a href="${pageContext.request.contextPath}/">
    <button>back form</button>
</a>
<c:if test="${not empty listEmployee}">
    <table>
        <thead>
        <tr>
            <td>
                ID
            </td>
            <td>
                Full Name
            </td>
            <td>
                Gender
            </td>
            <td>
                Address
            </td>
        </tr>
        <c:forEach items="${listEmployee}" var="item">
            <tr>
                <td>
                        ${item.ma_nv}
                </td>
                <td>
                        ${item.ho_ten_nv}
                </td>
                <td>
                        ${item.gioi_tinh}
                </td>
                <td>
                        ${item.que_quan == null ? "Not Register!" : item.que_quan}
                </td>
            </tr>
        </c:forEach>
        </thead>
    </table>
</c:if>
</body>
</html>
