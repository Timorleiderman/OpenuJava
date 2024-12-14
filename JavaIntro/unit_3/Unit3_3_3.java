package unit_3;

import java.util.Random;

public class Unit3_3_3 {
    public static void main(String [] args) {

        Random rand = new Random();
        System.out.println(rand.nextInt(-15, 15));
        System.out.println(rand.nextDouble(-10.5, 10.5));
        System.out.println(Math.sin(Math.toRadians(30)));
        System.out.println(Math.PI * Math.pow(4.35, 2));

        double d = 12.344436;
        double d1 = d * 100;
        int rounded = (int)Math.round(d1);
        d1 = rounded/ 100.0;
        System.out.println(d1);

        
    }
}
