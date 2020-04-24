package ro.siit.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.siit.model.User;

import java.sql.*;
import java.util.UUID;

public class CredentialsValidator {

   private Connection connection;
   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


   public CredentialsValidator () {
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siit10?user=postgres&password=postgres");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }


//  When we will connect directly to heroku.

//   public CredentialsValidator () {
//         try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dagk3c0os0qu7v?user=ciklwxejzwyibq&password=5abbc2b1bab4f067c16a5384b9d94829532d21c47e22dcf3c80e022d1c3998a8");
//         } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//         }
//      }

   public User checkCredentials (String email, String password) {

      try {
         PreparedStatement ps = connection.prepareStatement("SELECT id, email, pwd FROM login WHERE pwd = ?");
         ps.setString(1, passwordEncoder.encode(password));

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            return new User(UUID.fromString(String.valueOf(rs.getObject(1))),
                    rs.getString(2), rs.getString(3));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }
}