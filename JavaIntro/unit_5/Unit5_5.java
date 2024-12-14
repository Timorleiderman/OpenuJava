package unit_5;
import java.util.Scanner;
public class Unit5_5 {

    public static void main(String [] args) {
        System.out.println(popDigit(525331482));

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

    public static void printPiramid(int lines) {
        int stars = 1;
        int spaces = lines;
        for (int row=0; row<lines; row++ , stars+=2, spaces--) {

            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < stars; col++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void printDivisors() {
        Scanner scanner = new Scanner(System.in);   
        System.out.println("enter number to print their divisore, -1 to stop");

        int num = scanner.nextInt();
        while (num != -1) {
            System.out.print("Divisors of " + num + " : 1");
            for (int i=2; i < num; i++) {
                if (num % i == 0) {
                    System.out.print( "," + i);
                }
            }
            System.out.println("," + num);
            num = scanner.nextInt();
        }
        System.out.println("Goodbye!");
    }

    public static void printDiagonals(int n) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++){
                if (row == col || row == n - 1 - col) {
                    System.out.print(" 0 ");
                }
                else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public static int popDigit(int num) {
        int max = 0;
        int pop = 0;

        int dig;

        for (int digit=0; digit<10; digit++) {
            int count = 0;
            int tmp = num;

            while (tmp !=0) {
                dig =  tmp % 10;
                if (dig == digit) {
                    count ++;
                }
                tmp /= 10;
            }

            if (max < count) {
                max = count;
                pop = digit;
            }
        }
        return pop;
    }
}
