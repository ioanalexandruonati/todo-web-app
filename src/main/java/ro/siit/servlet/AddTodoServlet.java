package ro.siit.servlet;

import ro.siit.model.Todo;
import ro.siit.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addtodo.do")
public class AddTodoServlet extends HttpServlet {

   private TodoService todoService = new TodoService();

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String newtodo = request.getParameter("todo");
      todoService.addTodo(new Todo(newtodo));
      response.sendRedirect("listtodo.do");
   }
}