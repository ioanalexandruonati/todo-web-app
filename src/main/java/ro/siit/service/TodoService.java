package ro.siit.service;

import ro.siit.model.Todo;
import ro.siit.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

   public void addTodoToDB (Todo todo, UUID uuid) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO list (uuid, name, category) VALUES (?, ?, ?)");
         ps.setObject(1, uuid);
         ps.setString(2, todo.getDescription());
         ps.setString(2, todo.getCategory());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Todo> retrieveTodos (UUID uuid) {
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT name, category FROM list WHERE uuid = ?");
         ps.setObject(1, uuid);
         ResultSet rs = ps.executeQuery();
         rs.next();
         Todo todo = new Todo(rs.getString("name"), rs.getString("category"));
         todos.add(todo);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return todos;
   }

   public void deleteTodo (UUID uuid) {
      try {
         PreparedStatement ps = connection.prepareStatement("DELETE * FROM list WHERE uuid = ?");
         ps.setObject(1, uuid);
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
