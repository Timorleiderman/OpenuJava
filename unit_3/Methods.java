import java.util.Scanner;


public class Methods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //use the average method
        double a, b, c;
        System.out.println("enter 3 numbers to calc average");
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();
        double avr = average(a, b, c);
        System.out.println("the average of " + a + ", "
        + b + ", " + c + " = " + avr);
        //use isInRange method to check if input number
        // from the use in range 85 - 100
        System.out.println("\nenter a number");
        int n = scan.nextInt();
        if (isInRange(n, 85, 100)) {
        System.out.println(
        "the number is in range of 85 - 100");
        } else {
            System.out.println("the number is not in range of 85 - 100");
        }
        //use concat 2 strings from user
        System.out.println("\nenter 2 words to concat them");
        String s1 = scan.next();
        String s2 = scan.next();
        String concat = concat(s1, s2);
        System.out.println("the concat string is: " + concat);

        scan.close();
        }


public static String concat(String str1, String str2) {
    return str1 + str2;
}

public static boolean isInRange(int n, int lo, int hi) {
    return (( n >= lo) && (n <= hi));
}
public static double average(double a, double b, double c) {
    return (a + b + c) / 3.0;
}

}
