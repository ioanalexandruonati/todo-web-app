package ro.siit.service;

import ro.siit.model.Todo;
import ro.siit.model.User;

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

   public void addTodoToDB (String name, String category, UUID uuid, String date) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO list (uuid, name, category, date) VALUES (?, ?, ?, ?)");
         ps.setObject(1, uuid);
         ps.setString(2, name);
         ps.setString(3, category);
         ps.setString(4, date);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Todo> retrieveTodos (UUID uuid) throws SQLException {
      List<Todo> todos = new ArrayList<>();
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT id, name, category, date FROM list WHERE uuid = ?");
         ps.setObject(1, uuid);
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
            Todo todo = new Todo(rs.getInt("id"), rs.getString("name"), rs.getString("category"), rs.getString("date"));
            todos.add(todo);
         }
      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }
      return todos;
   }

   public void deleteTodo (UUID uuid, Integer idValueOfTodo) {
      try {
         PreparedStatement ps = connection.prepareStatement("DELETE FROM list WHERE id = ? AND uuid=?");
         ps.setObject(1, idValueOfTodo);
         ps.setObject(2, uuid);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   protected void finalize () throws Throwable {
      this.connection.close();
   }


}