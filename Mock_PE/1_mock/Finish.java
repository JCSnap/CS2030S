public class Finish {
  private Trainer trainer;
  private Gym gym;

  public Finish(Gym gym, int trainer) {
    this.gym = gym;
    Trainer temp = (Trainer) this.gym.getTrainerById(trainer);
    this.trainer = temp;
    if (!this.trainer.getIsTraining()) {
          String str = String.format("%s is not training", this.trainer);
          System.out.println(str);
        } else {
          this.trainer.finishTraining();
          String str = String.format("%s has finished training", this.trainer);
          System.out.println(str);
        }
  }

}
