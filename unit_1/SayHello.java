import java.util.Scanner;

public class SayHello
{
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int x;
        double d;
        x = scan.nextInt();
        d = scan.nextDouble();
        
        System.out.println("x = " + x  + "\nd = " + d);

        scan.close();
    }
    
}
