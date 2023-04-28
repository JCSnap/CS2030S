public class Customer extends People {
  private boolean isTraining;

  public Customer(String name) {
    super(name);
    this.isTraining = false;
  }

  @Override
  public String toString() {
    String str = "Customer: " + super.getName();
    return str;
  }

  public boolean isTraining() {
    return this.isTraining();
  }

  public void startTraining() {
    this.isTraining = true;
  }
}
