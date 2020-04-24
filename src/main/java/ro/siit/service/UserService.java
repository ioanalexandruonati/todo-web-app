package ro.siit.service;

import ro.siit.model.User;

import java.sql.*;
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

   public UUID getUserIDFromDB (String email) {
      String uuid = null;
      try {
         PreparedStatement ps = connection.prepareStatement("SELECT id FROM login WHERE email=?");
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            uuid = rs.getString("id");
            return UUID.fromString(uuid);
         }
      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }
      return null;
   }

   public void deleteUser (String Email) {
      try {
         PreparedStatement ps = connection.prepareStatement("DELETE FROM login WHERE email = ?");
         ps.setObject(1, Email);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void updateEmail (UUID uuid, String Email) {
      try {
         PreparedStatement ps = connection.prepareStatement("UPDATE login SET email = ? WHERE id = ?");
         ps.setString(1, Email);
         ps.setObject(2, uuid);
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void updatePassword (UUID uuid, String hashedPwd) {
      try {
         PreparedStatement ps = connection.prepareStatement("UPDATE login SET pwd = ? WHERE id = ?");
         ps.setString(1, hashedPwd);
         ps.setObject(2, uuid);
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