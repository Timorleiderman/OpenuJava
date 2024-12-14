import java.util.Scanner;

public class TriangleCheck {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter 3 cordiantes (6 numbers):");

        int ax = scanner.nextInt();
        int ay = scanner.nextInt();
        
        int bx = scanner.nextInt();
        int by = scanner.nextInt();
        
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();

        double ab = Math.sqrt( Math.pow( (ax - bx), 2) + Math.pow( (ay - by), 2) );
        double ac = Math.sqrt( Math.pow( (ax - cx), 2) + Math.pow( (ay - cy), 2) );
        double bc = Math.sqrt( Math.pow( (bx - cx), 2) + Math.pow( (by - cy), 2) );


        if ((ab == ac) && (ac == bc))
            System.out.println("Equilateral triangle");
        else if ( (ab != ac) && (ac != bc))
            System.out.println("Isosceles triangle");
        else 
            System.out.println("Triangle");

        scanner.close();
    }
}
