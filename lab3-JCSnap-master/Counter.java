// chose composition due to has-a relationship
public class Counter implements Comparable<Counter> {
  private int counterId;
  private boolean isAvailable;
  private Queue<Customer> queue;

  public Counter(int counterId, int maxCounterQueueSize) {
    this.counterId = counterId;
    this.isAvailable = true;
    this.queue = new Queue<Customer>(maxCounterQueueSize);
  }

  @Override
  public String toString() {
    String str = String.format("S%d", this.counterId);
    return str;
  }

  public void removeAvailability() { // used to occupy the counter
    this.isAvailable = false;
  }

  public void addAvailability() { // used to free up the counter
    this.isAvailable = true;
  }

  public boolean getAvailability() {
    return this.isAvailable;
  }

  public boolean hasQueueSpots() {
    return !this.queue.isFull();
  }

  public int getQueueSize() {
    return this.queue.length();
  }

  public boolean isQueueEmpty() {
    return this.queue.isEmpty();
  }

  public String getQueueStatus() {
    return this.queue.toString();
  }

  public CustomerWithType getNextCustomer() {
    return (CustomerWithType) this.queue.deq();
  }

  public void addCustomerToQueue(Customer customer) {
    this.queue.enq(customer);
  }

  @Override 
  public int compareTo(Counter c) {
    return this.getQueueSize() < c.getQueueSize()
      ? -1
      : this.getQueueSize() == c.getQueueSize()
      ? 0
      : 1;
  }
}
