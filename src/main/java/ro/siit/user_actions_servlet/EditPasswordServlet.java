package ro.siit.user_actions_servlet;

import ro.siit.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(urlPatterns = "/pwd.do")
public class EditPasswordServlet extends HttpServlet {

   private final UserService userService = new UserService();

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/pwdform.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
      String password = request.getParameter("Password");
      String email = (String) request.getSession().getAttribute("Email");

      UUID uuidOfLoggedUser = userService.getUserIDFromDB(email);

      userService.updatePassword(uuidOfLoggedUser, password);

      request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
      request.setAttribute("error", "Password updated. Use the new password to log in.");
   }
}
