import java.util.Scanner;

public class Weather {
     public static void main(String[] args) {
          final int HOT = 30;
          final int COLD = 5;

          Scanner scanner = new Scanner(System.in);

          System.out.println("please enter 4 temperatures: ");
          int day1 = scanner.nextInt();
          int day2 = scanner.nextInt();
          int day3 = scanner.nextInt();
          int day4 = scanner.nextInt();

          int countCold = 0;
          int countHot = 0;

          if (day1 >= HOT)
               countHot++;
          else if (day1 <= COLD)
               countCold++;

          if (day2 >= HOT)
               countHot++;
          else if (day2 <= COLD)
               countCold++;
          if (day3 >= HOT)
               countHot++;
          else if (day3 <= COLD)
               countCold++;

          if (day3 >= HOT)
               countHot++;
          else if (day4 <= COLD)
               countCold++;

          if (countHot == 1 || countHot == 2 || countCold == 1)
               System.out.println("Usual");
          else if ((countHot == 3 || countHot == 4) ||
                      (countCold >= 2 && countCold <= 4))
               System.out.println("Extreme");
          else
               System.out.println("Other");

          scanner.close();
     }

}