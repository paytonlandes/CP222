/*
Payton Landes
Nov. 28 2017
CP222
SingleLink List Implementation
*/

public class SingleLinkList<T> implements IList<T> {
  //Fields
  SLink<T> head;
  SLink<T> tail;
  SLink<T> curr;
  int size;

  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */

public void insert(int idx, T v){
  SLink<T> q = head;
  SLink<T> ins = new SLink(v,null);
  for (int i = 1; i < size; i++){
    if(i==idx){
      SLink<T> tmp = (SLink<T>) q.getNext();
      q.setNext(ins);
      ins.setNext(tmp);
      break;
    }
    q = (SLink<T>) q.getNext();
  }
  size++;
}

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
public void append(T v){
  SLink<T> q = new SLink(v, null);

  if (size==0){
    head = q;
    curr = q;
    tail = q;
  }
  else {
    tail.setNext(q);
    curr = q;
    tail = q;
  }
  size++;
}

/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove(){
  if (curr ==null){
    return;
  }

  if (curr.getValue()==head){
    head = (SLink<T>) head.getNext();
    curr = head;
  }

  if (curr.getValue()==tail){
    this.prev();
    curr.setNext(null);
  }
  else {
    SLink<T> remove = (SLink<T>) curr.getNext();
    this.prev();
    curr.setNext(remove);
  }
  size--;
  prev();
}

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
// public void remove(int idx){
//   if(size == 0){
//     return;
//   }
//   if (idx > size -1 || idx <0){
//     return;
//   }
//   if(idx == 0){
//     if (curr == head){
//       curr = (SLink<T>) head.getNext();
//     }
//     head = (SLink<T>) head.getNext();
//   }
//   else{
//   SLink<T> q = head;
//
//   //index in
//   for (int i=0; i < idx-1; i++){
//     q = (SLink<T>) q.getNext();
//   }
//
//   if (q.getNext() == tail){
//     if (curr == tail){
//       curr = q;
//     }
//     tail = q;
//     q.setNext(null);
//   }
//
//   else{
//   SLink<T> r = (SLink<T>) q.getNext();
//   q.setNext(r.getNext());
//   }
//   size--;
// }
// }




public void remove(int idx){
  if(size == 0){
    return;
  }
  if (idx > size -1 || idx <0){
    return;
  }
  if(idx == 0){
    if (curr == head){
      curr = (SLink<T>) head.getNext();
    }
    head = (SLink<T>) head.getNext();
  }
  else{

SLink<T> q = head;

for (int i = 1; i < size; i++){
  if(i==idx){
    SLink<T> tmp = (SLink<T>) q.getNext();
    tmp = (SLink<T>) tmp.getNext();
    q.setNext(tmp);
    break;
  }
  q = (SLink<T>) q.getNext();
}
size--;
}
}






/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
public void move(int sidx, int didx){
  if(sidx < 0 || didx < 0 || sidx > size -1 || didx > size){
    return;
  }
  if(sidx == didx){
    return;
  }

  SLink<T> q = head;
  for (int i=0; i<sidx; i++){
    q = (SLink<T>) q.getNext();
  }
  T temp = q.getValue();

  this.remove(sidx);

  if (sidx<didx){
    didx++;
  }
  this.insert(didx, temp);

}

/**
 * Advances the <i>current</i> index to the next index, if possible.
 */
public void next(){
  if (curr != tail){
  curr = (SLink<T>) curr.getNext();
  }
}

/**
 * Advances the <i>current</i> index to the prev index, if possible.
 */
public void prev(){
  if (curr == head){
    return;
  }
  else{
  SLink<T> q = head;
  while ((SLink<T>) q.getNext() != curr) {
    q = (SLink<T>) q.getNext();
  }
  curr = q;
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
public T fetch(int idx){
  SLink<T> a = head;
  for (int i=0; i<idx; i++){
    a = (SLink<T>) a.getNext();
  }
  return a.getValue();
}

/**
 * Advances the <i>current</i> to the head element
 */
public void jumpToHead(){
  curr = head;
}

/**
 * Advances the <i>current</i> to the tail element
 */
public void jumpToTail() {
  curr = tail;
}

/**
 * Returns the number of elements in the list
 */
public int size(){
  return size;
}



public static void main(String[] argv) throws Exception {
  SingleLinkList first = new SingleLinkList();
  first.append(1);
  first.append(2);
  first.append(3);
  first.append(4);
  first.append(5);

  System.out.println(first.fetch(0));
  System.out.println(first.fetch(1));
  System.out.println(first.fetch(2));
  System.out.println(first.fetch(3));
  System.out.println(first.fetch(4));

  System.out.println();

  first.remove(4);

  System.out.println(first.fetch(0));
  System.out.println(first.fetch(1));
  System.out.println(first.fetch(2));
  System.out.println(first.fetch(3));
  //System.out.println(first.fetch(4));

  System.out.println();
  first.insert(3,2);
  //first.move(3,1);

  System.out.println(first.fetch(0));
  System.out.println(first.fetch(1));
  System.out.println(first.fetch(2));
  System.out.println(first.fetch(3));
  System.out.println(first.fetch(4));
}
}
