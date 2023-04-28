
/**
 * Represent a function that produce a value.
 * CS2030S Lab 5
 * AY22/23 Semester 2
 *
 * @param <T> The type of the value produced.
 */
package cs2030s.fp;

@FunctionalInterface
public interface Producer<T> {
  /**
   * The functional method to produce a value.
   *
   * @return The value produced.
   */
  T produce();
}
