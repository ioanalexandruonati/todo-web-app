package ro.siit.user_actions_servlet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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


@WebServlet(urlPatterns = "/adduser")
public class AddUserServlet extends HttpServlet {


   User user;
   private final CredentialsValidator credentialsValidator = new CredentialsValidator();
   private final UserService userService = new UserService();

   static final Logger logger = LogManager.getLogger(CredentialsValidator.class);


   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsps/regform.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {

      String username = request.getParameter("Username");
      String pwd = request.getParameter("Password");

      User user = credentialsValidator.checkCredentials(username, pwd);

      if (user != null) {

         request.setAttribute("error", "Username/password already taken. Please try logging in.");
         request.setAttribute("display", "block");
         request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
         logger.log(Level.TRACE, "error in add user servlet");

      } else {

         PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
         String hashedPassword = passwordEncoder.encode(pwd);
         user = new User(UUID.randomUUID(), username, hashedPassword);
         userService.addUser(user);

         request.setAttribute("error", "Account created. Please log in.");
         request.setAttribute("display", "block");
         request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
      }
   }
}
