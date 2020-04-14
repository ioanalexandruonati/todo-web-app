package ro.siit.model;

import java.util.Objects;

public class Todo {

   public Todo (String name) {
      super();
      this.name = name;
   }

   private String name;

	public String getName() {
		return name;
        }

   public void setName (String name) {
      this.name = name;
   }

   @Override
   public String toString () {
      return "Todo [name=" + name + "]";
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