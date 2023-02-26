// Is-a relationship, an Arrival is an Event because it is associated with a time
public class ArrivalEvent extends Event {
  private Customer customer; // composition relationship
  private Counter[] counters;
  
  public ArrivalEvent(Customer customer, Counter[] counters, double time) {
    super(time);
    this.customer = customer;
    this.counters = counters;
  }
  
  @Override
  public String toString() {
    String str = String.format(": Customer %d arrives", this.customer.getCustomerId());
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    int counterId = this.findAvailable(); // find the first free counter
    if (counterId == -1) { // no free counter
      return new Event[] {
        new DepartureEvent(this.customer, this.getTime())
      };
    } else {
      return new Event[] {
        new BeginServiceEvent(this.customer, this.counters[counterId], this.getTime())
      };
    }
  }

  private int findAvailable() { // helper function to find first free counter, private for information hiding
    int counterId = -1; // default indicates no free counter
    for (int i = 0; i < counters.length; i++) {
      if (counters[i].getAvailability()) {
        counterId = i;
        break;
      } else {
        continue;
      }
    }
    return counterId;
  }
}
