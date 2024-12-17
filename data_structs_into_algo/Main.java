import java.util.Random;

class DHeap {

    private int _d;

    // Counters for comparisons and assignments
    int compare_cnt = 0;
    int assign_cnt = 0;


    /**
     * Constructs and initializes d-heap object with a given d (number of children per node)
     * @param d
     */
    public DHeap(int d) {
        if (d <= 1) {
            throw new IllegalArgumentException("d must be greater than 1");
        }
        _d = d;
    }

    /**
     * given an array, sort it in ascending order
     * @param arr
     */
    public void sort(int arr[]) {

        if (arr == null || arr.length == 0) {
            return; // Handle null or empty array
        }
        //initizlize counters on each sorting
        compare_cnt = 0;
        assign_cnt = 0;

        buildDMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i); // heap size changes each iteration
        }        

    }


    /**
     * get the k^th child index 0-based
     * @param i - node index
     * @param k - k^th child
     * @return the index of the left child
     */
    private int child(int k, int i) {
        return _d * i + k + 1;
    }

    /**
     * build a max d-heap using heapify
     */
    public void buildDMaxHeap(int arr[]) {
        int n = arr.length;
        for (int i = (n - 2)/ _d; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * heapify for a d-heap it will heapify the given array
     * @param arr - array
     * @param i - index
     * @param n - size to heapify - during sorting heapsize reduces
     */
    public void heapify(int arr[], int i, int n) {
 
        int largest_idx = i;
        for (int k = 1; k <= _d; k++) { //iterate over all children 
            int ch_idx = child(k-1, i); // k-1 for 0 based index
            if (ch_idx < n && arr[ch_idx] > arr[largest_idx]) {
                compare_cnt++;
                largest_idx = ch_idx;
            }
        }
        if (largest_idx != i){
                swap(arr, largest_idx, i);
                heapify(arr, largest_idx, n);
        }
    }

    /**
     * swap two elements in an array
     * @param arr - array
     * @param i - index
     * @param j - index
     */
    public void swap(int arr[], int i, int j){
        assign_cnt += 3;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * check if the array is a valid d-heap
     * @param arr - array
     * @return true if the array is a valid d-heap
     */
    public boolean validHeap(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < _d; k++) {
                int ch_idx = child(k, i);
                if (ch_idx < n && arr[ch_idx] > arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    
}


public class Main {

    private static final int RAND_RANGE = 1023;
    private static final int A_LENGTH = 50;
    private static final int B_LENGTH = 100;
    private static final int C_LENGTH = 200;

    /**
     * 
     * @param arr input array to be filled with random numbers in the range of 0..RAND_RANGE
     */
    static void fillRandonm(int arr[]) {

        Random rd = new Random(); // creating Random object

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(RAND_RANGE); 
         }
    }
    
    /**
     * print a given array
     * @param arr
     */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    /**
     * validate that arr and expected are the same by iterating over all values O(n)
     * @param arr
     * @param expected
     * @return true is same
     */
    static boolean validateArr(int arr[], int expected[]){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != expected[i]){
                System.out.println("Error idx: " + i + " -> " + arr[i] + " != " + expected[i]);
                return false;
            }
         }
        return true;
    }

    /**
     * test case for maman for given d and array size it will create a random array and sort it
     * it will print the comparisosn and assigments of the sort algorithem
     * @param d - number of children per node
     * @param array_size - size of array to create and sort
     */
    static void testDHeap(int d, int array_size){
        System.out.print(">>> Test d-heap with d: " + d + " array size: " + array_size);
        DHeap heap = new DHeap(d);
        int[] arr = new int[array_size];
        fillRandonm(arr);
        heap.sort(arr);
        heap.validHeap(arr);
        System.out.println(" - comparisons: " + heap.compare_cnt + " assignments: " + heap.assign_cnt);
    }
    
    public static void main(String[] args){
        
        // simple test just to check if buildDMaxHeap and heapify works
        int[] test_arr =          {27, 17,  3, 16, 13, 10, 1, 5,  7, 12, 4, 8, 9, 0};
        int[] test_arr_expected = {27, 17, 10, 16, 13,  9,  1, 5, 7, 12, 4,  8, 3, 0};
        // initialize the d-heap 2
        DHeap heap_test = new DHeap(2);
        
        heap_test.buildDMaxHeap(test_arr);
        if (validateArr(test_arr, test_arr_expected))
            System.out.println(">>> Test 1 passed");
        else
            System.out.println(">>> Test 1 failed");

        if (heap_test.validHeap(test_arr) && heap_test.validHeap(test_arr_expected))
            System.out.println(">>> Test 2 passed");
        else
            System.out.println(">>> Test 2 failed");

        // maman13 tests initialize with random numbers and count number of comparisons and assignments on array numbers
        // test with d = 2, 3, 4, 5 on array sizes A_LENGTH, B_LENGTH, C_LENGTH
        for (int i= 2; i <= 5; i++) {
            testDHeap(i, A_LENGTH);
            testDHeap(i, B_LENGTH);
            testDHeap(i, C_LENGTH);
        }
        
        
    }
}

