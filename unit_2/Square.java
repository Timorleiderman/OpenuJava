import java.util.Scanner;

public class Square {

     public static void main(String[] args) {

          Scanner scanner = new Scanner(System.in);

          System.out.println("Please enter four lengths:");

          int a = scanner.nextInt();
          int b = scanner.nextInt();
          int c = scanner.nextInt();
          int d = scanner.nextInt();

          if (a == b && b == c && c == d)

               System.out.println("Square");

          else

               System.out.println("Not Square");
     }
}