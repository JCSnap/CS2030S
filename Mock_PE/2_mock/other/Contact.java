public class Contact {
  private final Person first;
  private final Person second;
  private final double time;

  public Contact(Person first, Person second, double time) {
    this.first = first;
    this.second = second;
    this.time = time;
    transmit();
  }

  private void transmit() {
    Double rand = RandomNumberGenerator.nextDouble();
    this.first.infectWith(this.second.transmit(rand), rand);
    this.second.infectWith(this.first.transmit(rand), rand);
  }

  public boolean involves(Person p, double time) { 
    return (p == this.first || p == this.second) && time > this.time; 
  }

  public Person other(Person p) {
    return p == this.first
      ? this.second
      : this.first;
  }

  public double timeOfContact() {
    return this.time;
  }
}
