<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


	<div class="container">
	</br>
		<H1>Welcome <c:out value= "${Email}"/></H1>
		</br>
        <div>
        <p>Please add a new todo item:</p>
        </br>
        <form method="POST" action="addtodo.do">
        <fieldset class="form-group">
        			<label>Description:</label> <input name="description" type="text"
        				class="form-control" /> <BR />
        		</fieldset>
        		<fieldset class="form-group">
        			<label>Category:</label> <input name="category" type="text"
        				class="form-control" /> <BR />
        		</fieldset>
				<fieldset class="form-group">
                 <label>Due date:</label> <input name="date" type="text"
                 class="form-control" /> <BR />
                 </fieldset>
				</br>
        		<input name="add" type="submit" class="btn btn-info" value="Submit" />
        </form>
	</div>


<%@ include file="../common/footer.jspf"%>