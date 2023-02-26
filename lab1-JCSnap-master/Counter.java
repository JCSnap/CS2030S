// chose composition due to has-a relationship - An event can have a counter but a counter is not an event
public class Counter {
  private int counterId;
  private boolean isAvailable;

  public Counter(int counterId) {
    this.counterId = counterId;
    this.isAvailable = true;
  }

  public void removeAvailability() { // used to occupy the counter
    this.isAvailable = false;
  }

  public void addAvailability() { // used to free up the counter
    this.isAvailable = true;
  }

  public int getCounterId() {
    return this.counterId;
  }

  public boolean getAvailability() {
    return this.isAvailable;
  }
}
