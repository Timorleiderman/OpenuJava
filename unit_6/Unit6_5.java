package unit_6;

public class Unit6_5 {

    public static void main(String [] args) {
        
        int[][] arr = {{2,4,5},{1,-1,3}, {0,9,7},{3,2,0}};
        print2dArr(arr);
        System.out.println("Address od arr is: " + arr);
        System.out.println("Max Row Sum " + maxSumRow(arr));
        System.out.println("Max Row SumAvg " + maxAverageRow(arr));
        
    }
    public static void print2dArr(int[][] arr) {
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    
    private static int sum(int [] a) {
        int sum = 0;
        for (int i=0; i< a.length; i++) {
            sum += a[i];
        }

        return sum;
    }
    public static int maxSumRow(int[][] a) {
        int maxSum = sum(a[0]);
        int idx = 0;
        int curSum;
        for (int i = 1; i < a.length; i++) {
            curSum = sum(a[i]);
            if (curSum > maxSum) { 
                maxSum = curSum;
                idx = i;
            }
        }
        return idx;
    }

    public static int maxAverageRow(int[][] a) {
        double maxSumAvg = sum(a[0]) / (double)a[0].length;
        double curSumAvg;
        int idx = 0;
        for (int i = 1; i < a.length; i++) {
            curSumAvg = sum(a[i]) / (double)a[i].length;

            if (curSumAvg > maxSumAvg) { 
                maxSumAvg = curSumAvg;
                idx = i;
            }
        }
        return idx;
    }
    
    public static boolean isRowSorted(int [][] a, int r) {

        for (int i=1; i<a[r].length; i++) {
            if (a[r][i] <= a[r][i-1])
                return false;
        }
        return true;
    }

    public static boolean isAllRowsSorte(int [][] a) {

        for (int i=0; i<a.length; i++) {
            if (!isRowSorted(a, i))
                return false;
        }
        return true;
    }

    public static boolean isColSorted(int [][] a, int c) {

        for (int i=1; i<a.length; i++) {
            if (a[i][c] <= a[i-1][c])
                return false;
        }
        return true;
    }

    public static boolean isAllColsSorted(int [][] a) {

        for (int i=0; i<a[0].length; i++) {
            if (!isColSorted(a, i))
                return false;
        }
        return true;
    }

}

