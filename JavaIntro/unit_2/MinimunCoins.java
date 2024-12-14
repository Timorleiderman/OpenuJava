import java.util.Scanner;

public class MinimunCoins  {    

     public static void main (String[] args)  {       
           Scanner scanner = new Scanner(System.in);
           int price;
           int amount;

           System.out.println("Please enter the price in shekels");        
           price = scanner.nextInt();        

           amount = price / 10;        
           price = price % 10;        
           System.out.println("We need " + amount + " coins of 10 NIS");        

           amount = price / 5;        
           price = price % 5;        
           System.out.println("We need " + amount + " coins of 5 NIS");         

           amount = price / 1;        
           price = price % 1;        
           System.out.println("We need " + amount + " coins of 1 NIS");    

           scanner.close();
     }     

}