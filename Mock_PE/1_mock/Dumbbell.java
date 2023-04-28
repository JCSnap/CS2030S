public class Dumbbell extends Equipment {
  private double weight;

  public Dumbbell(double weight) {
    super();
    this.weight = weight;
  }

  @Override 
  public String toString() {
    String equipmentStatus = "Equipment: Dumbbell at weight " + this.weight;
    return equipmentStatus;
  }
}
