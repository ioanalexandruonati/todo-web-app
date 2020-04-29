package ro.siit.user_actions_servlet;

import ro.siit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = "/email.do")
public class EditUsernameServlet extends HttpServlet {

   private final UserService userService = new UserService();

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/usernameform.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String username = request.getParameter("Username");
      UUID uuidOfLoggedUser = userService.getUserIDFromDB(username);

      userService.updateUsername(uuidOfLoggedUser, username);

      request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
      request.setAttribute("error", "Email updated. Use the new email to log in.");
   }
}
