package ro.siit.service;

import ro.siit.model.Todo;
import ro.siit.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TodoService {

   private static final List<Todo> todos = new ArrayList<>();

   private Connection connection;

   public TodoService () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public void addTodoToDB (Todo todo, User user) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO list (id, name, category) VALUES (?, ?, ?)");
         ps.setObject(1, user.getId());
         ps.setString(2, todo.getDescription());
         ps.setString(2, todo.getCategory());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Todo> retrieveTodos (User user) {
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT name, category FROM list WHERE id = ?");
         ps.setObject(1, user.getId());
         ResultSet rs = ps.executeQuery();
         rs.next();
         Todo todo = new Todo(rs.getString("name"), rs.getString("category"));
         todos.add(todo);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return todos;
   }

   public void deleteTodo (User user) {
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
