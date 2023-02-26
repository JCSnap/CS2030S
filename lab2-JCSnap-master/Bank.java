public class Bank {
  private Counter[] counters;

  public Bank(int numOfCounters) {
    initCounters(numOfCounters); // initiate counters
  }
  
  private void initCounters(int numOfCounters) {
    this.counters = new Counter[numOfCounters]; // creating an array of counters
    this.initCounters();
  }

  private void initCounters() {
    for (int i = 0; i < counters.length; i++) {
      this.counters[i] = new Counter(i); // each index contains a new unique counter
      this.counters[i].addAvailability(); // free up Availability 
    }
  }

  public int findAvailable() { // helper function to find first free counter
    int counterId = -1; // default indicates no free counter
    for (int i = 0; i < counters.length; i++) {
      if (counters[i].getAvailability()) {
        counterId = i;
        break;
      } else {
        continue;
      }
    }
    return counterId;
  }

  public Counter getCounter(int counterId) {
    return counters[counterId];
  }
}
