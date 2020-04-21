package ro.siit.servlet;

import ro.siit.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

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
      UUID uuid = (UUID) (request.getSession().getAttribute("uuid"));
      String description = request.getParameter("description");
      String category = request.getParameter("category");
      String date = request.getParameter("date");
      todoService.addTodoToDB(description, category, uuid, date);
      response.sendRedirect("listtodo.do");
   }
}