// Is-a relationship, an Arrival is an Event because it is associated with a time
public class ArrivalEvent extends Event {
  private CustomerWithType customer; // composition relationship
  private BankWithQueue bank;

  public ArrivalEvent(CustomerWithType customer, BankWithQueue bank, double time) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }
  
  @Override
  public String toString() {
    String str = String.format(": %s arrived %s", this.customer, this.bank.getQueueStatus());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    int counterId = bank.findAvailable(); // find the first free counter
    if (counterId == -1) { // no free counter
      Queue queue = this.bank.getQueue();
      if (queue.isFull()) {  
        return new Event[] {
          new DepartureEvent(this.customer, this.bank, super.getTime())
        };
      } else {
        return new Event[] {
          new JoinQueueEvent(this.customer, queue, super.getTime())
        };
      }
    } else {
      return new Event[] {
        new BeginServiceEvent(this.customer, this.bank, super.getTime())
      };
    }
  }
}
