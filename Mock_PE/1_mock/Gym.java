public class Gym {
  private Equipment[] equipments;
  private People[] peoples;
  private int capacity;
  private int curCount;

  public Gym(Equipment[] equipments, People[] peoples, int capacity) {
    this.equipments = equipments;
    this.peoples = peoples;
    this.capacity = capacity;
    this.curCount = 0;
  }

  public void addCount() {
    this.curCount++;
  }

  public boolean isFull() {
    return this.curCount >= this.capacity;
  }

  public People getCustomerById(int id) {
    return peoples[id];
  }

  public People getTrainerById(int id) {
    return peoples[id];
  }

  public Equipment getEquipmentById(int id) {
    return equipments[id];
  }

  public void getStatus() {
    System.out.println("Gym Capacity: " + this.curCount + "/" + this.capacity);
  }  
}
