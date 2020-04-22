<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


	<div class="container">
	</br>
		<H1>Welcome ${Email}</H1>
		</br>
        <div>
        <p>Please edit the todo item:</p>
        </br>
        <form method="POST" action="edit">
        <fieldset class="form-group">
        			<label>Description:</label>
        			<input name="description" type="text"
        				class="form-control" id="Description" name="Description" aria-describedby="Description" value="${requestScope.todoToEdit.description}" /> <BR />
        		</fieldset>
        		<fieldset class="form-group">
        			<label>Category:</label>
        			<input name="category" type="text"
        				class="form-control" id="Category" name="Category" aria-describedby="Category" value="${requestScope.todoToEdit.category}" /> <BR />
        		</fieldset>
				<fieldset class="form-group">
                 <label>Due date:</label>
                 <input name="date" type="text"
                 class="form-control" id="Date" name="Date" aria-describedby="Date" value="${requestScope.todoToEdit.date}"/> <BR />
                 </fieldset>
				</br>
        		<input name="add" type="submit" class="btn btn-info" value="Submit" />
        </form>
	</div>


<%@ include file="../common/footer.jspf"%>