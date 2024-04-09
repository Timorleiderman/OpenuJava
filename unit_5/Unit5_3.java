package unit_5;

public class Unit5_3 {

    public static void main(String [] args) {
        System.out.println(something("abcdabcd"));
        System.out.println(mod(4, 12345) == 1);

    }
    public static String something(String s)
    {
      char prev = '#';   
      int k = 0;
    
      for (int i = 0; i < s.length(); i++)
      {
         if (prev != s.charAt(i)) 
         {
             prev = s.charAt(i);
             s = s.substring(0, k) + s.charAt(i) + s.substring(k+1);
             k++;
         }
      }
    
      return s.substring(0, k);
    }

    public static boolean isPrime(int num) {

        boolean prime = true;
        int sqtr = (int)Math.sqrt(num);
        for (int i = 2; i < sqtr && prime; i++)
            if (num%i == 0)
                prime = false;

        return prime;
    }

    public static int mod(int n, int num) {

        int sign = 1;
        if (num < 0) {
            sign = -1;
        }

        for ( ; num < 1 || n <= num; num = num - sign*n)
        ;
        return num;
    }
    
    public static int gcd(int p, int q) {
        if (p < 0)
            p = -p;
        if (q < 0)
            q = -q;
        int n = Math.min(p, q);

        for ( ; p % n != 0 || q % n !=0; n--)
        ;

        return n;
    }
}
