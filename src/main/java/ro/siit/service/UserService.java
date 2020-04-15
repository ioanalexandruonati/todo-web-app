package ro.siit.service;

import ro.siit.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {

   private Connection connection;

   public UserService () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public void addUser (User user) {
      try {
         PreparedStatement ps = connection.prepareStatement("INSERT INTO login (id, email, pwd) VALUES (?, ?, ?)");
         ps.setObject(1, user.getId());
         ps.setString(2, user.getEmail());
         ps.setString(3, user.getPwd());
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
