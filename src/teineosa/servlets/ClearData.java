package teineosa.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teineosa.Dao;

/**
 * Servlet implementation class Delete
 */
public class ClearData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		deleteItems(request);
		response.sendRedirect("Search");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void deleteItems(HttpServletRequest request) {
		try {
			if (request.getParameter("id").equalsIgnoreCase("All")) {
				new Dao().deleteAll();
			} else {
				int id = Integer.parseInt(request.getParameter("id"));
				new Dao().deleteItem(id);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
