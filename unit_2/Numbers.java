import java.util.Scanner;

public class Numbers {    

     public static void main(String[] args)  {        

        Scanner scanner = new Scanner(System.in);   
        System.out.println("Please enter two numbers");     

        int num1 =  scanner.nextInt();
        int num2 =  scanner.nextInt();

        System.out.println("x + y = "+ (num1 + num2) );
        System.out.println("x - y = "+ (num1 - num2) );


     }
}