public class Bank {
  private Array<Counter> counters;

  public Bank(int numOfCounters, int maxCounterQueueSize) {
    initCounters(numOfCounters, maxCounterQueueSize); // initiate counters
  }
  
  private void initCounters(int numOfCounters, int maxCounterQueueSize) {
    Array<Counter> temp = new Array<Counter>(numOfCounters);
    this.counters = temp;
    for (int i = 0; i < counters.getSize(); i++) {
      this.counters.set(i, new Counter(i, maxCounterQueueSize)); // one counter per index
      this.counters.get(i).addAvailability(); // free up Availability 
    }
  }

  public boolean hasAvailable() { // check whether there is free counter
    boolean bool = false;
    for (int i = 0; i < counters.getSize(); i++) {
      if (counters.get(i).getAvailability()) {
        bool = true; 
        break; // after finding a single instance of free counter
      } else {
        continue;
      }
    }
    return bool;
  }

  public Counter findAvailableCounter() {
    int counterId = -1; // default indicates no free counter
    for (int i = 0; i < counters.getSize(); i++) {
      if (counters.get(i).getAvailability()) {
        counterId = i;
        break; // after finding smallest id free counter
      } else {
        continue;
      }
    }
    return this.counters.get(counterId);
  }

  public Array<Counter> getCounters() {
    return this.counters;
  }
}
