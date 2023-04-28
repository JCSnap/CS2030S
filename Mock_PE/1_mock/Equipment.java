public class Equipment {
  private boolean inUse;

  public Equipment() {
    this.inUse = false;
  }

  public void startUsing() {
    this.inUse = true;
  }

  public boolean isInUse() {
    return this.inUse;
  }

  public void stopUsing() {
    this.inUse = false;
  }
}
