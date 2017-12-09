/**
* DoubleLinkList backed implementation of a dictionary data structure
*/
public class Dict<K extends Comparable<K>,V> implements IDict<K,V>  {

//public class Dict<K extends Comparable<K>,V> {
  //Fields
  //List to store KV pairs
  private DoubleLinkList<KVpair<K,V>> list;
  private int size;
  K[] keyArray;

  public Dict(){
    list = new DoubleLinkList();
    size = 0;
  }

  /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
  public V add(K k, V v){
    //empty list case
    if (size == 0){
    KVpair toAdd = new KVpair(k,v);
    list.append(toAdd);
    size++;
    return null;
    }

    //check if key is already being used
    list.jumpToHead();
    boolean found = false;
    for(int i = 0; i < size; i++){
      if(list.fetch().key() == k){
        found = true;
        break;
      }
      list.next();
    }
    //key used, return old value and replace with new
    if(found == true){
      V retVal;
      retVal = list.fetch().value();
      KVpair toAdd = new KVpair(k,v);
      list.curr.setValue(toAdd);
      return retVal;
    }
    //key not used, append KVpair
    if(found == false){
    KVpair toAdd = new KVpair(k,v);
    list.append(toAdd);
    size++;
    return null;
    }
    return null;
  }


  /**
   * Removes a value and key from the dictionary. An unmatched key should return null.
   * @param k key to remove
   * @return the value of the removed key
   */
  public V remove(K k){
    //empty list case
    if (size == 0){return null;}
    //search for key
    list.jumpToHead();
    boolean found = false;
    for(int i = 0; i < size; i++){
      if(list.fetch().key() == k){
        found = true;
        break;
      }
      list.next();
    }
    //key used, delete the link holding it
    if(found == true){
      V retVal;
      retVal = list.fetch().value();
      list.remove();
      size--;
      return retVal;
    }
    //key not used, return null
    if(found == false){ return null; }
    return null;
  }

  /**
   * Returns the size of the dictionary
   * @return the number of values stored in the dictionary
   */
  public int size(){
    return size;
  }



  /**
   * Returns the value associated with a particular key in the dictionary.
   * Returns null if there is no matching key.
   * @param k key to retrieve the value for
   * @return the value
   */
  public V fetch(K k){
    if(size==0){ return null; }
    list.jumpToHead();
    while (list.fetch().key() != k){
      list.next();
      if(list.fetch() == list.tail){ break; }
    }
    if(list.fetch().key() == k){
      return list.fetch().value();
    }
    else{return null;}
  }

  /**
   * Returns an array of the keys in the dictionary
   * @return array of all keys
   */
  public K[] keys(){
    keyArray = (K[]) new Comparable[size];
    list.jumpToHead();
    for(int i = 0; i < size; i++){
      keyArray[i] = list.fetch().key();
      list.next();
    }
    return keyArray;
  }

  public static void main(String[] args) {
    Dict test = new Dict();
    test.add("abcd", 1234);
    test.add("dog",21);
    test.add("abcd",42);
    test.add("pton",42);
    test.add("ldes",42);
    test.remove("dog");
    System.out.println(test.size());
    System.out.println(test.fetch("abcd"));
    for(int i = 0; i<test.size(); i++){
      System.out.println(test.keys()[i]);
    }
}
}
