package ro.siit.service;

public class LoginService {

   public boolean isValid(String email, String password) {
      if (email.equals( "Ioan"/*object - method call to query to query from the database*/)
              && password.equals("Ioan"/*object - method call to query to query from the database*/)){
         return true;
      }
      return false;
   }
}
