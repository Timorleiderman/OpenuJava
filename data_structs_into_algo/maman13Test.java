
import java.util.Random;


public class maman13Test {

    private static final int RAND_RANGE = 1023;
    private static final int A_LENGTH = 50;
    private static final int B_LENGTH = 100;
    private static final int C_LENGTH = 200;

    static void fillRandArr(int arr[]) {

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
        // System.out.print("Actual:   ");
        // printArray(arr);
        // System.out.print("Expected: ");
        // printArray(expected);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != expected[i]){
                System.out.println("Error idx: " + i + " -> " + arr[i] + " != " + expected[i]);
                return false;
            }
         }
        return true;
    }

    
    public static void main(String[] args){
        
        int[] test_arr =          {27, 17,  3, 16, 13, 10, 1, 5,  7, 12, 4, 8, 9, 0};
        int[] test_arr_expected = {27, 17, 10, 16, 13,  9,  1, 5, 7, 12, 4,  8, 3, 0};

        DHeap heap2 = new DHeap(2);
        DHeap heap3 = new DHeap(3);
        DHeap heap4 = new DHeap(4);
        DHeap heap5 = new DHeap(5);


        heap2.buildDMaxHeap(test_arr);

        if (validateArr(test_arr, test_arr_expected))
            System.out.println(">>> Test 1 passed");
        else
            System.out.println(">>> Test 1 failed");


        int[] A = new int[A_LENGTH];
        fillRandArr(A);
        int[] B = new int[B_LENGTH];
        fillRandArr(B);
        int[] C = new int[C_LENGTH];
        fillRandArr(C);

        
        printArray(A); // print the array
        heap4.buildDMaxHeap(A);
        printArray(A);
        if (heap4.validHeap(A))
            System.out.println(">>> Test 2 passed");
        else
            System.out.println(">>> Test 2 failed");

        
        


    }
}
