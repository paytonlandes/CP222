//Code from class
/**
 * Implementation of Stack using Links
 */
public class Stack<T> implements IStack<T> {
    Cell<T> top;
    int size; // is the current size of the stack

    /**
     * Makes a new LinkStack instance
     */
    public LinkStack() {
        size = 0;
        top  = null;
    }

    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) throws OverFlowException {
        Cell<T> n = new Cell<T>(v, top);
        top = n;
        size++;
    }

    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() throws UnderFlowException {
        if(size==0) { throw new UnderFlowException(); }
        T v = top.getValue();
        top = top.getPtr();
        size--;
        return v;
    }

    /**
     * Checks the emptiness of the stack
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        if(size==0) {
            return true;
        }
        return false;
    }

     class Cell<T> {
    T value;
    Cell<T> ptr;

    /**
     * Constructor to make a new cell with a know value and next pointer
     * @param v the Value to store in the cell
     * @param p the next cell in the stack
     */
    public Cell(T v, Cell<T> p) {
        value = v;
        ptr = p;
    }

    /**
     * Sets the value of the cell
     * @param v the value to set the cell to
     */
    public void setValue(T v) {
        value = v;
    }
    /** Gets the value of the cell
     * @return the value currently in the cell
     */
    public T getValue() {
        return value;
    }
    /**
     * Sets the next cell in the stack
     * @param p the next cell
     */
    public void setPtr(Cell<T> p) {
        ptr = p;
    }

    /**
     * Gets the next cell in the stack
     * @return next cell
     */
    public Cell<T> getPtr() {
        return ptr;
    }
}

}
