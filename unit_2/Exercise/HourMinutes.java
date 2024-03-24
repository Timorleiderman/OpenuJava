package Exercise;

import java.util.Scanner;

public class HourMinutes {
    public static void main (String [] args) {
        System.out.println("Enter two numbers fro hours and minutes:");
        Scanner scanner = new Scanner(System.in);

        int hh = scanner.nextInt();
        int mm = scanner.nextInt();

        System.out.println("Is the format 12 or 24:");
        int h_type = scanner.nextInt();

        String str = "";
        if ( ( (hh >= 0) && (hh <= 24) ) && ( (mm >= 0) && (mm <= 60) )) {
            
            
            if (h_type == 12) {
                if (hh < 12) {
                    str = "AM ";
                } else {
                    str = "PM ";
                    hh -= 12;
                }
                if (hh == 0)
                    hh = 12;
            }

            str += hh < 10 ? "0" : "";
            str += hh + ":";
            str += mm < 10 ? "0" : "";
            str += mm;

            

            System.out.println("Time is: " + str);
            
        }
        else
            System.out.println("input is not correct");

            scanner.close();
    }
}
