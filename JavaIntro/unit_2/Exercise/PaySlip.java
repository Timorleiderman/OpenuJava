package Exercise;

import java.util.Scanner;

public class PaySlip {
    public static void main (String [] args) {
        // int twoPi = 2*3.14159;  /* holds the value of two times pi */
        Scanner scanner = new Scanner(System.in);
        System.out.println (/* 8.0 + 5 */ -6 + 3/*5*//1 ); //*+9*/ -2;

        System.out.println("Enter base salary working hours and day of week:");
        // int a, b, c;

        // double x, y, z;

        // a = c%5;
        // b = x/7;
        // b = c*z;
        // int ilovceU!;
        

        int base = scanner.nextInt();
        double hours = scanner.nextDouble();
        int day = scanner.nextInt();
        double salary;

        salary = hours * base;
        
        if ( (day < 0) && (day >=7) ){
            System.out.println("Wrong day input");
        } else {
            if ( (day <=5 )) {
                if (hours > 8)
                    salary += base * ( hours - 8) * 0.25;
            } else if ( day == 6) {
                if (hours > 6)
                    salary += base * ( hours - 6) * 0.5;
            } else if ( day == 7) {
                if (hours > 4)
                    salary += base * ( hours - 4) ;
            }
            System.out.println("the salary = " + salary);
        }
        scanner.close();
    }
}
