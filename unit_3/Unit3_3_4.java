
import java.util.Scanner;

public class Unit3_3_4 {
    public static void main(String [] args) {

        System.out.println("Give me d and n to be rounded");
        Scanner scanner = new Scanner(System.in);
        double d_in = scanner.nextDouble();
        int n_in = scanner.nextInt();

        double power = Math.pow(10, n_in);
        double d_rounded = d_in * power;

        int rounded = (int)Math.round(d_rounded);
        d_rounded = rounded / power;
        System.out.println(d_rounded);

        scanner.close();
    }
}
