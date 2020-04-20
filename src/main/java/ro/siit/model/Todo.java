package ro.siit.model;

import java.util.Objects;

public class Todo {
   private String category;

   private String description;

   public Todo (String description, String category) {
      super();
      this.description = description;
      this.category = category;
   }

   public String getCategory () {
      return category;
   }


   public void setCategory (String category) {
      this.category = category;
   }

   public String getDescription () {
      return description;
   }

   public void setDescription (String name) {
      this.description = name;
   }

   @Override
   public boolean equals (Object o) {
      if (this == o) return true;
      if (! (o instanceof Todo)) return false;
      Todo todo = (Todo) o;
      return getDescription().equals(todo.getDescription());
   }

   @Override
   public int hashCode () {
      return Objects.hash(getDescription());
   }
}