package unit_5;

public class Unit5_1 {

    public static void main(String [] args) {
        System.out.println("Hey");
        // 535
        // temp1 = 5
        // temp2 = 3
        // 53
        // temp = 3 == temp1
        // 5
        
        // System.out.println(sumEven(12345) == 6);
        System.out.println(gcd(6, 9));
        // System.out.println(mod(4, 12345) == 1);


    }

    public static int sumEven(int num) {
        int res = 0;
        int dig;
        while (num > 0) {
            dig = num % 10;
            num /= 10;
            if (dig % 2 == 0) 
                res += dig;
        }

        return res;
    }

    public static int mod(int n, int num) {
        while (num < 1 || n <= num) {
            System.out.println(num);
            if (num < 1)
                num += n;
            else
                num -= n;
        }
        return num;
    }
    
    public static int gcd(int p, int q) {
        if (p < 0)
            p = -p;
        if (q < 0)
            q = -q;

        int cand = Math.min(p, q);
        while (p % cand != 0 || q % cand !=0)
            cand--;

        return cand;
    }
}
