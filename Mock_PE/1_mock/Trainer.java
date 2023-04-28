public class Trainer extends People {
  private Customer customerTrained;
  private Equipment equipmentUsed;
  private boolean isTraining;

  
  public Trainer(String name) {
    super(name);
    this.customerTrained = null;
    this.equipmentUsed = null;
    this.isTraining = false;
  }

  public boolean getIsTraining() {
    return this.isTraining;
  }

  @Override
  public String toString() {
    String str = "Trainer: " + super.getName();
    return str;
  }


  public void startTraining(Customer customer, Equipment equipment) {
    this.isTraining = true;
    this.customerTrained = customer;
    this.equipmentUsed = equipment;
  }

  public void getStatus() {
    String str = String.format("Trainer: " + super.getName() + " training " + this.customerTrained.toString() +
                                          " using " + this.equipmentUsed);
    System.out.println(str);
  }

  public void finishTraining() {
    this.equipmentUsed.stopUsing();
    this.customerTrained = null;
    this.equipmentUsed = null;
    this.isTraining = false;
  }
}
