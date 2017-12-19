/*
Payton Landes
CP222
DoubleLink Node Implementation
*/

public class DLink<T> implements IDLink<T> {
  //Fields
  private T value;
  private DLink<T> prev;
  private DLink<T> next;

  //Constructor
  public DLink(T v, DLink<T> p, DLink<T> n){
    value = v;
    p = prev;
    n = next;
  }

    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){
      return value;
    }

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){
      value = v;
    }

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink<T> getNext(){
      return next;
    }

    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink<T> getPrev(){
      return prev;
    }

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink<T> c){
      next = (DLink<T>) c;
    }

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink<T> c){
      prev = (DLink<T>) c;
    }
  }
