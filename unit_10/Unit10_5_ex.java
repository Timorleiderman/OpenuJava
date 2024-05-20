package unit_10;

public class Unit10_5_ex {

    public static void main(String[] args) {
        
        System.out.println("For call match({2,3,57}, {1,0,2}), result is " + match(new int[]{2,3,57}, new int[]{1,0,2}));
        System.out.println("For call match({5,39,67}, {1,0,2}), result is " + match(new int[]{5,39,67}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,34,35}, {1,0,2}), result is " + match(new int[]{2,3,573,4,34,35}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,324,35}, {}), result is " + match(new int[]{2,3,573,4,324,35}, new int[]{}));
        System.out.println("For call match({2,3}, {1,0,2}), result is " + match(new int[]{2,3}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,324,35}, {1,0,2}), result is " + match(new int[]{2,3,573,4,324,35}, new int[]{1,0,2}));
    }
    
    /* Complete your code here */
    public static boolean match (int [] a, int [] pattern) {
        return match(a, 0, pattern, 0);
    }
    
    private static boolean match (int [] a, int aIdx, int [] pattern, int pIdx) {
        
        if (pIdx == pattern.length)
            return true;

        if (aIdx == a.length)
            return false;
        
        // no mach in current
        if (a[aIdx] > 99)
            return match(a, aIdx+1, pattern, 0);
        
        // no mach
        if (pattern[pIdx] == 1 && a[aIdx] > 9)
            return match(a, aIdx+1, pattern, 0);
            
        // no mach
        if (pattern[pIdx] == 2 && a[aIdx] < 10)
            return match(a, aIdx+1, pattern, 0);
        
        return match(a, aIdx+1, pattern, pIdx+1) || match(a, aIdx+1, pattern, 0);

    }

    
    public static int distance(String s1, String s2) {

        if (s1.length() == 0)
             return s2.length();
   
        if (s2.length() == 0)
             return -1;
   
        int val, addDistance;

        if (s1.charAt(0) == s2.charAt(0)) {
             val = distance(s1.substring(1), s2.substring(1));
             addDistance = 0;
        } else {
             val = distance(s1, s2.substring(1));
             addDistance = 1;
        }
   
        if (val == -1)
             return -1;
        else
             return addDistance + val;
   }
}


