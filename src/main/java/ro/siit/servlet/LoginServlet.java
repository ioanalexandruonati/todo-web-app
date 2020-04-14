package ro.siit.servlet;

import ro.siit.service.LoginService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginService loginService = new LoginService();


	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);

	}
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("Email");
		request.setAttribute("Email", email);
		String password = request.getParameter("Password");
		request.setAttribute("Password", password);

		boolean isUserValid = loginService.isValid(email, password);


		if (isUserValid) {
			response.sendRedirect("todo.do");
		} else
			request.getRequestDispatcher("/jsps/loginpage.jsp").forward(request, response);
		request.setAttribute("errorMessage", "Invalid username or password. Try again");
	}
}
