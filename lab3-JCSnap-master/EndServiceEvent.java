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
    String str = String.format(": %s %s done (by %s %s)",
          this.customer, this.customer.getType(), this.counter, this.counter.getQueueStatus());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.counter.addAvailability(); // free up counter
    if (this.counter.isQueueEmpty()) {
      if (this.bank.isQueueEmpty()) {
        return new Event[] { // counter queue empty, bank queue also empty
          new DepartureEvent(this.customer, this.bank, super.getTime())
        };
      } else {
        return new Event[] { // when counter queue size is set to 0, bank queue not empty
          new DepartureEvent(this.customer, this.bank, super.getTime()),
          new BeginServiceEvent(this.bank.getNextCustomer(), this.bank, super.getTime()) 
        };
      }
    } else {
      if (this.bank.isQueueEmpty()) {
        return new Event[] { // Counter queue not empty, bank queue empty
          new DepartureEvent(this.customer, this.bank, super.getTime()),
          new BeginServiceEvent(this.counter.getNextCustomer(), this.bank, super.getTime())
        };
      } else {
        return new Event[] { // Counter queue not empty, bank queue not empty
          new DepartureEvent(this.customer, this.bank, super.getTime()),
          new BeginServiceEvent(this.counter.getNextCustomer(), this.bank, super.getTime()),
          new CounterJoinQueueEvent(
              this.bank.getNextCustomer(), this.bank.getShortestQueueCounter(), super.getTime()
              )
        };
      }
    }
  }
}
