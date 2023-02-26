/**
 * The Array<T> for CS2030S 
 *
 * @author Justin Cheah Yun Fei
 * @version CS2030S AY22/23 Semester 2
 */
class Array<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] array;

  Array(int size) {
    // the only way to put objects into the array is through the method
    // set, which already ensures that object put in is of type T
    // there is no getters here that allows users to modify the array to
    // include any objects other than T
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] temp = (T[]) new Comparable[size];
    this.array = temp;
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int index) {
    return this.array[index];
  }

  public T min() {
    int min = 0;
    for (int i = 0; i < this.array.length; i++) {
      if (this.array[i].compareTo(this.array[min]) < 0) {
        min = i;
      }
    }
    return this.array[min];
  }

  public int getSize() {
    return array.length;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
