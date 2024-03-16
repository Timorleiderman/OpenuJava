import java.util.Scanner;

public class Three {
    public static void main( String [] args) {

        int three_num;
        // scanner for input
        Scanner scan = new Scanner(System.in);

        System.out.println("Give me a number between 100 and 999");
        three_num = scan.nextInt();

        System.out.println(three_num / 100);
        System.out.println(three_num / 10 % 10);
        System.out.println(three_num % 10);

    }
}
