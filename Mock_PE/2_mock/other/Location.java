import java.util.List;
import java.util.ArrayList;

public class Location {
  private String name;
  private final List<Person> people = new ArrayList<>();

  public Location(String name) {
    this.name = name;
  }

  public void accept(Person person) {
    this.people.add(person);
  }

  public void remove(Person person) {
    this.people.remove(person);
  }

  public List<Person> getOccupants() {
    return this.people;
  }
}

