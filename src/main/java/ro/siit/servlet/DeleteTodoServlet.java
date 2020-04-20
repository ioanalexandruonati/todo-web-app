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
import java.util.UUID;

@WebServlet(urlPatterns = "/delete.do")
public class DeleteTodoServlet extends HttpServlet {


   private final TodoService todoService = new TodoService();

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      UUID uuid = (UUID) (request.getSession().getAttribute("uuid"));
      todoService.deleteTodo(uuid);
      response.sendRedirect("listtodo.do");
   }
}