import java.util.Random;

public class Ex13Tester
{
    private static final int PASSWORD_LENGTH = 3;
    private static final int Q3_NUM_OF_TRYS = 5;
    public static void main(String[] args){

        System.out.println ("********** Question 1 **********\n");


        int [] arr1 = createArrayWithSingleElement(1000, 900);
        System.out.println("O(log n)");
        System.out.println(Ex13.findSingle(arr1));

        System.out.println ("********** Question 2 **********\n");
        int [] arr2 = {2, 1, 1, 4, 1, 1, 2, 3};
        System.out.println(Ex13.waterVolume(arr2));


        System.out.println ("********** Question 3 **********\n");

        for (int i=0; i < Q3_NUM_OF_TRYS; i++) {
            Password p = new Password(PASSWORD_LENGTH);
            String getPassword = p.getPassword();
            System.out.println(getPassword);
            String findPassword = Ex13.findPassword(p, PASSWORD_LENGTH);
            System.out.println(findPassword);
            
        }

        System.out.println("********** Question 4**********\n");
        System.out.println();
        boolean[][] mat = {
                {true,false,false,false,true},
                {false,true,true,true,false},
                {false,false,true,true,false},
                {true,false,false,false,false},
                {true,true,false,false,false},
            };

        System.out.println("Number of Regions: " + Ex13.cntTrueReg(mat));

        System.out.println("Done!!!");
    }


    public static int[] createArrayWithSingleElement(int n, int elementPos) {
        // Ensure n is even to accommodate pairs plus one single element
        if (n % 2 != 1) {
            n--;
        }

        int[] arr = new int[n];
        
        // Fill the array with pairs of consecutive integers
        for (int i = 0, j = 0; i < n - 1; i += 2, j++) {
            arr[i] = j;
            arr[i + 1] = j;
        }

        // Shift elements to make space for the single element
        if (elementPos < n - 1) {
            System.arraycopy(arr, elementPos, arr, elementPos + 1, n - 1 - elementPos);
        }
        arr[elementPos] = elementPos;
        
        return arr;
    }


}

