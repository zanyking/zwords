package idv.zanyking.zwords.web.ui;

import idv.zanyking.zwords.web.CredentialManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check authentication, 
		CredentialManager userMgmt = CredentialManager.getInstance(request.getSession());
		userMgmt.login("ian", "ian");// for test only...
		if(!userMgmt.isAuthenticated()){
			userMgmt.loginByCookie(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/index.jsp");
		dispatcher.forward(request, response);
	}

}
