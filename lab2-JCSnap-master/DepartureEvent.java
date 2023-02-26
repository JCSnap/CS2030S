// is-a relationship, Departure is an event as it is associated with a time
public class DepartureEvent extends Event {
  private CustomerWithType customer; // has-a customer
  private BankWithQueue bank;
  
  public DepartureEvent(CustomerWithType customer, BankWithQueue bank, double time) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    String str = String.format(": %s departed", this.customer);
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    Queue queue = this.bank.getQueue();
    int counter = this.bank.findAvailable();
    if (queue.isEmpty() || counter == -1) {  
      return new Event[] {};
    } else {
      // get customer from front of queue
      CustomerWithType nextCustomer = (CustomerWithType) queue.deq();
      return new Event[] {
        new BeginServiceEvent(nextCustomer, this.bank, super.getTime())
      };
    }
  }

}


