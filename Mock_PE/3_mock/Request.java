public class Request {
  private int distance;
  private int passengers;
  private int time;

  public Request(int distance, int passengers, int time) {
    this.distance = distance;
    this.passengers = passengers;
    this.time = time;
  }

  public int getDistance() {
    return this.distance;
  }

  public boolean isPeakHour() {
    return this.time >= 600 && this.time <= 900;
  }

  public int getPassengerCount() {
    return this.passengers;
  }
}
