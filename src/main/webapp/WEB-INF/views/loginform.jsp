<%--
  Created by IntelliJ IDEA.
  User: hyeongikim
  Date: 2022/12/07
  Time: 4:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
    <div class="container text-center">
        <img src="../img/sample.png" width="240" alt="" />
        <form method="post" action="loginOk">
            <div class="form-floating mb-3">
                <input type="text" name="userid" class="form-control" id="floatingInput" placeholder="ID">
                <label for="floatingInput">USER ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="PW">
                <label for="floatingPassword">USER PW</label>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-success">LOGIN</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
