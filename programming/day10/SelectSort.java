/**
 * SelectSorter Class implementation of ISort
 */

public class SelectSort<T extends Comparable<T>> implements ISort<T> {

  /**
   * Sorts an array of items in place
   * @param in An array to sort
   * Pretty much the textbook implementation here
   */
  public  void sort(T[] in){
    for (int i=0; i<in.length-1; i++) { // Select i’th record
      int low = i; // Remember its index
      for (int j=in.length-1; j>i; j--){ // Find the least value
        if (in[j].compareTo(in[low]) < 0){
          low = j; // Put it in place
        }
      }
      swap(in, i, low);
    }
  }

  private void swap(T[] array, int idx, int low){
    T store = array[idx];
    array[idx] = array[low];
    array[low] = store;
  }

  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    return "SelectSort";
  }

  public static void main(String a[]){

          Integer[] inputArr = {0,45,23,-5,11,89,77,98,4,28,65,43};
          SelectSort<Integer> ss = new SelectSort<Integer>();
          ss.sort(inputArr);
          for(int i:inputArr){
              System.out.print(i);
              System.out.print(" ");
          }
      }
}
