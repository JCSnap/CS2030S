public class CustomerWithType extends Customer {
  private int type;

  public CustomerWithType(int customerId, double arrivalTime, double serviceTime, int type) {
    super(customerId, arrivalTime, serviceTime);
    this.type = type;
  }

  public String getType() { // returns the actual String, not numerical representation
    String[] types = {"Deposit", "Withdrawal", "OpenAccount"};
    return types[this.type]; // type can be 0, 1, or 2
  }

  @Override 
  public String toString() {
    String str = String.format("C%d", super.getCustomerId());
    return str;
  }
}
