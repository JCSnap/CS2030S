import java.util.List;
import java.util.ArrayList;

public class Person {
  private final String name;
  private final List<Virus> listOfViruses = new ArrayList<>();
  private double random;

  public Person(String name) {
    this.name = name;
  }
  
  public void infectWith(List<? extends Virus> listOfViruses, double random) {
    for (Virus v : listOfViruses) {
      this.listOfViruses.add(v);
    }
  }

  public List<? extends Virus> transmit(double random) {
    List<Virus> toSpread = new ArrayList<>();
    for (Virus v : listOfViruses) {
      toSpread.add(v.spread(random));
    }
    return toSpread;
  }

  public boolean test(String virusName) {
    boolean bool = false;
    for (int i = 0; i < listOfViruses.size(); i++) {
      Virus curVirus = listOfViruses.get(i);
      bool = bool || curVirus.test(virusName);
    }
    return bool;
  }

  public String getName() {
    return this.name;
  }
  
  @Override 
  public String toString() {
    return this.name;
  }

  public List<Virus> getListOfViruses() {
    return this.listOfViruses;
  }
}
