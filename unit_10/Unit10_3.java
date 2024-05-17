package unit_10;

public class Unit10_3 {

    public static void main(String [] args) {
        
        // System.out.println(markChar("abcdef", 'a'));
    }

    public static int [] merge( int [] a, int [] b) {

        int lenA = a.length;
        int lenB = b.length;
        int [] c = new int[lenA + lenB];

        merge(a, b, c, 0, 0);

        return c;
    }

    private static void merge(int [] a, int [] b, int [] c, int aIdx, int bIdx){

    }

}


