/*
Payton Landes
Nov. 28 2017
CP222
SingleLink Node Implementation
*/


public class SLink<T> implements ISLink<T> {
  //Fields
  private T value;
  private SLink<T> next;

  //Constructor
  public SLink(T value, SLink<T> next){
    this.value = value;
    this.next = next;
  }
  // public SLink(SLink<T> next){
  //   this.next = next;
  // }

  /**
   * Gets the current value for this link cell
   * @return the value
   */
  public T getValue(){
    return this.value;
  }

  /**
   * Sets the current value for this link cell
   * @param v the value to place in this cell
   */
  public void setValue(T v){
    this.value = v;
  }

  /**
   * Gets the next cell in the list
   * @return the cell
   */
  public ISLink<T> getNext(){
    return this.next;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setNext(ISLink<T> c){
    this.next = (SLink<T>)c;
  }

}
