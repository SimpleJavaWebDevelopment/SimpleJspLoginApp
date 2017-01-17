package org.koushik.javabrains.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.koushik.javabrains.dto.User;
import org.koushik.javabrains.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 * @WebServlet will provide servlet Mapping to call form from login.jsp
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	LoginService loginService = new LoginService();
	
	boolean bAuthenticate = loginService.authenticate(userId, password);
	
	if(bAuthenticate) {
		// passed by client by filling the form / param 
		// passed as string 
		// get as string
		//request.getParameter(arg0)
		
		// set by program
		// set as string/key and value as object
		//request.setAttribute(arg0, arg1);
		// get by object 
		//request.getAttribute(arg0)
		/* this does set user name in different ways and show on susscess jsp pages*/
		
		User user = loginService.getUserDetails(userId);
		//request.getSession().setAttribute("user", user);
		//response.sendRedirect("success.jsp");
		//request.setAttribute("user", user);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("success2.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jstl.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		return;
	} else {
		/* In case of failure redirect back to login page*/
		response.sendRedirect("login.jsp");
		return;
	}
	
	}

	
}
