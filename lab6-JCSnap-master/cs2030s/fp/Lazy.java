package cs2030s.fp;

/** 
 * Used to create values that are evaluated lazily where the values
 * are not computed until they are needed.
 *
 * @author Justin Cheah Yun Fei 
 * @version CS2030S AY22/23 Sem 2
 */
public class Lazy<T> {
  /** 
   * Producer with Producer interface.
   */
  private Producer<? extends T> producer;
  /**
   * Value with Maybe class.
   */
  private Maybe<T> value;

  /**
   * Constructs a lazy value from a given value.
   *
   * @param v the given value
   */
  private Lazy(T v) {
    this.value = Maybe.some(v);
    this.producer = () -> v;
  }

  /**
   * Constructs a lazy value from a producer.
   *
   * @param s the given producer
   */
  private Lazy(Producer<? extends T> s) {
    this.value = Maybe.none();
    this.producer = s;
  }

  /**
   * Factory method for constructor that takes in value.
   *
   * @param <T> the type of the given value
   * @param v the given value
   * @return the lazy value
   */
  public static <T> Lazy<T> of(T v) {
    return new Lazy<>(v);
  }

  /**
   * Factory method for constructor that takes in producer.
   *
   * @param <T> the type of the given value
   * @param s the given producer
   * @return the lazy value
   */
  public static <T> Lazy<T> of(Producer<? extends T> s) {
    return new Lazy<>(s);
  }

  /**
   * Evaluate the value. If there is no "cached" value, ie. the
   * value has not been evaluated, evaluate it and return. If
   * it has been cached, return thie cached value.
   *
   * @return the value
   */
  public T get() {
    if (this.value.equals(Maybe.none())) {
      T temp = this.value.orElseGet(this.producer);
      this.value = Maybe.of(temp);
      return temp;
    } else {
      return this.value.orElseGet(this.producer);
    }
  }

  /**
   * Create string representation.
   *
   * @return ? if value not evaluated, value otherwise
   */
  @Override
  public String toString() {
    if (this.value.equals(Maybe.none())) {
      return "?";
    } else {
      return String.valueOf(this.get());
    }
  }

  /**
   * Transforms the lazy value into a new lazy value using the given transformer.
   *
   * @param <S> the type of the return lazy value
   * @param t the given transformer
   * @return the new lazy value
   */
  public <S> Lazy<S> map(Transformer<? super T, ? extends S> t) {
    return Lazy.of(() -> t.transform(this.get()));
  }

  /**
   * Similar to map but flatten the transformed value by removing extra layer of lazy.
   * Eg. if return type of transform is Lazy.of(5), instead of wrapping it again and
   * returning Lazy.of(Lazy.of(5)), it just returns Lazy.of(5).
   *
   * @param <S> the type of the return lazy value 
   * @param t the given transformer that returns a lazy
   * @return the new lazy value
   */
  public <S> Lazy<S> flatMap(Transformer<? super T, ? extends Lazy<? extends S>> t) {
    // Producer<Lazy<? extends S>> prod = () -> t.transform(this.get());
    Producer<S> newProd = () -> (t.transform(this.get())).get();
    return Lazy.of(newProd);
  }

  /**
   * Filters the lazy value using the given boolean condition. It does not remove the 
   * value but rather creates a boolean version of the Lazy value. If condition is
   * satisfied, a lazy true is created. A lazy false is created otherwise.
   *
   * @param bool the given boolean condition
   * @return the boolean wrapped in a lazy value
   */
  public Lazy<Boolean> filter(BooleanCondition<? super T> bool) {
    return Lazy.of(() -> bool.test(this.get()));
  }

  /**
   * Checks if the given object is equal to this lazy value. 
   *
   * @param obj the given object
   * @return true if the object is Lazy and its value is equal to this lazy value's value
   */
  @Override
  public boolean equals(Object obj) { 
    if (obj instanceof Lazy<?>) {
      // Safe as obj being an instance of Lazy<?> is a precondition for evaluation 
      @SuppressWarnings("unchecked")
      Lazy<?> temp = (Lazy<?>) obj;
      return this.get().equals(temp.get());
    } else {
      return false;
    }
  }

  /**
   * Combines this lazy value with another lazy value using the given combiner. Given two
   * lazy values of two different types (one of current type, the other of another type),
   * it then takes in a combiner that combines these two lazy values and return a new type.
   *
   * @param <S> the type of other lazy value
   * @param <R> the type of the return lazy value after combining
   * @param s the other lazy value
   * @param comb the given combiner
   * @return the combined lazy value
   */
  public <S, R> Lazy<R> combine(Lazy<S> s, Combiner<? super T, ? super S, ? extends R> comb) {
    R temp = comb.combine(this.get(), s.get());
    return Lazy.of(() -> temp);
  }
}
