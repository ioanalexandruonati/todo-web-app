<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>&nbsp Sign Up Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/formstyle.css' />"/>

</head>
<body>
<div class="signup-form">
    <form action="adduser" method="post">
		<h2>Create Account</h2>
        <div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
				<input type="text" class="form-control" name="Email" placeholder="Email Address" required="required">
			</div>
        </div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-lock"></i></span>
				<input type="password" class="form-control" name="Password" placeholder="Password" required="required">
				</br>
				</br>
				<input type="password" class="form-control" name="ConfirmPassword" placeholder="Confirm Password" required="required">
			</div>
        </div>
        </br>
        <input name="add" type="submit" class="btn btn-success btn-block btn-large" value="Sumbit"/>
    </form>
	<div class="text-center"><a href="login.do"> Already have an account? </br> Login here...</a></div>
</div>
</body>
</html>