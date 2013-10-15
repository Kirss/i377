package test3;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Dao;

public class Search extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      setSearchResults(request);
      request.getRequestDispatcher("jsp/Search.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String searchString = request.getParameter("searchString");
      response.sendRedirect("Search?searchString="+searchString);
   }

   private void setSearchResults(HttpServletRequest request) {

      String searchString = request.getParameter("searchString");
      Dao dao = new Dao();

      try {
         if(searchString == null || searchString.equals("")) {
            request.setAttribute("searchResults", dao.findAllItems());
         }
         else {
            request.setAttribute("searchResults", dao.search(searchString));
         }
      } catch(SQLException e) {
         throw new RuntimeException(e);
      } 
   }
}
