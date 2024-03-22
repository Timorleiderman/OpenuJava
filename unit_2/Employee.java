import java.util.Scanner;

public class Employee {    

     public static void main(String[] args) { 
          final int ADULT = 18;
          final int SENIOR = 67;
          final int GRANT = 200;
          final int HEALTH_TAX = 100;      

          Scanner scanner = new Scanner(System.in);     

          int age; 
          double salary;        

          System.out.println("Please enter your age");        
          age = scanner.nextInt();        

          System.out.println("Please enter your salary");       
          salary = scanner.nextDouble();        

          if (age >= ADULT && age < SENIOR)               
               salary = salary - HEALTH_TAX; // salary -= HEALTH_TAX
          else            
               salary = salary + GRANT; // salary += GRANT

          System.out.println("salary is " + salary);    

     }

}