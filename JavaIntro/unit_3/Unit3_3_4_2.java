package unit_3;

import java.util.Random;

public class Unit3_3_4_2 {
    public static void main(String [] args) {

        Random rand = new Random();

        String s = "Hello World";
        System.out.println(s.charAt(s.length()-1));     
        System.out.println(s.equals("Hello world"));     

        int num = rand.nextInt(13) + 1;
        int type = rand.nextInt(4);
        String type_name = "";

        switch (type) {
            case 0:
                type_name = "Heart";
                break;
            case 1:
                type_name = "Club";
                break;
            case 2:
                type_name = "Diamond";
                break;
            case 3:
                type_name = "Spade";
        }
        System.out.println("card = " + num + " type = " + type_name);

    }
}
