<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/customer?action=doSave" var="${urlSave}"/>
<h1>Form registry</h1>
<form action="${urlSave}" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td><input type="number" name="id" value="${id != null ? id : ""}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${name != null ? name : ""}"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${age != null ? age : ""}"></td>
        </tr>
        <tr>
            <td>Point</td>
            <td><input type="text" name="point" value="${point != null ? point : ""}"></td>
        </tr>
        <tr>
            <td>Img</td>
            <td><input type="text" name="img" value="${img != null ? img : ""}"></td>
        </tr>
        <tr>
            <button type="submit">Submit</button>
        </tr>
    </table>
</form>
</body>
</html>
