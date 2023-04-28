public abstract class Virus {
  private final String name;
  final double probability;

  public Virus(String name, double probability) {
    this.name = name;
    this.probability = probability;
  }

  public abstract Virus spread(double random);

  public boolean test(String name) {
    return this.name == name;
  }
  
  @Override
  public String toString() {
    String str = String.format("%s with %s probability of mutating", this.name, this.probability);
    return str;
  }

  public boolean lowerThanProbability(double num) {
    return num <= this.probability;
  }

  public double getProbability() {
    return this.probability;
  }
}
