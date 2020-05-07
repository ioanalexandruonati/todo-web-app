		<%@ include file="../common/header.jspf"%>
		<%@ include file="../common/navigation.jspf"%>


			</br>
			<div class="container-fluid">

				<h2>Welcome ${Username}</h2>

				</br>

				 <div class="col-9" style="overflow-y: auto; height: 700px;">

			<div class="row">

			<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for todo..." size="85">

			</div>


			</br>

		<div class="row">
			</br>

			<p> <strong>Your todos are:</strong></p>

			</br>
		<table id="myTable" class="table table-sm table-striped table-borderless rounded sortable">
		<tr class="header rounded">
		<th >Description</th>
		<th >Category</th>
		<th >Due date</th>
		<th >Priority</th>
		<th class="text-center">Actions</th>
		</tr>
		       <c:forEach items="${todos}" var="todo">
		        <tr class="rounded">
		          <td class="rounded" >${todo.id}</td>
		          <td class="rounded" >${todo.description}</td>
		          <td class="rounded" >${todo.category}</td>
		          <td class="rounded" >${todo.date}</td>
		          <td class="rounded" id="priority" sorttable_customkey="sort();" >${todo.priority}</td>
		          <td class="text-center rounded">
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