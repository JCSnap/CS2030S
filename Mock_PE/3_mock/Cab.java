public class Cab extends Car {

  public Cab(String plate, int timeUntilAvailable) {
    super(plate, timeUntilAvailable);
  }

  @Override
  public String toString() {
    String min = "min";
    if (super.getWaitTime() > 1) {
      min = "mins";
    }
    String str = String.format("Cab %s (%s %s away)", super.getPlate(), this.getWaitTime(), min);
    return str;
  }
  
  @Override
  public boolean isServiceProvided(Ride service) {
    return service.toString() == "JustRide" || service.toString() == "TakeACab";
  }
}
