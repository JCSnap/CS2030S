public class CounterJoinQueueEvent extends Event {
  private Customer customer;
  private Counter counter;

  public CounterJoinQueueEvent(Customer customer, Counter counter, double time) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String str = String.format(": %s joined counter queue (at %s %s)", 
        this.customer, this.counter, this.counter.getQueueStatus());
    return super.toString() + str;
  }

  public Event[] simulate() {
    this.counter.addCustomerToQueue(this.customer);
    return new Event[] {
      // do nothing 
    };
  }
}


