// chose composition due to has-a relationship
public class Counter {
  private int counterId;
  private boolean isAvailable;

  public Counter(int counterId) {
    this.counterId = counterId;
    this.isAvailable = true;
  }

  @Override
  public String toString() {
    String str = String.format("S%d", this.counterId);
    return str;
  }

  public void removeAvailability() { // used to occupy the counter
    this.isAvailable = false;
  }

  public void addAvailability() { // used to free up the counter
    this.isAvailable = true;
  }

  public boolean getAvailability() {
    return this.isAvailable;
  }
}
