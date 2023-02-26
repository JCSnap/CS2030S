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
    if (this.bank.hasAvailable()) { // free counter
      return new Event[] {
        new BeginServiceEvent(this.customer, this.bank, super.getTime())
      };
    } else if (!this.bank.areCountersQueueFull()) { // there exist a counter that is not full
      return new Event[] {
        new CounterJoinQueueEvent(
            this.customer, this.bank.getShortestQueueCounter(), super.getTime()
            )
      };
    } else if (!this.bank.isQueueFull()) { // there exist at least a free spot in main queue
      return new Event[] {
        new BankJoinQueueEvent(this.customer, this.bank, super.getTime())
      };
    } else {
      return new Event[] {
        new DepartureEvent(this.customer, this.bank, super.getTime())
      };
    }
  }
}
