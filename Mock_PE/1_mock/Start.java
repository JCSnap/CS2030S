public class Start {
  private Gym gym;
  private Trainer trainer;
  private Customer customer;
  private Equipment equipment;

  public Start(Gym gym, int trainer, int customer, int equipment) {
    this.gym = gym;
    @SuppressWarnings("unchecked")
    Trainer temp = (Trainer) this.gym.getTrainerById(trainer);
    this.trainer = temp;
    @SuppressWarnings("unchecked")
    Customer temp2 = (Customer) this.gym.getCustomerById(customer);
    this.customer = temp2;
    this.equipment = this.gym.getEquipmentById(equipment);

    if (this.trainer.getIsTraining() || this.equipment.isInUse()) {
      System.out.println("Cannot Train!");
    } else {
      this.trainer.startTraining(this.customer, this.equipment);
      this.customer.startTraining();
      this.equipment.startUsing();
      this.trainer.getStatus();
    }
  }
}

