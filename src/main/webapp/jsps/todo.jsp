<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


	</br>
	<div class="container-fluid">
		<h2>Welcome ${Email}</h2>
		</br>
		<p> <strong>Your todos are:</strong></p>
		 <div class="col-4">
		 </div>
		 <div class="col-8" style="overflow-y: auto; height: 700px;">
		</br>
	<table class="table table-hover table-active table-borderless">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Description</th>
          <th scope="col">Category</th>
          <th scope="col">Due date</th>
          <th scope="col" class="text-center">Actions</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${todos}" var="todo">
        <tr>
          <td>${todo.idOfTodo}</td>
          <td>${todo.description}</td>
          <td>${todo.category}</td>
          <td>${todo.date}</td>
          <td><a class="btn btn-danger btn-lg active" href="?action=delete">Delete</a></td>
          <td><a class="btn btn-info btn-lg active" href="?action=edit&id=${todo.idOfTodo}">Edit</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </br>
        <a class="btn btn-success" href="?action=add">Add New Todo</a>
	</div>


<%@ include file="../common/footer.jspf"%>