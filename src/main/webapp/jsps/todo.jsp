<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> &nbsp Todos</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #726E97;">

		<a href="/" class="btn btn-info btn-lg">
                  <span class="glyphicon glyphicon-home"> TODO List Web App Home</span>
                </a>

		<ul class="nav nav-pills nav-fill">
			<li class="nav-item">
             <a class= "btn btn-info btn-lg" href="listtodo.do">Todo's</a></li>
             </li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="btn btn-info btn-lg" href="login.do">Login</a></li>
		</ul>
	</nav>
	<div class="container">
		<H1>Welcome ${Email}</H2>
        <div>
        <p>Your Todos are:
        <ol>
        <c:forEach items="${todos}" var="todo">
           <li>${todo.name} <a href="delete.do?todo=${todo.name}">Delete</a> </li>
        </c:forEach>
        </ol>
        <form method="POST" action="addtodo.do">
        New Todo : <input name="todo" type="text" /> <input name="add" type="submit" />
        </form>
	</div>
	<nav class="navbar fixed-bottom navbar-light" style="background-color: #726E97;">
      <span class="navbar-text">
      <a class="navbar-brand" href="https://github.com/ioanalexandruonati?tab=repositories" target="_blank">My github repos!</a></p>
      </span>
    </nav>
	</footer>
</body>

</html>