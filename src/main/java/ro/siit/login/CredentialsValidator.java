package ro.siit.login;

import ro.siit.model.User;

import java.sql.*;
import java.util.UUID;

public class CredentialsValidator {
   private Connection connection;

   public CredentialsValidator () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public User checkCredentials (String username, String password) {

      try {
         PreparedStatement ps = connection.prepareStatement("SELECT id, email, pwd FROM login WHERE email = ? AND pwd = ?");
         ps.setString(1, username);
         ps.setString(2, password);

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            return new User(UUID.fromString(String.valueOf(rs.getObject(1))),
                    rs.getString(2), rs.getString(3));
         } else {
            return null;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }
}