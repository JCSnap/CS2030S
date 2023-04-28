public class IllegalArgumentException extends Exception {
  private String message;

  public IllegalArgumentException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
