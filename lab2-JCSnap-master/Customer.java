// chose composition due to has-a relationship
public class Customer {
  private int customerId;
  private double arrivalTime;
  private double serviceTime;

  public Customer(int customerId, double arrivalTime, double serviceTime) {
    this.customerId = customerId;
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
  }

  @Override
  public String toString() {
    String str = String.format("Customer %s", this.customerId);
    return str;
  }

  public int getCustomerId() {
    return this.customerId;
  }

  public double getArrivalTime() {
    return this.arrivalTime;
  }

  public double getServiceTime() {
    return this.serviceTime;
  }
}
