/**
 * Interface for the methods required for the CS2 day0 exercise
 */
public interface IWarmUp {

    /**
     * @return the string Hello World
     */
    public String  getHello();

    /**
     * Uses a loop to pack an array of length 10 with the values 0
     * through 9 in order.
     * @return an array of length 10 containing the ints 0 through 9
     */
    public int[]   get0to9();

    /**
     * @param  n an integer to test for even-ness
     * @return true if n is even, otherwise return false
     */
    public boolean isEven(int n);

    /**
     * Computes fibonacci numbers.
     * fib(0) = 1
     * fib(1) = 1
     * fib(n) = fib(n-1) + fib(n-2)
     * @param n the fibonacci sequence number to compute
     * @return the fibonacci number at position n in the sequence
     */
    public long    fib(long n);
}
