package ro.siit.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.siit.model.User;
import ro.siit.service.UserService;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private CredentialsValidator credentialsValidator;

	private UserService userService;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	@Override
	public void init () throws ServletException {
		super.init();
		credentialsValidator = new CredentialsValidator();
		userService = new UserService();
	}

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("authenticated");
		request.setAttribute("display", "none");
		request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);

	}
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		UUID uuidOfLoggedUser = userService.getUserIDFromDB(email);

		User authenticatedUser = credentialsValidator.checkCredentials(email, password);

		if (authenticatedUser != null) {

			request.getSession().setAttribute("authenticated", true);
			request.getSession().setAttribute("Email", email);
			request.getSession().setAttribute("authenticatedUser", authenticatedUser);
			request.getSession().setAttribute("uuid", uuidOfLoggedUser);
			response.sendRedirect("todo.do");
		} else {
			request.setAttribute("error", "Username/password combination incorrect or user does not exist. Please try again or sign up.");
			request.setAttribute("display", "block");
			request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
		}
        }
}
