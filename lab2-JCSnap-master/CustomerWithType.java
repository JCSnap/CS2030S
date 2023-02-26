public class CustomerWithType extends Customer {
  int type;

  public CustomerWithType(int customerId, double arrivalTime, double serviceTime, int type) {
    super(customerId, arrivalTime, serviceTime);
    this.type = type;
  }

  public String getType() { // returns the actual String, not numerical representation
    return type == 0
      ? "Deposit"
      : "Withdrawal";
  }

  @Override 
  public String toString() {
    String str = String.format("C%d", super.getCustomerId());
    return str;
  }
}
