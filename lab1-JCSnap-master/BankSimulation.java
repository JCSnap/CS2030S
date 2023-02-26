import java.util.Scanner;

/**
 * This class implements a bank simulation.
 *
 * @author Justin Cheah Yun Fei (12G)
 * @version CS2030S AY21/22 Semester 2
 */ 
class BankSimulation extends Simulation {
  /** 
   * The availability of counters in the bank. 
   */
  public Counter[] counters; 

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /** 
   * Constructor for a bank simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public BankSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();

    initCounters(numOfCounters); // initiate counters
    initCustomerEvents(sc); // initiate customers 
  }

  private void initCounters(int numOfCounters) {
    counters = new Counter[numOfCounters]; // creating an array of counters
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter(i); // each index contains an instance of a counter with their id
      counters[i].addAvailability(); // free up Availability 
    }
  }

  private void initCustomerEvents(Scanner sc) {
    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      Customer customer = new Customer(id, arrivalTime, serviceTime); // Initialising instances of customers
      initEvents[id] = new ArrivalEvent(customer, counters, arrivalTime); //  programme starts with the arrival
      id += 1;
    }
  }
  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
