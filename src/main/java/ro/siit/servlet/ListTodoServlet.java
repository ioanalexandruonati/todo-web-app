package ro.siit.servlet;

import ro.siit.service.TodoService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/listtodo.do")
public class ListTodoServlet extends HttpServlet {


	private TodoService todoService = new TodoService();

	@Override
	public void init () throws ServletException {
		super.init();
	}


	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setAttribute("todos", todoService.retrieveTodo());
		request.getRequestDispatcher("/jsps/todo.jsp").forward(request, response);
	}
}