
import java.util.Scanner;

public class Rectangle {

    public static void main (String [] args) {

        // define parameters
        int height;
        int width;
        int area;
        int perimeter;
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // interact with user
        System.out.println("Enter height:");
        height = scanner.nextInt();
        System.out.println("Enter width:");
        width = scanner.nextInt();

        // calculate
        perimeter = 2*height + 2*width;
        area = width*height;

        // stdout the result
        System.out.println("perimeter = " + perimeter);
        System.out.println("area = " + area);

        scanner.close();
    }
}