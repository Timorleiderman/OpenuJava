
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
    
    public static void main(String[] args){
        System.out.println("Hello World"); // printing each array element
        
        int[] A = new int[A_LENGTH];
        // int[] A = {27, 17, 3, 16, 13, 10,1 ,5,7,12,4,8,9,0};
        int[] B = new int[B_LENGTH];
        int[] C = new int[C_LENGTH];
        
        fillRandArr(A);
        fillRandArr(B);
        fillRandArr(C);

        printArray(A);
      
        HeapSort heap = new HeapSort();
        heap.sort(A);
        printArray(A);


    }
}
