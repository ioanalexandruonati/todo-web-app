package ro.siit.service;

import ro.siit.model.Todo;
import ro.siit.model.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;



public class TodoService {


   Todo Todo;
   private Connection connection;
   private HttpServletRequest request;

   User user = (User) request.getSession().getAttribute("user");


   public TodoService () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public void addTodoToDB (Todo todo) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO list (id, name, category) VALUES (?, ?, ?)");
         ps.setObject(1, user.getId());
         ps.setString(2, Todo.getName());
         ps.setString(2, Todo.getCategory());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public Todo retrieveTodo () {
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM list WHERE id = ?");
         ps.setObject(1, user.getId());
         ResultSet rs = ps.executeQuery();
         rs.next();
         Todo = new Todo(rs.getString("name"), rs.getString("category"));
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return Todo;
   }

   public void deleteTodo () {
      try {
         PreparedStatement ps = connection.prepareStatement("DELETE * FROM list WHERE id = ?");
         ps.setObject(1, user.getId());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   @Override
   protected void finalize () throws Throwable {
      this.connection.close();
   }


}
