package teineosa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao extends AbstractDao {
   
   public boolean deleteAll() throws SQLException {
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("DELETE FROM unit");
      }
      finally {
         closeResources();
      }
      return true;
   }
   
   public boolean deleteItem(int id) throws SQLException {
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("DELETE FROM unit WHERE id = " + id);
      }
      finally {
         closeResources();
      }
      return true;
   }
   
   public boolean addItem(String name, String code) throws SQLException {
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("INSERT INTO unit VALUES (NEXT VALUE FOR seq1), '" + name + "', '" + code + "'");
      }
      finally {
         closeResources();
      }
      return true;
   }
   
   public List<Asi> search(String keyword) throws SQLException{
      List<Asi> items = new ArrayList<Asi>();
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("SELECT * FROM unit WHERE LCASE(name) LIKE '%" + keyword.toLowerCase() + "%'");
         while(rs.next()) {
            Asi item = new Asi();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setCode(rs.getString("code"));
            items.add(item);
         }
      }
      finally {
         closeResources();
      }
      return items;
   }
   
   public List<Asi> findAllItems() throws SQLException {
      List<Asi> items = new ArrayList<Asi>();
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("SELECT * FROM unit");
         while(rs.next()) {
        	Asi item = new Asi();
            item.setId(Integer.parseInt(rs.getString("id")));
            item.setName(rs.getString("name"));
            item.setCode(rs.getString("code"));
            items.add(item);
         }
      } 
      finally {
         closeResources();
      }
      return items;
   }

}