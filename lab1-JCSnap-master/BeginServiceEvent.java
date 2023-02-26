// is-a relationship, BeginService is an Event as it is associated with a time
public class BeginServiceEvent extends Event {
  private Customer customer;
  private Counter counter;

  public BeginServiceEvent(Customer customer, Counter counter, double time) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d service begin (by Counter %d)",
          this.customer.getCustomerId(), this.counter.getCounterId());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.counter.removeAvailability(); // occupy the counter
    double endTime = this.getTime() + this.customer.getServiceTime(); 
    return new Event[] {
        new EndServiceEvent(this.customer, this.counter, endTime) // pass the end time to EndService
      };
  }

}


