package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Esimene servlet n‰itab kasutaja sessiooni id-d ja sessiooni pandud atribuudi v‰‰rtust.
//See vıimaldab ka sessiooni atribuuti seada. Seadmiseks on servleti parameeter nimega "param".
//N‰ide: http://ci.itcollege.ee/part2example/HomePage

public class SessiooniId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello");
				
		HttpSession sessioon = request.getSession();
		response.getWriter().println("Your session id is  "+ sessioon.getId());
		
		Integer param = null;
		request.getSession().setAttribute("param", param); 
		
		response.getWriter().println("Session attribute is " + param);
	}

	
}
