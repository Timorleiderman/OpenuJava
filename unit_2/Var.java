
// unit 2
public class Var {
    public static void main(String [] args) {

        final int MIN = 1;
        int x;
        double d;
        boolean b;

        x = 10;
        d = 12.5;
        b = true;

        d = x;

        // The final local variable MIN cannot be assigned. It must be blank and not using a compound assignment
        // MIN = 1;

        // Type mismatch: cannot convert from double to int
        // x = d;

        System.out.println("x = " + x);
        System.out.println("d = " + d);
        System.out.println("b = " + b);
        System.out.println("MIN = " + (double)(100+100+98)/3);

    }
}