/**
 * A boolean condition with parameter x that can be applied to
 * a string.  Returns true if the string is longer than x; false
 * otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
public class LongerThan implements BooleanCondition<String> {
  private int maxSize;

  public LongerThan(Integer maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public boolean test(String content) {
    return content.length() > maxSize;
  }
}

