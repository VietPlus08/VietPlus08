<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/saveEmployee" var="urlSaveEmployee"/>
<h3>Tạo mới nhân viên</h3>
<form:form action="${urlSaveEmployee}" method="post" modelAttribute="employee">
    <c:if test="${not empty employee.manv}">
        <form:label path="manv">Id</form:label>
        <form:input path="manv"/> <br>
    </c:if>
    Họ tên <form:input path="hotennv"/> <br>
    <form:errors path="hotennv" cssClass="alert"></form:errors> <br>
    CMND <form:input path="soCMND"/> <br>
    <form:errors path="soCMND" cssClass="alert"></form:errors> <br>
    Ngày sinh <form:input path="ngaysinh"/> <br>
    <form:errors path="ngaysinh" cssClass="alert"></form:errors> <br>
    Địa chỉ <form:input path="diachi"/> <br>
    <form:errors path="diachi" cssClass="alert"></form:errors> <br>
    Số điện thoại <form:input path="sodt"/> <br>
    <form:errors path="sodt" cssClass="alert"></form:errors> <br>

    <button type="submit">Lưu</button>
</form:form>
</body>
</html>
