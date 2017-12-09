/** Container class for a key-value pair
* from textbook pg 135
*/
public class KVpair<K, V> {
private K k;
private V v;
/** Constructors */
public KVpair()
{ k = null; v = null; }
public KVpair(K kval, V eval)
{ k = kval; v = eval; }
/** Data member access functions */
public K key() { return k; }
public V value() { return v; }
}
