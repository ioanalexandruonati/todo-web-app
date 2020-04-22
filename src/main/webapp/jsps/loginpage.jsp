<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/loginpage.css' />"/>

    <title>Login Page</title>
</head>
<body>
<div class="row">
    <div class="login">
        <h1>Login into your account:</h1>
            <form action="login.do" method="post">
                <input type="text" name="Email" placeholder="Email" />
                <input type="password" name="Password" placeholder="Password" />
            </br>
                <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
            </br>

            </form>
                <div style="text-align: center; border: 0px solid">
                    <button type="submit" class="btn btn-primary btn-block btn-large">
                        <a href="adduser" style="color:white">Without an account? </br> Register here.</a>
                </button>
                </br>
                </br>
                <div class="row">
                <div class="alert alert-danger alert-dismissible fade show" style="display:block" name="error">
                			 <c:out value = "${error}"/>
                </div>
                </div>
            </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>