/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */

public class LastDigitsOfHashCode implements Transformer<Object, Integer> {
  private int k;

  public LastDigitsOfHashCode(int k) {
    this.k = k;
  }

  @Override 
  public Integer transform(Object content) {
    int curValue = content.hashCode();
    String curValueString = String.valueOf(curValue);
    int len = curValueString.length();
    int count = 0;
    String lastk = "";
    for (int i = len - 1; i >= 0; i--) {
      if (count >= this.k) {
        break;
      } else {
        char curChar = curValueString.charAt(i);
        lastk = curChar + lastk;
        count = count + 1;
      }
    }
    int lastkFinal = Integer.parseInt(lastk);
    return lastkFinal;
  }
}

