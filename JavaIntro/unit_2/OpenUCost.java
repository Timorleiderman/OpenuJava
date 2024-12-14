
import java.util.Scanner;

// calculate cost for openU based on 4 parameters 
// seniority
// soldier
// intense
// summer
public class OpenUCost  {    

     public static void main (String[] args)  {       
     
          final int BASE_LESS_18 = 2079;
          final int BASE = 1539;
          
          final double WARIOR_DISCOUNT = 0.5;
          final double SOLDIER_DISCOUNT = 0.1;

          final int INTENCE = 301;
          // final int SUMMER = 286;

          final int SECURITY = 59;

          Scanner scanner = new Scanner(System.in);

          System.out.println("Please enter seniority:");
          int seniority = scanner.nextInt();
          
          System.out.println("Soldier:");
          int soldier = scanner.nextInt();

          System.out.println("Is Intense");
          int intense = scanner.nextInt();

          System.out.println("Is Summer");
          int summer = scanner.nextInt();

          double pay;

          if (seniority == 1)
               pay = BASE_LESS_18;
          else
               pay = BASE;
          
          if (soldier == 1)
               pay = pay * (1 - WARIOR_DISCOUNT);
          else if (soldier == 2)
               pay = pay * (1 - SOLDIER_DISCOUNT);

          if (intense == 1)
               pay += INTENCE;
          
          if (summer == 1)
               pay += 286;
          
          pay += SECURITY;

          
          System.out.println(pay);

          scanner.close();
     }     
}