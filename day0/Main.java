/**
 * Class to hold the main method for program execution
 */
public class Main {
    /**
     * Makes a WarmUp instance and exercises several methods
     * @param argv commandline arguments (ignored)
     */
    public static void main(String[] argv) {
        IWarmUp w = new WarmUp();

        // Test Hello
        System.out.println(w.getHello());

        // Test get0to9
        for(int i:w.get0to9()) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
        
        // Test isEven
        System.out.println("1 (F)  -> " + w.isEven(1));
        System.out.println("4 (T) -> " + w.isEven(4));

        // Test fib
        System.out.println("fib(1) -> " + w.fib(1));
        System.out.println("fib(4) -> " + w.fib(4));
    }
}
