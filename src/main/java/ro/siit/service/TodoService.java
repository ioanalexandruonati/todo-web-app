package ro.siit.service;

import ro.siit.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TodoService {

   private final List<Todo> todos = new ArrayList<>();

   private Connection connection;

   public TodoService () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public void addTodoToDB (String name, String category, UUID uuid, String date, String priority) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO list (uuid, name, category, date, priority) VALUES (?, ?, ?, ?, ?)");
         ps.setObject(1, uuid);
         ps.setString(2, name);
         ps.setString(3, category);
         ps.setString(4, date);
         ps.setString(5, priority);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Todo> retrieveTodos (UUID uuid) throws SQLException {
      List<Todo> todos = new ArrayList<>();
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT id, name, category, date, priority FROM list WHERE uuid = ?");
         ps.setObject(1, uuid);
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
            Todo todo = new Todo(rs.getInt("id"), rs.getString("name"), rs.getString("category"), rs.getString("date"), rs.getString("priority"));
            todos.add(todo);
         }
      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }
      return todos;
   }

   public void deleteTodo (int id) {
      try {
         PreparedStatement ps = connection.prepareStatement("DELETE FROM list WHERE id = ?");
         ps.setObject(1, id);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void editTodo (Todo todo) {
      try {
         PreparedStatement ps = connection.prepareStatement("UPDATE list SET name = ?, category = ?, date = ?, priority = ? WHERE id = ?");
         ps.setString(1, todo.getDescription());
         ps.setString(2, todo.getCategory());
         ps.setString(3, todo.getDate());
         ps.setString(4, todo.getPriority());
         ps.setInt(4, todo.getId());
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   protected void finalize () throws Throwable {
      this.connection.close();
   }


}