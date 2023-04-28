/**
 * CS2030S Lab 5
 * AY22/23 Semester 2
 *
 * @author Justin Cheah Yun Fei
 */

package cs2030s.fp;

public abstract class Maybe<T> {
  private static final None noneInstance = new None();

  private static class None extends Maybe<Object> {
    @Override 
    public String toString() {
      return "[]";
    }

    @Override
    protected Object get() {
      throw new java.util.NoSuchElementException();
    }

    @Override
    public boolean equals(Object obj) {
      return (obj instanceof None);
    }

    @Override
    public Maybe<Object> filter(BooleanCondition<? super Object> cond) {
      return none();
    }

    @Override 
    public <U> Maybe<U> map(Transformer<? super Object, ? extends U> trans) {
      return none();
    }

    @Override
    public <U> Maybe<U> flatMap(Transformer<? super Object, ? extends Maybe<? extends U>> trans) {
      return none();
    }

    @Override 
    public <U extends Object> Object orElse(U val) {
      return val;
    }

    @Override
    public <U extends Object> Object orElseGet(Producer<U> prod) {
      return prod.produce();
    }

    @Override
    public void ifPresent(Consumer<? super Object> cons) {
      /* Do nothing
       */
    }
  }

  private static final class Some<T> extends Maybe<T> {
    private T item;

    public Some(T item) {
      this.item = item;
    }
    
    @Override 
    public String toString() {
      String str = String.format("[%s]", this.item);
      return str;
    }
    
    @Override
    protected T get() {
      return this.item;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Some<?>) {
        /* since obj being an instance of Some<?> is a precondition for
         * this block to be executed, this type cast is safe
         * Oh wait I don't need to type cast this
         */
        Some<?> curObj = (Some<?>) obj;
        if (item == null) {
          return curObj.get() == null;
        } else {
          return item.equals(curObj.get());
        }
      }
      return false;
    }

    @Override
    public Maybe<T> filter(BooleanCondition<? super T> cond) {
      if (this.item != null && !cond.test(this.item)) {
        return Maybe.of(null);
      } else {
        return this;
      }
    }

    @Override
    public <U> Maybe<U> map(Transformer<? super T, ? extends U> trans) {
      Maybe<U> newSome = Maybe.some(trans.transform(item));
      return newSome;
    }

    @Override
    public <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> trans) {
      /* Since the parameter only accepts Maybe<? extends U>, the type of Maybe being a
       * subtype of U is a precondition for this block to be executed
       * Thus it is safe to cast to Maybe<U>
       */
      @SuppressWarnings("unchecked")
      Maybe<U> temp = (Maybe<U>) trans.transform(this.get());
      return temp;
    }

    @Override
    public <U extends T> T orElse(U val) {
      return item;
    }

    @Override
    public <U extends T> T orElseGet(Producer<U> prod) {
      return item;
    }

    @Override 
    public void ifPresent(Consumer<? super T> cons) {
      cons.consume(item);
    }
  }

  public static <T> Maybe<T> of(T item) {
    if (item == null) {
      return none();
    } else {
      return some(item);
    }
  }

  public static <T> Maybe<T> none() {
    /* Since the type of None is arbitrary and is never used for any runtime purposes
     * this type casting is safe
     */
    @SuppressWarnings("unchecked") 
    Maybe<T> temp = (Maybe<T>) noneInstance;
    return temp;
  }

  public static <T> Maybe<T> some(T obj) {
    return new Some<T>(obj);
  }

  protected abstract T get();
  
  public abstract Maybe<T> filter(BooleanCondition<? super T> cond);

  public abstract <U> Maybe<U> map(Transformer<? super T, ? extends U> trans);

  public abstract <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> trans);

  public abstract <U extends T> T orElse(U val);

  public abstract <U extends T> T orElseGet(Producer<U> prod); 

  public abstract void ifPresent(Consumer<? super T> cons);
}
