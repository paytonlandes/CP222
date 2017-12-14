/**
 * Class to represent a Node in a graph
 * From Class
 */
public class Node<T> implements INode<T>{
    // Fields
    T value;

    // Edge list?

    public Node(T v) {
        setValue(v);
    }

    /**
     * Sets the value
     * @param v the value
     */
    public void setValue(T v) {
        value = v;
    }

    /**
     * Retrieve the nodes value
     * @return the value
     */
    public T getValue() {
        return value;
    }
}
