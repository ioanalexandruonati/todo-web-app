package ro.siit.user_actions;

import ro.siit.login.CredentialsValidator;
import ro.siit.model.User;
import ro.siit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = "/email.do")
public class EditEmailServlet extends HttpServlet {

   private final UserService userService = new UserService();

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/emailform.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String email = request.getParameter("Email");
      UUID uuidOfLoggedUser = userService.getUserIDFromDB(email);

      userService.updateEmail(uuidOfLoggedUser, email);

      request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
      request.setAttribute("error", "Email updated. Use the new email to log in.");
   }
}
