
public class Sorting {

    /*
    BUBBLE SORT

    A basic sorting algorigthm, good to learn how sorting works
     */

    public static void bubbleSort(Integer[] a){
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.length -1; i++){
                if (a[i] > a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void bubbleSort(String[] a){
        boolean sorted = false;
        String temp;
        while(!sorted){
            sorted = true;
            for(int i = 0; i < a.length - 1; i++){
                if (a[i].compareTo(a[i+1]) > 0){
                    temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    sorted  = false;
                }
            }
        }
    }

    public <T extends Comparable<T>> void bubbleSortGeneric(T[] values){
        boolean sorted = false;
        T temp;
        while(!sorted){
            sorted = true;
            for(int i = 0; i < values.length - 1; i++){
                if (values[i].compareTo(values[i+1]) > 0){
                    temp = values[i+1];
                    values[i+1] = values[i];
                    values[i] = temp;
                    sorted  = false;
                }
            }
        }
    }

    /*
    INSERTION SORT
    Insertion sort is a simple sorting algorithm that builds the
    final sorted array one item at a time. It is much less efficient
    on large lists than more advanced algorithms such as quicksort,
    heapsort, or merge sort.

    worst complexity = n^2
    average complexity = n^2
    best complexity = n
     */

    public void insertionSort(Integer[] values){
        for (int i = 1; i < values.length; i++){
            int current = values[i];                // current represents the value that is moving
            int j =i-1;                             // j represents the index of the next value to compare current against
            while(j >= 0 && current < values[j]){   // this loop keep going until either current is less than the value at j, or it reaches the start of the array
                values[j+1]= values[j];
                j--;
            }
            values[j+1] = current;                  // this line inserts current into the now empty index of the array
        }
    }

    public void insertionSort(String[] values){
        for (int i = 1; i < values.length; i++){
            String current = values[i];                           // current represents the value that is moving
            int j =i-1;                                           // j represents the index of the next value to compare current against
            while(j >= 0 && current.compareTo(values[j]) < 0) {   // this loop keep going until either current is less than the value at j, or it reaches the start of the array
                values[j+1]= values[j];
                j--;
            }
            values[j+1] = current;                                // this line inserts current into the now empty index of the array
        }
    }

    public <T extends Comparable<T>> void insertionSortGeneric(T[] values){
        for (int i = 1; i < values.length; i++){
            T current = values[i];                           // current represents the value that is moving
            int j =i-1;                                           // j represents the index of the next value to compare current against
            while(j >= 0 && current.compareTo(values[j]) < 0) {   // this loop keep going until either current is less than the value at j, or it reaches the start of the array
                values[j+1]= values[j];
                j--;
            }
            values[j+1] = current;                                // this line inserts current into the now empty index of the array
        }
    }

    /*
    QUICK SORT

    [description]
    generally preferred over Merge Sort for arrays.
    Quick sort has the potential to be faster than Merge Sort or Heap Sort, because its inner loop can be efficiently implemented on most architectures, and in most real-world data, by changing the choice of pivot.

    worst complexity = n^2
    average complexity = N log N
    best complexity = n
     */

    public <T extends Comparable<T>> void quickSort(T[] values){
        // do stuff
    }

    /*
    MERGE SORT

    [description]
    generally considered better when data is huge and stored in external storage
    generally preferred over Quick Sort for Linked Lists
        - Quick Sort uses a lot of random access using indexes, which must be done iteratively with a Linked List
        - Merge Sort accesses data sequentially anyway, and as such is well suited to working with Linked Lists

    worst complexity =
    average complexity =
    best complexity =
     */

    public <T extends Comparable<T>> void mergeSort(T[] values){
        // do stuff
    }

     /*
    HEAP SORT

    [description]

    worst complexity =
    average complexity =
    best complexity =
     */

    public <T extends Comparable<T>> void heapSort(T[] values){
        // do stuff
    }

}
