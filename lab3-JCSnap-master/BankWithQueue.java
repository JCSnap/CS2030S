public class BankWithQueue extends Bank {
  private Queue<Customer> queue;

  public BankWithQueue(int numberOfCounters, int maxCounterQueueSize, int maxBankQueueSize) {
    super(numberOfCounters, maxCounterQueueSize);
    this.queue = new Queue<Customer>(maxBankQueueSize);
  }

  public boolean isQueueFull() {
    return this.queue.isFull();
  }

  public boolean isQueueEmpty() {
    return this.queue.isEmpty();
  }

  public String getQueueStatus() {
    return this.queue.toString();
  }

  public boolean areCountersQueueFull() {
    Array<Counter> counters = super.getCounters();
    boolean isFull = true;
    for (int i = 0; i < counters.getSize(); i++) {
      Counter curCounter = counters.get(i);
      isFull = isFull && !curCounter.hasQueueSpots();
    }
    return isFull;
  }

  public Counter getShortestQueueCounter() {
    Array<Counter> counters = super.getCounters();
    int min = Integer.MAX_VALUE;
    Counter counterWithShortestQueue = counters.get(0);
    for (int i = 0; i < counters.getSize(); i++) {
      Counter curCounter = counters.get(i);
      int temp = curCounter.getQueueSize();
      if (temp < min) {
        min = temp;
        counterWithShortestQueue = curCounter;
      } else {
        // continue
      }
    }
    return counterWithShortestQueue;
  }

  public boolean areQueuesEmpty() {
    Array<Counter> counters = super.getCounters();
    boolean areEmpty = true;
    for (int i = 0; i < counters.getSize(); i++) {
      Counter curCounter = counters.get(i);
      areEmpty = areEmpty && curCounter.isQueueEmpty();
    }
    return areEmpty;
  }

  public CustomerWithType getNextCustomer() {
    return (CustomerWithType) this.queue.deq();
  }

  public void addCustomerToQueue(Customer customer) {
    this.queue.enq(customer);
  }
}
