package ro.siit.servlet;

import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;
import ro.siit.login.CredentialsValidator;
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


	@Override
	public void init () throws ServletException {
		super.init();
		credentialsValidator = new CredentialsValidator();
		userService = new UserService();
	}

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);

	}
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		User authenticatedUser = credentialsValidator.checkCredentials(email, password);

		UUID uuidOfLoggedUser = userService.getUserIDFromDB(email);

		if (authenticatedUser != null) {
			request.getSession().getAttribute("Email");
			request.getSession().setAttribute("authenticatedUser", authenticatedUser);
			request.getSession().setAttribute("uuid", uuidOfLoggedUser);
			response.sendRedirect("listtodo.do");

		} else {
			request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
			request.setAttribute("error", "Username/password combination incorrect. Please try again");
		}
	}
}
