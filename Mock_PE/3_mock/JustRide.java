public class JustRide extends Ride {
  private int kmFare;
  private int surCharge;

  public JustRide() {
    this.kmFare = 22;
    this.surCharge = 500;
  }
  
  @Override
  public int computeFare(Request request) {
    int fare;
    fare = kmFare * request.getDistance();
    boolean isPeakHour = request.isPeakHour();
    if (isPeakHour) {
      fare = fare + this.surCharge;
    }
    int passengers = request.getPassengerCount();
    return fare;
  }

  @Override
  public String toString() {
    return "JustRide";
  }

}
