		<%@ include file="../common/header.jspf"%>
		<%@ include file="../common/navigation.jspf"%>


			</br>
			<div class="container-fluid">

				<h2>Welcome ${Email}</h2>

				</br>

				 <div class="col-9" style="overflow-y: auto; height: 700px;">

			<div class="row">

			<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for todo..." size="100">

			</div>


			</br>

		<div class="row">
			</br>

			<p> <strong>Your todos are:</strong></p>

			</br>
		<table id="myTable" class="table table-striped table-borderless">
		<tr class="header">
		<th>ID</th>
		<th>Description</th>
		<th>Category</th>
		<th>Due date</th>
		<th>Priority</th>
		<th class="text-center">Actions</th>
		</tr>
		       <c:forEach items="${todos}" var="todo">
		        <tr>
		          <td>${todo.id}</td>
		          <td>${todo.description}</td>
		          <td>${todo.category}</td>
		          <td>${todo.date}</td>
		          <td>${todo.priority}</td>
		          <td class="text-center" >
		          <a class="btn btn-danger btn-lg active" onclick="window.location.href='?action=delete&id=${todo.id}'">Delete</a>
		          <a class="btn btn-info btn-lg active" onclick="window.location.href='?action=edit&id=${todo.id}'">Edit</a>
		          </td>
		        </tr>
		        </c:forEach>
		    </table>
		    </br>
		    </br>
		    </br>
		        <a class="btn btn-success" href="?action=add">Add New Todo</a>
			</div>
			</div>
			</div>


		<%@ include file="../common/footer.jspf"%>