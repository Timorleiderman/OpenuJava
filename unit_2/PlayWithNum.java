import java.util.Scanner;

public class PlayWithNum {    

     public static void main(String[] args) {        
          final int SMALL_NUM = 10, MEDIUM_NUM = 100, BIG_NUM = 1000;

          Scanner scan = new Scanner(System.in);           

          System.out.println("Please enter number");        

          int num = scan.nextInt();        

          if (num < SMALL_NUM)
                System.out.println("small");
          else if (num < MEDIUM_NUM)
                System.out.println("medium");
          else if (num < BIG_NUM)
                System.out.println("big");
          else
                System.out.println("very big");

     }

}
