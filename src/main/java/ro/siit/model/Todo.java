package ro.siit.model;

import java.util.Objects;

public class Todo {
   private String category;

   public Todo (String name, String category) {
      super();
      this.name = name;
      this.category = category;
   }

   @Override
   public String toString () {
      return "Todo{" +
              "name='" + name + '\'' +
              ", category='" + category + '\'' +
              '}';
   }

   public String getCategory () {
      return category;
   }

   private String name;

   public void setCategory (String category) {
      this.category = category;
   }

   public String getName () {
      return name;
   }

   public void setName (String name) {
      this.name = name;
   }

   @Override
   public boolean equals (Object o) {
      if (this == o) return true;
      if (! (o instanceof Todo)) return false;
      Todo todo = (Todo) o;
      return getName().equals(todo.getName());
   }

   @Override
   public int hashCode () {
      return Objects.hash(getName());
   }
}