public class PrivateCar extends Car {

  public PrivateCar(String plate, int timeUntilAvailable) {
    super(plate, timeUntilAvailable);
  }

  @Override
  public String toString() {
    String min = "min";
    if (this.getWaitTime() >  1) {
      min = "mins";
    }
    String str = String.format("PrivateCar %s (%s %s away)", super.getPlate(), this.getWaitTime(), min);
    return str;
  }
  
  @Override
  public boolean isServiceProvided(Ride service) {
    return service.toString() == "JustRide" || service.toString() == "ShareARide";
  }

}
