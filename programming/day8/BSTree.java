/**
 * Interface for a dictionary data structure
 * Insert and fetch from class
 * Other methods I referenced the text book
 */
public class BSTree<K extends Comparable<K>,V> implements IDict<K,V>  {
  //Fields
  private Node<K,V> root;
  private Node<K,V> curr;
  private int size;
  private K[] keyArray;
  //Constructor
  public BSTree(){
    root = null;
    curr = null;
    size = 0;
  }

  /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
  public V add(K k, V v) {
        curr = root;
        if(size == 0) {
            root = new Node<K, V>(k, v);
            size++;
            return null;
        }
        helper(k, v);
    }

    public void helper(K k, V v) {
        if((k.compateTo(curr.getKey()) == 0))){
          V retValue = curr.getValue();
          curr.setValue(v);
          return retValue;
        }

        if((k.compareTo(curr.getKey() < 0 && curr.getLeft() == null || k.compareTo(curr.getKey())>0 curr.getRight() == null || curr.isLeft()))) {
          if(k.compareTo(curr.getKey())<0){
            curr.setLeft(new Node<K, V>(k,v));
            size++;
          }
          else{
            curr.setRight(new Node<K,V>(k,v));
            size++;
          }
          return null;
        }

      if(k.compareTo(curr.getKey())<0){
        curr = curr.getLeft();
      }
      else{
        curr = curr.getRight();
      }
      return helper(k, v);
    }

  /**
   * Removes a value and key from the dictionary. An unmatched key should return null.
   * @param k key to remove
   * @return the value of the removed key
   */
  public V remove(K k){
    V retVal = finder(root, k);
    if( retVal != null){
      root = removehelp(root, k);
      size--;
    }
    return retVal;
  }

  /** Remove a node with key value k
    @return The tree with the node removed */
  private BSTNode<Key,E> removehelp(BSTNode<Key,E> root,Key k) {
    if (root == null) return null;

    if (root.key().compareTo(k) > 0)
      root.setLeft(removehelp(root.getLeft(), k));

    else if (root.key().compareTo(k) < 0)
      root.setRight(removehelp(root.right(), k));

    else { // Found it
    if (root.getLeft() == null) return root.right();

    else if (root.right() == null) return root.getLeft();

    else { // Two children
    BSTNode<Key,E> temp = getmin(root.right());
    root.setElement(temp.element());
    root.setKey(temp.key());
    root.setRight(deletemin(root.right()));
    }
  }
  return root;
  }

  private V finder(Node<K,V> root, K k) {
    if (root == null) {
      return null;
    }
    if (root.getKey().compareTo(k) > 0){
      return findhelp(root.getLeft(), k);
    }
    else if (root.getKey().compareTo(k) == 0) {
      return root.getValue();
    }
    else {
      return finder(root.getRight(), k);
    }
  }



  /**
   * Returns the size of the dictionary
   * @return the number of values stored in the dictionary
   */
  public int size(){
    return size;
  }

  /**
   * Returns the value associated with a parooticular key in the dictionary.
   * Returns null if there is no matching key.
   * @param k key to retrieve the value for
   * @return the value
   */
  public V fetch(K k){
        curr = root;
        while(curr.getKey().compateTo(k) != 0) {
            if(k.compareTo(curr.getKey()) > 0) {
              if(curr.isLeaf() == true){break;}
              curr = curr.getRight();
            } else {
                if(curr.isLeaf() == true){break;}
                curr = curr.getLeft();
            }
        }
        curr = curr.getLeft();
        // We have found the key or ran out of children
    }

  /**
   * Returns an array of the keys in the dictionary
   * @return array of all keys
   */
   public K[] keys(){
     keyArray = (K[]) new Comparable[size];
     keyhelp(keyArray,root,0);
     return keyArray;
   }

   //lil traversal key array placer
   private void keyhelp(K[] keyArray, BSTNode<Key,E> root, int i) {
    if (root == null) return;
    keyhelp(keyArray, root.getLeft(), i);
    keyArray[i] = root.getKey();
    i++;
    keyhelp(keyArray, root.getRight(), i);
    }
}
