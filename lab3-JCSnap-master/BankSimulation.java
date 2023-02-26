import java.util.Scanner;

/**
 * This class implements a bank simulation.
 *
 * @author Justin Cheah Yun Fei (12G)
 * @version CS2030S AY21/22 Semester 2
 */ 
class BankSimulation extends Simulation {
  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  private Event[] initEvents;
  private BankWithQueue bank;
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
    int numberOfCustomers = sc.nextInt();
    this.initEvents = new Event[numberOfCustomers];
    int numOfCounters = sc.nextInt();
    int maxCounterQueueSize = sc.nextInt();
    int maxBankQueueSize = sc.nextInt();
    this.bank = new BankWithQueue(numOfCounters, maxCounterQueueSize, maxBankQueueSize);
    initCustomerEvents(sc); // initiate customers 
  }

  private void initCustomerEvents(Scanner sc) {
    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      int type = sc.nextInt();
      CustomerWithType customer = new CustomerWithType(id, arrivalTime, serviceTime, type); 
      initEvents[id] = new ArrivalEvent(customer, this.bank, arrivalTime); 
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
