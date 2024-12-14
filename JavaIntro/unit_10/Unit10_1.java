package unit_10;

public class Unit10_1 {

    public static void main(String [] args) {
        
        
    }

    public static int an(int n, int d, int a1) {

        if (n == 1) 
        {
            return a1;
        }
        int an_val = an(n-1, d, a1);
        return an_val + d;
    }

    public static int sn(int n, int d, int a1) {
        if (n == 1) {
            return a1;
        }

        int sum = sn(n - 1, d, a1);
        int an_val = an(n, d, a1);
        return sum + an_val;
    }

    public static int count7(int num) {
        if (num == 0) {
            return 0;
        }
        int digit = num % 10;
        int sum = count7(num / 10);
        if (digit == 7)
            return 1 + sum;
        return sum;
    }
}

