<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> &nbsp Todos</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #726E97;">

		<a class="btn btn-info btn-lg">
                  <span class="glyphicon glyphicon-home" style="color:white"> TODO List Web App</span>
                </a>

		<ul class="nav nav-pills nav-fill">
			<li class="nav-item">
             <a class= "btn btn-info btn-lg" href="listtodo.do">Todo's</a></li>
             </li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="btn btn-info btn-lg" href="login.do">Logout</a></li>
		</ul>
	</nav>
	<div class="container">
		<H1>Welcome ${Email}</H1>
		</br>
        <div>
        <p>Please add a new todo item:</p>
        </br>
        <form method="POST" action="addtodo.do">
        <fieldset class="form-group">
        			<label>Description</label> <input name="todo" type="text"
        				class="form-control" /> <BR />
        		</fieldset>
        		<fieldset class="form-group">
        			<label>Category</label> <input name="category" type="text"
        				class="form-control" /> <BR />
        		</fieldset>
        		<input name="add" type="submit" class="btn btn-success" value="Submit" />
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