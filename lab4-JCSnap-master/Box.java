/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
public class Box<T> {
  private final T content;
  private static final Box<?> EMPTY_BOX;

  static {
    EMPTY_BOX = new Box<>(null);
  }

  private Box(T content) {
    this.content = content;
  }

  public T getContent() {
    return this.content;
  }

  public static <T> Box<T> of(T content) {
    if (content == null) {
      return null;
    } else {
      return new Box<T>(content);
    }
  }

  public static <T> Box<T> ofNullable(T content) {
    if (content == null) {
      return empty();
    } else {
      return new Box<T>(content);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Box)) {
        return false;
    }
    Box<?> other = (Box<?>) obj;
    return (content == null && other.content == null ||
        content != null && content.equals(other.content));
  }

  @Override
  public String toString() {
    return this.content == null
      ? "[" + "]"
      :"[" + this.content + "]";
  }

  public static <T> Box<T> empty() {
    // this is safe to typecast since EMPTY_BOX has type <?> 
    @SuppressWarnings("unchecked")
    Box<T> emptyBox = (Box<T>) EMPTY_BOX;
    return emptyBox;
  }

  public boolean isPresent() {
    return this.content != null;
  }

  public Box<T> filter(BooleanCondition<? super T> cond) {
    if (!this.isPresent() || !cond.test(this.content)) {
      return empty();
    } else {
      return this;
    }
  }

  public <U> Box<U> map(Transformer<? super T,? extends U> t) {
    if (!this.isPresent()) {
      // empty box is of type <?>
      @SuppressWarnings("unchecked")
      Box<U> temp = (Box<U>) EMPTY_BOX;
      return temp;
    } else {
      U transformedObj = t.transform(this.content);
      return new Box<U>(transformedObj);
    } 
  }
}
