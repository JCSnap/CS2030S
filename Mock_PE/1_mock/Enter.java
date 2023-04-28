public class Enter {
  private Gym gym;
  private Customer customer;

  public Enter(Gym gym, int customer) {
    this.gym = gym;
    @SuppressWarnings("unchecked")
    Customer temp = (Customer) this.gym.getCustomerById(customer);
    this.customer = temp;
    if (this.gym.isFull()) {
          System.out.println(String.format("%s cannot enter", this.customer));
        } else {
          this.gym.addCount();
          System.out.println(String.format("%s can enter", this.customer));
        }
  }
}


