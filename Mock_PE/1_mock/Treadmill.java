public class Treadmill extends Equipment {
  private double speed;

  public Treadmill(double speed) {
    super();
    this.speed = speed;
  }

  public String toString() {
    String equipmentStatus = "Equipment: Treadmill at speed " + this.speed;
    return equipmentStatus;
  }
}
