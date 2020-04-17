package ro.siit.model;

import java.util.UUID;

public class User {
   private final UUID id;
   private String email;
   private String pwd;

   public User (UUID uuid, String username, String pwd) {
      this.id = UUID.randomUUID();
      this.email = username;
      this.pwd = pwd;
   }

   public UUID getId () {
      return id;
   }

   public String getEmail () {
      return email;
   }

   public void setEmail (String username) {
      this.email = username;
   }

   public String getPwd () {
      return pwd;
   }

   public void setPwd (String passwd) {
      this.pwd = passwd;
   }
}
