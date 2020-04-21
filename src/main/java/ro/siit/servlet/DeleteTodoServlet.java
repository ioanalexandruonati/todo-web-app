package ro.siit.servlet;

import ro.siit.model.Todo;
import ro.siit.model.User;
import ro.siit.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = "/delete.do")
public class DeleteTodoServlet extends HttpServlet {

   List<Todo> todoList;
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
         List<Todo> todoList = todoService.retrieveTodos(uuid);
         for (Todo todo : todoList
         ) {
            int idValueOfTodo = todo.getIdVaueOfTodo();
            todoService.deleteTodo(uuid, idValueOfTodo);
            response.sendRedirect("listtodo.do");
         }
      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }
   }
}