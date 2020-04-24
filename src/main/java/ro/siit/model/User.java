package ro.siit.model;


import java.util.UUID;

public class User {
   private final UUID id;
   private final String email;
   private final String hashedPwd;

   public User (UUID uuid, String username, String hashedPwd) {
      this.id = UUID.randomUUID();
      this.email = username;
      this.hashedPwd = hashedPwd;
   }

   public UUID getId () {
      return id;
   }

   public String getEmail () {
      return email;
   }

   public String getPwd () {
      return hashedPwd;
   }

}
