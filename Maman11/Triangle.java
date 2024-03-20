
/**
 * The Triangle class prints the perimeter and the area of a triangle if the input is valid
 */
import java.util.Scanner;

public class Triangle
{
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);

        System.out.println ("This program calculates the area " 
            + "and the perimeter of a given triangle. ");
        System.out.println ("Please enter the three lengths" 
            + " of the triangle's sides");
 
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println("The lengths of the triangle sides are: " 
            + a + ", " + b + ", " + c);

        if ( (a + b > c) && (a + c > b) && (b + c > a) ) {
            double p = (a + b + c) / 2;
            double s = Math.sqrt(p * (p - a ) * (p - b) * (p - c));

            System.out.println("The perimeter of the triangle is: " + (int)p*2);
            System.out.println("The area of the triangle is: " + s);
        } else {
            System.out.println("The given three sides don't represent a triangle");
        }
        scan.close();

    } // end of method main
} //end of class Triangle 