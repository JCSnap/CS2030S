import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GymManagement {
  private Gym gym;
  private People[] peoples;
  private Equipment[] equipments;

  private static final int TREADMILL = 0;
  private static final int DUMBBELL = 1;
  private static final int TRAINER = 0;
  private static final int CUSTOMER = 1;
  private static final int ENTER = 0;
  private static final int START = 1;
  private static final int FINISH = 2;
  

  public void printEquipment() {
    for (int i = 0; i < equipments.length; i++) {
      System.out.println(equipments[i]);
    }
  }


  public void printPeople() {
    for (int i = 0; i < peoples.length; i++) {
      System.out.println(peoples[i]);
    }
  }


  public GymManagement() {
    Scanner scanner = new Scanner(System.in);
    
    // Read Equipment
    int numEquipment = scanner.nextInt();
    this.equipments = new Equipment[numEquipment];
    
    for (int i = 0; i < numEquipment; i++) {
      int equipmentType = scanner.nextInt();
      if (equipmentType == GymManagement.TREADMILL) {
        Double speed = scanner.nextDouble();
        equipments[i] = new Treadmill(speed);
      } else if (equipmentType == GymManagement.DUMBBELL) {
        Double weight = scanner.nextDouble();
        equipments[i] = new Dumbbell(weight);
      }
    }
    
    // Read Customers
    int numPeople = scanner.nextInt();
    this.peoples = new People[numPeople];
    for (int i = 0; i < numPeople; i++) {
      int peopleKind = scanner.nextInt();
      if (peopleKind == GymManagement.TRAINER) {
        String name = scanner.next();
        peoples[i] = new Trainer(name);
      } else if (peopleKind == GymManagement.CUSTOMER) {
        String name = scanner.next();
        peoples[i] = new Customer(name);
      }
    }
    
    // Read Gym Capacity
    int capacity = scanner.nextInt();

    Gym gym = new Gym(equipments, peoples, capacity);
    this.gym = gym;

    // Read Actions
    int numActions = scanner.nextInt();
    for (int i = 0; i < numActions; i++) {
      int action = scanner.nextInt();
    
      if (action == GymManagement.ENTER) {
        int customer = scanner.nextInt();
        new Enter(this.gym, customer);
        this.gym.getStatus();
      } else if (action == GymManagement.START) {
        int trainer = scanner.nextInt();
        int customer = scanner.nextInt();
        int equipment = scanner.nextInt();
        new Start(this.gym, trainer, customer, equipment);
      } else if (action == GymManagement.FINISH) {
        int trainer = scanner.nextInt();
        new Finish(this.gym, trainer);
      }
    }
  }
}
