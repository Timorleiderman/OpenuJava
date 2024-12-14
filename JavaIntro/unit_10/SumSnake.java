package unit_10;

public class SumSnake {
    public static final int BEEN_HERE = -100;
    
    public static void main(String[] args) {
        int[][] mat1 = {{4,5,6,7,1}, {3,5,1,7,4}, {1,5,6,7,8}, {3,4,5,7,9}, {3,2,2,7,6}};
        System.out.println("For call maxSumSnake({{4,5,6,7,1}, {3,5,1,7,4}, {1,5,6,7,8}, {3,4,5,7,9}, {3,2,2,7,6}}), result is " + maxSumSnake(mat1));
        
        int[][] mat2 = {{4,5,6}, {3,8,1}, {1,5,6}};
        System.out.println("For call maxSumSnake({{4,5,6}, {3,8,1}, {1,5,6}}), result is " + maxSumSnake(mat2));
    }
    
    /* Complete your code here */
    
    public static int maxSumSnake(int[][] mat) {
        return maxSumSnake(mat, 0, 0);
    }
    
    private static int maxSumSnake(int[][] mat, int row, int col) {
        
        if (row == mat.length - 1 && col == mat[0].length - 1)
            return mat[row][col];
        
        int temp = mat[row][col];
        mat[row][col] = BEEN_HERE;
        
        int up = -1;
        int down = -1;
        int right = -1;
        int left = -1;
        
        if (row - 1 >= 0 && Math.abs(temp - mat[row - 1][col]) <= 1)
            up = maxSumSnake(mat, row - 1, col);
        
        if (row + 1 < mat.length && Math.abs(temp - mat[row + 1][col]) <= 1)
            down = maxSumSnake(mat, row + 1, col);
        
        if (col - 1 >= 0 && Math.abs(temp - mat[row][col-1]) <= 1)
            left = maxSumSnake(mat, row, col - 1);
        
        if (col + 1 < mat[0].length && Math.abs(temp - mat[row][col+1]) <= 1)
            right = maxSumSnake(mat, row , col + 1);
        
        mat[row][col] = temp;
        
        if (up == -1 && down == -1 && right == -1 && left == -1)
            return -1;
        
        int max = Math.max( Math.max(up, down) , Math.max(left, right) );
        
        return mat[row][col] + max;
             
        
        
    }
    
    
}
