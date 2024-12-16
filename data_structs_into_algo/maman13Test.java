
import java.util.Random;


public class maman13Test {

    private static final int RAND_RANGE = 1023;
    private static final int A_LENGTH = 50;
    private static final int B_LENGTH = 100;
    private static final int C_LENGTH = 200;


    static void fillRandonm(int arr[]) {

        Random rd = new Random(); // creating Random object

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(RAND_RANGE); 
         }
    }
    
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    static boolean validateArr(int arr[], int expected[]){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != expected[i]){
                System.out.println("Error idx: " + i + " -> " + arr[i] + " != " + expected[i]);
                return false;
            }
         }
        return true;
    }

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
        testDHeap(2, A_LENGTH);
        testDHeap(2, B_LENGTH);
        testDHeap(2, C_LENGTH);

        testDHeap(3, A_LENGTH);
        testDHeap(3, B_LENGTH);
        testDHeap(3, C_LENGTH);

        testDHeap(4, A_LENGTH);
        testDHeap(4, B_LENGTH);
        testDHeap(4, C_LENGTH);

        testDHeap(5, A_LENGTH);
        testDHeap(5, B_LENGTH);
        testDHeap(5, C_LENGTH);

        
    }
}
