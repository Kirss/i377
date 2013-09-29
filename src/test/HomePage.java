package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello");
				
		HttpSession sessioon = request.getSession();
		response.getWriter().println("Your session id is  "+ sessioon.getId());
		
		String param = request.getParameter("param");		
		response.getWriter().println("Session attribute is " + param);
	}

	
}
