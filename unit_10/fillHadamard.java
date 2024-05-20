/**
 * Main class of the Java program. 
 * 
 */

package unit_10;
import java.util.*;

public class fillHadamard {
    
    /* Complete your code here */
    public static void fillHadamard(int mat[][]){
        fillHadamard(mat, 0, 0, mat.length, 1);
    }
    
    private static void fillHadamard(int mat[][], int top, int left, int height, int sign){
        if (height == 1)
            mat[top][left] = sign;
        else {
            int newHight = height / 2;
            fillHadamard(mat, top, left, newHight, sign);
            fillHadamard(mat, top + newHight, left , newHight, sign);
            fillHadamard(mat, top, left + newHight, newHight, sign);
            fillHadamard(mat, top+newHight, left + newHight, newHight, -sign);
        }
    }

    public static void main(String[] args) {
        
        int[][] mat1 = new int[2][2];
        fillHadamard(mat1);
        System.out.print("For call howManySorted with matrix size 2 X 2, result is:\n");
        print(mat1);
        
        System.out.println();
        
        int[][] mat2 = new int[4][4];
        fillHadamard(mat2);
        System.out.print("For call howManySorted with matrix size 4 X 4, result is:\n");
        print(mat2);
    }
    
    /* Ignore */
    public static void print(int[][] mat) {
        for (int[] row : mat) 
            System.out.println(Arrays.toString(row));
    }
}
