public class TakeACab extends Ride {
  private int kmFare;
  private int bookingFee;

  public TakeACab() {
    this.kmFare = 33;
    this.bookingFee = 200;
  }
  
  @Override
  public int computeFare(Request request) {
    int fare = this.bookingFee + kmFare * request.getDistance();
    return fare;
  }

  @Override
  public String toString() {
    return "TakeACab";
  }
}

