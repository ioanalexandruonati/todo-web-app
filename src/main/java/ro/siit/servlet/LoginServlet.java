package ro.siit.servlet;

import ro.siit.login.CredentialsValidator;
import ro.siit.model.User;

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


	@Override
	public void init () throws ServletException {
		super.init();
		credentialsValidator = new CredentialsValidator();
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

		if (authenticatedUser != null) {
			request.getSession().setAttribute("authenticatedUser", authenticatedUser);
			response.sendRedirect("listtodo.do");

		} else {
			request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
			request.setAttribute("error", "Username/password combination incorrect. Please try again");
		}
	}
}
