/*
Payton Landes
CP222
DoubleLink List Implementation
*/

public class DoubleLinkList<T> {
  //Fields
  DLink<T> head;
  DLink<T> tail;
  DLink<T> curr;

  public DoubleLinkList(){
    head = null;
    curr = null;
    tail = null;
  }
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
      if (idx==0){
        DLink<T> q = new DLink<T>(v, null, null);
        head.setPrev(q);
        q.setNext(head);
        q.setPrev(null);
        head = q;
      }
      else if (idx>0){
      curr = head;
      for (int i=0; i<idx; i++){
        curr = (DLink<T>) curr.getNext();
      }
      DLink<T> q = new DLink<T>(v, null, null);
      DLink<T> p = (DLink<T>) curr.getPrev();
      q.setPrev(p);
      q.setNext(curr);
      curr.setPrev(q);
      p.setNext(q);
      }
      tail = (DLink<T>) tail.getNext();
      }

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
public void append(T v){
  if (curr ==null) {
  DLink<T> first = new DLink<T>(v, null, null);
  head = first;
  curr = first;
  tail = first;
  }
  else {
    DLink<T> q = new DLink(v, null, null);
    tail.setNext(q);
    q.setPrev(tail);
    tail = q;
    curr = q;
  }
}



/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove(){
  if (curr.getValue()==null){
  }
  else {
    curr = (DLink<T>) curr.getPrev();
    curr.setNext(null);
    curr.setPrev(curr.getPrev());
    tail = curr;
  }
}

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
public void remove(int idx){
  if (idx == 0){
    head = (DLink<T>) head.getNext();
  }
  else {
  DLink<T> q = head;
  curr = q;
  for (int i=0; i<idx-1; i++){
    q = (DLink<T>) q.getNext();
    curr = q;
  }
  DLink<T> p = (DLink<T>) curr.getNext();
  curr.setNext(p.getNext());
  curr.setPrev(curr.getPrev());
  }

}

/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
public void move(int sidx, int didx){
  if(sidx==0){
    DLink<T> save = head;
    DLink<T> afterSave = (DLink<T>) save.getNext();
    afterSave.setPrev(null);
    head = afterSave;
    curr = head;
    for (int i=sidx+1; i<didx-1; i++){
      curr = (DLink<T>) curr.getNext();
    }
    DLink<T> dindx = (DLink<T>) curr.getNext();
    save.setPrev(dindx);
    save.setNext(dindx.getNext());
    dindx.setNext(save);
    dindx.setPrev(curr);
  }
  else if (sidx<didx){
  DLink<T> q = head;
  curr = q;
  for (int i=0; i<sidx-1; i++){
    q = (DLink<T>) q.getNext();
    curr = q;
  }
  DLink<T> save = (DLink<T>) curr.getNext();
  DLink<T> afterSave = (DLink<T>) save.getNext();
  curr.setNext(afterSave);
  curr.setPrev(curr.getPrev());
  afterSave.setPrev(curr);
  for (int i=sidx; i<didx-1; i++){
    curr = (DLink<T>) curr.getNext();
  }
  DLink<T> dindx = (DLink<T>) curr.getNext();
  save.setNext(dindx.getNext());
  save.setPrev(dindx);
  dindx.setNext(save);
  dindx.setPrev(curr);
}
  else{
    DLink<T> p = head;
    curr = p;
    for (int i=0; i<sidx-1; i++){
      p = (DLink<T>) p.getNext();
      curr = p;
    }
    DLink<T> save = (DLink<T>) curr.getNext();
    DLink<T> afterSave = (DLink<T>) save.getNext();
    curr.setNext(afterSave);
    afterSave.setPrev(curr);

    DLink<T> r = head;
    curr = r;
    for (int i=0; i<didx-1; i++){
        r = (DLink<T>) r.getNext();
        curr = r;
    }
    save.setNext(curr.getNext());
    save.setPrev(curr);
    curr.setNext(save);
  }
}

/**
 * Fetches the value at the <i>current</i> index in the list.
 * @return the requested item
 */
public T fetch(){
  T v = curr.getValue();
  return v;
}

/**
 * Fetches the value at a specific index in the list.
 * @param idx index of the item to return
 * @return the requested item
 */
public T fetch(int idx){DLink<T> a = head;
  for (int i=0; i<idx; i++){
    DLink<T> b = (DLink<T>) a.getNext();
    a = b;
  }
  T v = a.getValue();
  return v;
}

/**
 * Advances the <i>current</i> index to the next index, if possible.
 */
public void next(){
  curr = (DLink<T>) curr.getNext();
}

/**
 * Advances the <i>current</i> index to the previous index, if possible.
 */
public void prev(){if (curr.getPrev()==null){
    return;
  }
  curr = (DLink<T>) curr.getPrev();
}

/**
 * Advances the <i>current</i> to the tail element
 */
public void jumpToTail(){
  curr = tail;
}

/**
 * Advances the <i>current</i> to the head element
 */
public void jumpToHead(){
  curr = head;
}

/**
 * Returns the number of elements in the list
 */
public int size(){
  DLink<T> q = head;
  int i = 0;
  while (q.getNext() != tail){
    q = (DLink<T>) q.getNext();
    i++;
  }
  return i+2;
}

//   public static void main(String[] argv) {
//       DoubleLinkList l = new DoubleLinkList();
//       l.append(1);
//       l.append(2);
//       l.append(3);
//       l.append(4);
//       //l.append(5);
//
//       System.out.println(" --fill--- ");
//
//       System.out.println(l.head.getValue());
// }
}
