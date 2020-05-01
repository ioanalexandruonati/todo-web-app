<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
</br>
<H1>Welcome <c:out value= "${Email}"/></H1>
</br>
<div>
<p>Please add a new todo item:</p>
</br>
<form method="POST">
	<fieldset class="form-group">
        <label>Description:</label> <input name="description" type="text" class="form-control" /> <BR />
	</fieldset>

	<fieldset class="form-group">
		<label>Category:</label> <input name="category" type="text" class="form-control" /> <BR />
	</fieldset>

	<fieldset class="form-group">
		<label>Due date:</label> <input name="date" type="text" class="form-control" id="datepicker" size="10" /> <BR />
	</fieldset>

	<fieldset class="form-group">
		<label>Priority: &nbsp;</label>
			<select name="priority">
                <option value="High">High</option>
                <option value="Medium">Medium</option>
                <option value="Low">Low</option>
			</select>
	</fieldset>
</br>
	<a href="?action=add">
		<input name="add" type="submit" class="btn btn-info" value="Submit" />
	</a>
</form>
</div>


<%@ include file="../common/footer.jspf"%>