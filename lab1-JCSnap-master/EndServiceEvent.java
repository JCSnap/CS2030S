// is-a relationship, EndService is an Event as it is associated with a time
public class EndServiceEvent extends Event {
  private Customer customer; // EndService has-a customer
  private Counter counter; // EndService has-a counter

  public EndServiceEvent(Customer customer, Counter counter, double endTime) {
    super(endTime);
    this.customer = customer;
    this.counter = counter;
  }


  @Override
  public String toString() {
    String str = String.format(": Customer %d service done (by Counter %d)",
          this.customer.getCustomerId(), this.counter.getCounterId());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.counter.addAvailability(); // free up counter
    return new Event[] {
        new DepartureEvent(this.customer, this.getTime())
      };
  }
}
