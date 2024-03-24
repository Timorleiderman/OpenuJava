package Exercise;

import java.util.Scanner;

public class NumOfWeek {
    public static void main( String [] args) {
        Scanner scan = new Scanner(System.in);
        int days;
        int day;
        int week;
        
        System.out.println("Enter num of days");
        days = scan.nextInt();
        if (0 < days && days <= 365) {

            week = (days + 6) / 7;
            day = days % 7;
            if (day == 0)
                day = 7;
            
            String dayStr = "";
            switch (day) {
            case 1 : dayStr = "Sunday";
                break;
            case 2 : dayStr = "Monday";
                break;
            case 3 : dayStr = "Tuesday";
                break;
            case 4 : dayStr = "Wednesday";
                break;
            case 5 : dayStr = "Thursday";
                break;
            case 6 : dayStr = "Friday";
                break;
            case 0 : dayStr = "Saturday";
            }

            System.out.println(days + " days is in week " + week + " and in day " + dayStr);
        } 
        else {
            System.out.println(days + " invalid number for days");
        }

        scan.close();
    }
}
