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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addtodo.do")
public class AddTodoServlet extends HttpServlet {


   private final TodoService todoService = new TodoService();

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/add.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String newtodo = request.getParameter("todo");
      String category = request.getParameter("category");
      User user = (User) (request.getSession().getAttribute("authenticateduser"));
      Todo todo = new Todo(newtodo, category);
      todoService.addTodoToDB(todo, user);
      response.sendRedirect("listtodo.do");
   }
}