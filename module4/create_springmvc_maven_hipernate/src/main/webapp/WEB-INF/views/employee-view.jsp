<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee form</title>
</head>
<body>
<c:url value="/customer-view" var="urlViewCustomer"/>
<c:url value="/employee-add" var="urlAddEmployee"/>
<c:url value="/employee-update" var="urlUpdateEmployee"/>
<c:url value="/employee-delete" var="urlDeleteEmployee"/>
<a href="${urlViewCustomer}">Customer</a>

<table border="1px" style="border: black">
    <tr>
        <th><a href="${urlAddEmployee}">Add new employee</a></th>
    </tr>
    <tr>
        <th>Mã nhân viên</th>
        <th>Tên nhân viên</th>
        <th>CMND</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th colspan="2">Thay đổi</th>
    </tr>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    <c:if test="${not empty listEmployee}">
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td>${employee.manv}</td>
                <td>${employee.hotennv}</td>
                <td>${employee.soCMND}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.ngaysinh}" /></td>
                <td>${employee.diachi}</td>
                <td>${employee.sodt}</td>
                <td><a href="${urlUpdateEmployee}/${employee.manv}">Edit</a></td>
                <td><a href="${urlDeleteEmployee}/${employee.manv}">Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>