/**
 * Implements the methods required for the CS2 day0 exercise
 */
public class WarmUp implements IWarmUp {

    /**
     * @return the string Hello World
     */
    public String  getHello() {
      String hello = "hello world";
        return hello;
    }

    /**
     * Uses a loop to pack an array of length 10 with the values 0
     * through 9 in order.
     * @return an array of length 10 containing the ints 0 through 9
     */
    public int[]   get0to9() {
        int[] ret = new int[10];
        for (int h = 0; h < 10; h++){
          ret[h] = h;
        }
        return ret;
    }

    /**
     * @param  n an integer to test for even-ness
     * @return true if n is even, otherwise return false
     */
    public boolean isEven(int n) {
      if (n % 2 == 0){
        return true;
      }
      else{
        return false;
      }
    }

    /**
     * Computes fibonacci numbers.
     * fib(0) = 1
     * fib(1) = 1
     * fib(n) = fib(n-1) + fib(n-2)
     * @param n the fibonacci sequence number to compute
     * @return the fibonacci number at position n in the sequence
     */
    public long fib(long n) {
        if(n == 0){
          return 1;
        }
        if(n == 1){
          return 1;
        }
        else{
          return fib(n-1) + fib(n-2);
        }
      }

}
