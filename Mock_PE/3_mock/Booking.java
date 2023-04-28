public class Booking implements Comparable<Booking> {
  private Car car;
  private Ride service;
  private Request request;

  public Booking(Car car, Ride service, Request request) throws IllegalArgumentException {
    if (!isValid(car, service)) {
      throw new IllegalArgumentException(constructMessage());
    } else {
      this.car = car;
      this.service = service;
      this.request = request;
    }
  }

  private String constructMessage() {
    String str = String.format("%s does not provide the ShareARide service.", this.car);
    return str;
  }

  private boolean isValid(Car car, Ride service) {
    return car.isServiceProvided(service);
  }

  @Override
  public int compareTo(Booking other) {
    int diff = this.service.computeFare(this.request) - other.service.computeFare(this.request);
    if (diff == 0) {
      diff = this.car.getWaitTime() - other.car.getWaitTime();
    }
    return diff;
  }
}

