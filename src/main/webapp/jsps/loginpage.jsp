
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="loginpage.css">

    <title>Login Page</title>
</head>
<body>

<div class="row">
    <div class="login">
        <h1>Login into your account:</h1>

        <form action="login.do" method="post">
            <div class="alert alert-danger" style="display: <c:out value="${requestScope.error}"/>">
            <c:out value="${requestScope.error}"/>
            </div>
            <input type="text" name="Email" placeholder="Email" />
            <input type="password" name="Password" placeholder="Password" />
            </br>
            <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
            </br>
            </br>
            </form>
            <div style="text-align: center; border: 0px solid">
            <button type="button" class="btn btn-light">
            <a href="adduser">Without an account? Register here.</a>
            </button>
            </div>
    </div>
</div>
</body>
</html>