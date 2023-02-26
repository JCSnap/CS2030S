// is-a relationship, EndService is an Event as it is associated with a time
public class EndServiceEvent extends Event {
  private CustomerWithType customer; // EndService has-a customer
  private BankWithQueue bank;
  private Counter counter; // EndService has-a counter

  public EndServiceEvent(
      CustomerWithType customer, 
      BankWithQueue bank, 
      Counter counter, 
      double endTime
  ) {
    super(endTime);
    this.customer = customer;
    this.bank = bank;
    this.counter = counter;
  }


  @Override
  public String toString() {
    String str = String.format(": %s %s done (by %s)",
          this.customer, this.customer.getType(), this.counter);
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.counter.addAvailability(); // free up counter
    return new Event[] {
        new DepartureEvent(this.customer, this.bank, super.getTime())
    };
  }
}
