/**
 * MergeSorter Class implementation of ISort
 */

public class MergeSort<T extends Comparable<T>> implements ISort<T> {
  private T[] array;
  private T[] tempArray;
  private int size;

  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public void sort(T[] in){
    array = in;
    size = in.length;
    tempArray = (T[]) new Comparable[size];
    if(size <= 1){ return; }
    sortHelper(0,size-1);
  }

  private void sortHelper(int low, int high){
    if (low < high){
      int mid = low + (high - low) / 2;
      sortHelper(low, mid);
      sortHelper(mid+1, high);
      merger(low, mid, high);
    }
  }

  private void merger(int low, int mid, int high){
    for(int i = low; i<= high; i++){
      tempArray[i] = array[i];
    }
    int l = low;
    int n = low;
    int m = mid+1;
    while (l <= mid && m <= high){
      //if (temp low <= temp mid)
      if (tempArray[l].compareTo(tempArray[m]) <= 0){
          array[n] = tempArray[l];
          l++;
      }
      else{
          array[n] = tempArray[m];
          m++;
      }
      n++;
    }
    while (l <= mid){
        array[n] = tempArray[l];
        n++;
        l++;
    }
  }
  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    return "MergeSort";
  }

  public static void main(String a[]){

          Integer[] inputArr = {0,45,23,11,-12,89,77,98,4,28,65,43};
          MergeSort<Integer> mms = new MergeSort<Integer>();
          mms.sort(inputArr);
          for(int i:inputArr){
              System.out.print(i);
              System.out.print(" ");
          }
      }

}

// Books Psuedocode
// List mergesort(List inlist) {
//   if (inlist.size() <= 1) return inlist;;
//   List L1 = half of the items from inlist;
//   List L2 = other half of the items from inlist;
//   return merge(mergesort(L1), mergesort(L2));
// }
//
//More
// static <E extends Comparable<? super E>>
// void mergesort(E[] A, E[] temp, int l, int r) {
// int i, j, k, mid = (l+r)/2; // Select the midpoint
// if (l == r) return; // List has one element
// if ((mid-l) >= THRESHOLD) mergesort(A, temp, l, mid);
// else inssort(A, l, mid-l+1);
// if ((r-mid) > THRESHOLD) mergesort(A, temp, mid+1, r);
// else inssort(A, mid+1, r-mid);
// // Do the merge operation. First, copy 2 halves to temp.
// for (i=l; i<=mid; i++) temp[i] = A[i];
// for (j=1; j<=r-mid; j++) temp[r-j+1] = A[j+mid];
// // Merge sublists back to array
// for (i=l,j=r,k=l; k<=r; k++)
//   if (temp[i].compareTo(temp[j])<0) A[k] = temp[i++];
//   else A[k] = temp[j--];
// }
