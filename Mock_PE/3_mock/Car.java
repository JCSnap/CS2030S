public class Car {
  private String plate;
  private int timeUntilAvailable;

  public Car(String plate, int timeUntilAvailable) {
    this.plate = plate;
    this.timeUntilAvailable = timeUntilAvailable;
  }

  public String getPlate() {
    return this.plate;
  }

  public int getWaitTime() {
    return this.timeUntilAvailable;
  }

  public boolean isServiceProvided(Ride service) {
    return false;
  }
}
