// chose composition due to has-a relationship - An Event can have a Customer but a Customer is not an Event
public class Customer {
  private int customerId;
  private double arrivalTime;
  private double serviceTime;


  public Customer(int customerId, double arrivalTime, double serviceTime) {
    this.customerId = customerId;
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
  }

  public int getCustomerId() {
    return customerId;
  }

  public double getArrivalTime() {
    return arrivalTime;
  }

  public double getServiceTime() {
    return serviceTime;
  }
}
