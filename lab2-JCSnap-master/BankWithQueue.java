public class BankWithQueue extends Bank {
  private Queue queue;

  public BankWithQueue(int numberOfCounters, int maxQueueSize) {
    super(numberOfCounters);
    this.queue = new Queue(maxQueueSize);
  }

  public Queue getQueue() {
    return this.queue;
  }

  public String getQueueStatus() {
    return this.queue.toString();
  }
}
