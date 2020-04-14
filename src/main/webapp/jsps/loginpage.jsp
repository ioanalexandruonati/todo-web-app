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
<div>${errorMessage}</div>
    <div class="login">
        <h1>Login into your account:</h1>
        <form action="login.do" method="post">
            <input type="text" name="Email" placeholder="Email" required="required" />
            <input type="password" name="Password" placeholder="Password" required="required" />
            <div>${errorMessage}</div>
            <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
        </form>
    </div>
</body>
</html>