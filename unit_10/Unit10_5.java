package unit_10;

public class Unit10_5 {

    public static void main(String [] args) {

        int [][] arr = { 
            {4, 2, 3},
            {4, 56, 4},
            {12, 8, 6578}
        };

        System.out.println(str2arr(arr));

        System.out.println(countNum(arr, 4));

    }

    public static String str2arr( int [][] a) {
        return str2arr(a, 0);
    }

    private static String str2arr( int [][] a, int row) {

        if (row == a.length)
            return "";
        
        return str2arr(a[row], 0) + "\n" + str2arr(a, row + 1);

    }

    private static String str2arr( int [] a, int idx) {

        if (idx == a.length)
            return "";

        return a[idx] + " " + str2arr(a, idx+1);
    }


    public static int countNum(int [][] a, int num) {
        return countNum(a, 0, num);
    }

    private static int countNum(int [][] a, int row, int num) {
        if (a.length == row)
            return 0;
        
        return countNum(a[row], 0, num) + countNum(a, row+1, num);
    }

    private static int countNum(int [] a, int idx, int num) {
        if (a.length == idx)
            return 0;

        return (a[idx] == num ? 1 : 0) + countNum(a, idx+1, num);
    }

}


