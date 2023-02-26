public class JoinQueueEvent extends Event {
  private Customer customer;
  private Queue queue;
  
  public JoinQueueEvent(Customer customer, Queue queue, double time) {
    super(time);
    this.customer = customer;
    this.queue = queue;
  }

  @Override
  public String toString() {
    String str = String.format(": %s joined queue %s", this.customer, queue.toString());
    return super.toString() + str;
  }

  public Event[] simulate() {
    this.queue.enq(this.customer);
    return new Event[] {
      // do nothing 
    };
  }
}



