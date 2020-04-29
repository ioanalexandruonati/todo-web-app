package ro.siit.service;


import ro.siit.model.User;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.UUID;

public class UserService {

   private Connection getConnection () throws URISyntaxException, SQLException {
      String dbUrl = System.getenv("JDBC_DATABASE_URL");
      return DriverManager.getConnection(dbUrl);
   }

   public void addUser (User user) {
      try {
         PreparedStatement ps = getConnection().prepareStatement("INSERT INTO login (id, email, pwd) VALUES (?, ?, ?)");
         ps.setObject(1, user.getId());
         ps.setString(2, user.getEmail());
         ps.setString(3, user.getPwd());
         ps.executeUpdate();
      } catch (SQLException | URISyntaxException e) {
         e.printStackTrace();
      }
   }

   public UUID getUserIDFromDB (String username) {
      String uuid = null;
      try {
         PreparedStatement ps = getConnection().prepareStatement("SELECT id FROM login WHERE email=?");
         ps.setString(1, username);
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            uuid = rs.getString("id");
            return UUID.fromString(uuid);
         }
      } catch (SQLException | URISyntaxException throwables) {
         throwables.printStackTrace();
      }
      return null;
   }

   public void deleteUser (String username) {
      try {
         PreparedStatement ps = getConnection().prepareStatement("DELETE FROM login WHERE email = ?");
         ps.setObject(1, username);
         ps.executeUpdate();
      } catch (SQLException | URISyntaxException e) {
         e.printStackTrace();
      }
   }

   public void updateUsername (UUID uuid, String username) {
      try {
         PreparedStatement ps = getConnection().prepareStatement("UPDATE login SET email = ? WHERE id = ?");
         ps.setString(1, username);
         ps.setObject(2, uuid);
         ps.executeUpdate();
      } catch (SQLException | URISyntaxException e) {
         e.printStackTrace();
      }
   }

   public void updatePassword (UUID uuid, String hashedPwd) {
      try {
         PreparedStatement ps = getConnection().prepareStatement("UPDATE login SET pwd = ? WHERE id = ?");
         ps.setString(1, hashedPwd);
         ps.setObject(2, uuid);
         ps.executeUpdate();
      } catch (SQLException | URISyntaxException e) {
         e.printStackTrace();
      }
   }

   @Override
   protected void finalize () throws Throwable {
      this.getConnection().close();
   }
}