package ro.siit.servlet;

import ro.siit.model.User;
import ro.siit.service.TodoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/listtodo.do")
public class ListTodoServlet extends HttpServlet {


	private final TodoService todoService = new TodoService();

	@Override
	public void init () throws ServletException {
		super.init();
	}


	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
           UUID uuid = (UUID) (request.getSession().getAttribute("uuid"));
           try {
              request.setAttribute("todos", todoService.retrieveTodos(uuid));
           } catch (SQLException throwables) {
              throwables.printStackTrace();
           }
           request.getRequestDispatcher("/jsps/todo.jsp").forward(request, response);
        }
}