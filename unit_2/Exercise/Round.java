package Exercise;
import java.util.Scanner;


public class Round {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a real number");
        double num = scanner.nextDouble();
        
        double fix = 0.5;
        int rounded_num;
        
        if (num < 0)
            fix *= -1;

        rounded_num = (int) (num*10 + fix);
        rounded_num /= 10.0;
        System.out.println(rounded_num);

        scanner.close();
    }
}