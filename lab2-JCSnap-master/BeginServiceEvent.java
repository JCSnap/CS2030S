// is-a relationship, BeginService is an Event as it is associated with a time
public class BeginServiceEvent extends Event {
  private CustomerWithType customer;
  private BankWithQueue bank;
  private Counter counter;
  
  public BeginServiceEvent(CustomerWithType customer, BankWithQueue bank, double time) {
    super(time);
    this.customer = customer;
    this.bank = bank;
    int counterId = this.bank.findAvailable();
    this.counter = this.bank.getCounter(counterId);
  }

  @Override
  public String toString() {
    String str = String.format(": %s %s begin (by %s)",
          this.customer, this.customer.getType(), this.counter);
    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    this.counter.removeAvailability(); // occupy the counter
    double endTime = super.getTime() + this.customer.getServiceTime(); 
    return new Event[] {
        new EndServiceEvent(this.customer, this.bank, this.counter, endTime)
    };
  }

}


