package unit_3;

import java.util.Scanner;

public class Unit3_3 {

    public static void main (String [] args) {

        String str1 = "abcdefghi abc";

        System.out.println(str1);
        System.out.println(str1.length());
        System.out.println(str1.indexOf("d"));
        System.out.println(str1.indexOf( "b", str1.indexOf("b")+1 ) );
        System.out.println(str1.substring(3));
        System.out.println(str1.substring(str1.indexOf("d"), str1.indexOf("i")+1));
        System.out.println(str1.toUpperCase());

        String str2 = str1.replace("a", "z");
        System.out.println(str2);

        String str3 = str1 + " " + str2;
        System.out.println(str3);

        System.out.println("give me three strings");
        Scanner scanner = new Scanner(System.in);
        String str_user_1 = scanner.next();
        String str_user_2 = scanner.next();
        String str_user_3 = scanner.next();
        String tmp;
        if (str_user_1.compareTo(str_user_2) > 0) { // 2 is before
            tmp = str_user_1;
            str_user_1 = str_user_2;
            str_user_2 = tmp;
        }
        if (str_user_1.compareTo(str_user_3) > 0) { // 3 is before
            tmp = str_user_1;
            str_user_1 = str_user_3;
            str_user_3 = tmp;
        }
        if (str_user_2.compareTo(str_user_3) > 0) { // 3 is before
            tmp = str_user_2;
            str_user_2 = str_user_3;
            str_user_3 = tmp;
        }

        System.out.println(str_user_1.compareTo(str_user_2));
        System.out.println(str_user_2.compareTo(str_user_3));

        System.out.println(str_user_1);
        System.out.println(str_user_2);
        System.out.println(str_user_3);

        scanner.close();
    }
    
}
