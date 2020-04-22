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


@WebServlet(urlPatterns = "/deleteuser.do")
public class DeleteUserServlet extends HttpServlet {


   private final CredentialsValidator credentialsValidator = new CredentialsValidator();
   private final UserService userService = new UserService();
   User user;

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/deleteform.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String email = request.getParameter("Email");

      userService.deleteUser(email);

      request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
      request.setAttribute("error", "Account deleted.");
   }
}
