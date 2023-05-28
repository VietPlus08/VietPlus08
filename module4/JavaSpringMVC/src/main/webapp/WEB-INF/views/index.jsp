<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Form</title>
</head>
<body>
<h1>
    <form:form action="" method="post" modelAttribute="customer">
        <table>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id"/></td>
            </tr>

            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
            </tr>

            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email"/></td>
            </tr>

            <tr>
                <td><form:label path="phone">Phone</form:label></td>
                <td><form:input path="phone"/></td>
            </tr>
            <tr>
                <td><form:label path="marries">Marries</form:label></td>
                <td><form:radiobuttons path="marries" items="${marries}"/></td>
            </tr>

            <tr>
                <td><form:label path="hobbits">Hobbits</form:label></td>
                <td><form:checkboxes items="${hobbits}"
                                     path="hobbits"/></td>
            </tr>

            <tr>
                <td>
                    <form:label path="gender">Gender</form:label>
                <td><form:select path="gender">
                    <form:option value="" label="Select"/>
                    <form:options items="${genders}"/>
                </form:select></td>
            </tr>
        </table>
        <input type="submit" value="Submit">

    </form:form>
</h1>
<a href="/check">
    <button>check</button>
</a>
</body>
</html>