public class BankJoinQueueEvent extends Event {
  private Customer customer;
  private BankWithQueue bank;
  
  public BankJoinQueueEvent(Customer customer, BankWithQueue bank, double time) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    String str = String.format(
        ": %s joined bank queue %s", this.customer, this.bank.getQueueStatus()
        );
    return super.toString() + str;
  }

  public Event[] simulate() {
    this.bank.addCustomerToQueue(this.customer);
    return new Event[] {
      // do nothing 
    };
  }
}



