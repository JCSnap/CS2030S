public class ShareARide extends Ride {
  private int kmFare;
  private int surCharge;

  public ShareARide() {
    this.kmFare = 50;
    this.surCharge = 500;
  }

  @Override
  public int computeFare(Request request) {
    int fare = request.getDistance() * this.kmFare;
    if (request.isPeakHour()) {
      fare = fare + this.surCharge;
    }
    int passengers = request.getPassengerCount();
    return fare / passengers;
  }

  @Override
  public String toString() {
    return "ShareARide";
  }
}
