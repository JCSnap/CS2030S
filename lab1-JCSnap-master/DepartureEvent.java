// is-a relationship, Departure is an event as it is associated with a time
public class DepartureEvent extends Event {
  private Customer customer; // has-a customer
  
  public DepartureEvent(Customer customer, double time) {
    super(time);
    this.customer = customer;
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d departed", this.customer.getCustomerId());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

}


