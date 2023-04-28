<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div class="container">

    <form action="/login" method="post">
      <!-- Email input -->
      <div style="margin-top: 8px;">
        <h1>Login Form</h1>
      </div>
      <div>
        <c:if test="${message != null}">
          <p>${message}</p>
        </c:if>
      </div>
      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example1">User Name</label>
        <input class="form-control" id="form1Example1" name="username" type="text" value="${username != null ? username : ""}"/>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example2">Password</label>
        <input class="form-control" id="form1Example2" name="password" type="password" value="${password != null ? password : ""}"/>
      </div>

      <div class="form-check">
        <input class="form-check-input" id="form1Example3" name="remember" type="checkbox" value="true" />
        <label class="form-check-label" for="form1Example3"> Remember me </label>
      </div>

      <!-- 2 column grid layout for inline styling -->
<%--      <div class="row mb-4">--%>
<%--        <div class="col d-flex justify-content-center">--%>
<%--          <!-- Checkbox -->--%>
<%--          <div class="form-check">--%>
<%--            <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />--%>
<%--            <label class="form-check-label" for="form1Example3"> Remember me </label>--%>
<%--          </div>--%>
<%--        </div>--%>

<%--        <div class="col">--%>
<%--          <!-- Simple link -->--%>
<%--          <a href="#!">Forgot password?</a>--%>
<%--        </div>--%>
<%--      </div>--%>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary btn-block">Sign in</button>
    </form>

  </div>
  </body>
</html>
