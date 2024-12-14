package Exercise;

import java.util.Scanner;

public class Digits {
    
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int sum = 0;
        
        System.out.println("Enter a positive 3 digits number");
        num = scanner.nextInt();

        if (99 < num && num < 1000) { // 3 digits
            sum += num % 10;
            num /= 10;
            sum += num % 10;
            num /= 10;
            sum += num;

            System.out.println("sum of digits = " + sum);
        } 
        else { // not 3 digits
            System.out.println(num + " is not a positive 3 digits number");
        }

        scanner.close();
    }
}
