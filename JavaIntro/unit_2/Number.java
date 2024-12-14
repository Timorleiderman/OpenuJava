import java.util.Scanner;

public class Number {    

     public static void main(String[] args)  {        

        Scanner scanner = new Scanner(System.in);   
        System.out.println("Please enter number");     

        int num =  scanner.nextInt();
        if (num == 1 || num == 2)
            num++;
        else if (num >= 3 && num <= 5)
            num--;
        else if (num == 6)
            num*=2;
        else
            num*=3; 
        System.out.println("The new number is: " + num);

        scanner.close();
      }
}