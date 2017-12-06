/*
Payton Landes
Nov. 28 2017
CP222
Array-Based List Implementation
*/

public class ArrayList<T> implements IList<T>{
  //Fields
  //backing array
  private T[] bArray;
  //max size of bArray
  private int mSize;
  //current size of bArray
  private int lSize;
  //current index
  private int current;

  //Constructor
  @SuppressWarnings("unchecked")
  public ArrayList(int size){
    //plus 1 so it always ends with void
    //no special case for removing from end
    bArray = (T[])new Object[size + 1];
    mSize = size;
    lSize = 0;
    current = 0;
  }

  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */
  public void insert(int idx, T v){
    assert lSize < mSize : "Maxed out yo";
      for (int i = lSize; i > idx; i--){
        bArray[i] = bArray[i-1];
      }
      bArray[idx] = v;
      lSize++;
  }

	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v){
    assert lSize < mSize : "Maxed out yo";
    //bArray[lSize++] = v;
    bArray[lSize++] = v;
    current = lSize - 1;
  }

	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
	 * the previous item in the list, if such element exists.
	 */
	public void remove(){
    for(int i=current; i<lSize; i++){ // Shift them down
    bArray[i] = bArray[i+1];
    }
    prev();
    lSize--; // Decrement size
  }

	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx){
    for(int i=idx; i<lSize-1; i++){ // Shift them down
      bArray[i] = bArray[i+1];
    }
    lSize--;
    //Decrement size
    if ((idx < 0) || (idx >= lSize)){ // Nothing there
      return;
    }
    for(int i = idx; i < lSize-1; i++){ // Shift down
      bArray[i] = bArray[i+1];
      lSize--;
    }
  }

	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx){
    T store;
    store = bArray[sidx];
    remove(sidx);
    insert(didx, store);
  }

	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch(){
    return bArray[current];
  }

	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx){
    return bArray[idx];
  }


	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next(){
    if (current < lSize-1){
      current++;
    }
  }

	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev(){
    if (current != 0){ // Limit
      current--;
    }
  }

	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail(){
    current = lSize - 1;
  }

	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead(){
    current = 0;
  }

	/**
	 * Returns the number of elements in the list
	 */
	public int size(){
    return lSize;
  }

  // @SuppressWarnings("unchecked")
  // public static void main(String[] argv) {
  //     ArrayList l = new ArrayList(5);
  //     l.append(1);
  //     l.append(2);
  //     l.append(3);
  //     l.append(4);
  //     //l.append(5);
  //
  //     System.out.println(" --fill--- ");
  //
  //     System.out.println(l.bArray[0]);
  //     System.out.println(l.bArray[1]);
  //     System.out.println(l.bArray[2]);
  //     System.out.println(l.bArray[3]);
  //     System.out.println(l.bArray[4]);
  //     System.out.println(" --size 4--- ");
  //
  //     System.out.println(l.lSize);
  //
  //     System.out.println(" ---remove size 2-- ");
  //
  //     l.remove(0);
  //     l.remove(0);
  //
  //     System.out.println(l.lSize);
  //
  //     System.out.println(" --3 4 --- ");
  //
  //     System.out.println(l.bArray[0]);
  //     System.out.println(l.bArray[1]);
  //     System.out.println(l.bArray[2]);
  //     System.out.println(l.bArray[3]);
  //     System.out.println(l.bArray[4]);
  //
  //     l.insert(0,10);
  //     l.insert(0,13);
  //
  //     System.out.println(" --13 10 3 4 --- ");
  //
  //     System.out.println(l.bArray[0]);
  //     System.out.println(l.bArray[1]);
  //     System.out.println(l.bArray[2]);
  //     System.out.println(l.bArray[3]);
  //     System.out.println(l.bArray[4]);
  //
  //
  // }
}
