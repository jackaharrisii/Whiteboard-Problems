
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
    average complexity = O(N log N) (+ O(n) space)
    best complexity =
     */

    public void mergeSort(Integer[] values){
        mergeSort(values, new Integer[values.length], 0, values.length - 1);
    }

    public void mergeSort(Integer[] values, Integer[] temp, Integer leftStart, Integer rightEnd){
        if (leftStart >= rightEnd) return;
        Integer middle = (leftStart + rightEnd) /2;
        mergeSort(values,temp,leftStart,middle);
        mergeSort(values,temp,middle+1,rightEnd);
        mergeHalves(values,temp, leftStart,rightEnd);
    }

    public void mergeHalves(Integer[] values, Integer[] temp, Integer leftStart, Integer rightEnd){
        Integer leftEnd = (rightEnd + leftStart) /2;
        Integer rightStart = leftEnd + 1;
        Integer size = rightEnd - leftStart +1;
        Integer left = leftStart;
        Integer right = rightStart;
        Integer index = leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if (values[left] <= values[right]){
                temp[index] = values[left];
                left++;
            } else {
                temp[index] = values[right];
                right++;
            }
            index++;
        }
        System.arraycopy(values, left, temp, index, leftEnd - left +1);
        System.arraycopy(values, right, temp, index, rightEnd - right +1);
        System.arraycopy(temp, leftStart, values, leftStart, size);
    }

    public void mergeSort(String[] values){
        mergeSort(values, new String[values.length], 0, values.length - 1);

    }

    public void mergeSort(String[] values, String[] temp, Integer leftStart, Integer rightEnd) {
        if (leftStart >= rightEnd) return;
        Integer middle = (leftStart + rightEnd) /2;
        mergeSort(values, temp, leftStart, middle);
        mergeSort(values,temp,middle+1, rightEnd);
        mergeHalves(values,temp, leftStart, rightEnd);
    }

    public void mergeHalves(String[] values, String[] temp, Integer leftStart, Integer rightEnd) {
        Integer leftEnd = (rightEnd + leftStart) /2;
        Integer rightStart = leftEnd + 1;
        Integer size = rightEnd - leftStart +1;
        Integer left = leftStart;
        Integer right = rightStart;
        Integer index = leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if (values[left].compareTo(values[right]) <= 0){
                temp[index] = values[left];
                left++;
            } else {
                temp[index] = values[right];
                right++;
            }
            index++;
        }
        System.arraycopy(values, left, temp, index, leftEnd - left +1);
        System.arraycopy(values, right, temp, index, rightEnd - right +1);
        System.arraycopy(temp, leftStart, values, leftStart, size);
    }

    public <T extends Comparable<T>> void mergeSortGeneric(T[] values){
        T[] temp = (T[])new Object[values.length];
        mergeSortGeneric(values, temp, 0, values.length - 1);

    }

    public <T extends Comparable<T>> void mergeSortGeneric(T[] values, T[] temp, Integer leftStart, Integer rightEnd) {
        if (leftStart >= rightEnd) return;
        Integer middle = (leftStart + rightEnd) /2;
        mergeSortGeneric(values, temp, leftStart, middle);
        mergeSortGeneric(values,temp,middle+1, rightEnd);
        mergeHalvesGeneric(values,temp, leftStart, rightEnd);
    }

    public <T extends Comparable<T>> void mergeHalvesGeneric(T[] values, T[] temp, Integer leftStart, Integer rightEnd) {
        Integer leftEnd = (rightEnd + leftStart) /2;
        Integer rightStart = leftEnd + 1;
        Integer size = rightEnd - leftStart +1;
        Integer left = leftStart;
        Integer right = rightStart;
        Integer index = leftStart;

        while (left <= leftEnd && right <= rightEnd){
            if (values[left].compareTo(values[right]) <= 0){
                temp[index] = values[left];
                left++;
            } else {
                temp[index] = values[right];
                right++;
            }
            index++;
        }
        System.arraycopy(values, left, temp, index, leftEnd - left +1);
        System.arraycopy(values, right, temp, index, rightEnd - right +1);
        System.arraycopy(temp, leftStart, values, leftStart, size);

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
