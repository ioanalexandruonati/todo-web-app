<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


	</br>
	<div class="container-fluid">
		<h2>Welcome ${Email}</h2>
		</br>
		 <div class="col-4">
		 </div>
		 <div class="col-8">
		<p> <strong>Your todos are:</strong></p>
		</br>
	<table class="table table-hover table-active table-borderless">
      <thead>
        <tr>
          <th scope="col">Description</th>
          <th scope="col">Category</th>
          <th scope="col">Due date</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${todos}" var="todo">
        <tr>
          <td>${todo.description}</td>
          <td>${todo.category}</td>
           <td>${todo.date}</td>
          <td><a class="btn btn-danger" href="delete.do?todo=${todo.description}&category=${todo.category}">Delete</a> </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </br>
        <a class="btn btn-success" href="addtodo.do">Add New Todo</a>
	</div>


<%@ include file="../common/footer.jspf"%>