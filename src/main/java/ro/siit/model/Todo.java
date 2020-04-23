package ro.siit.model;

import java.util.Objects;
import java.util.UUID;

public class Todo {
   private String category;

   private String description;

   private String date;

   private String priority;

   private int id;


   public Todo (int id, String description, String category, String date, String priority) {
      super();
      this.description = description;
      this.category = category;
      this.date = date;
      this.id = id;
      this.priority = priority;
   }

   public String getPriority () {
      return priority;
   }

   public void setPriority (String priority) {
      this.priority = priority;
   }

   public void setDate (String date) {
      this.date = date;
   }

   public int getId () {
      return id;
   }

   public void setId (int id) {
      this.id = id;
   }

   public String getDate () {
      return date;
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