package unit_10;

public class Unit10_3 {

    public static void main(String [] args) {
        
        // System.out.println(markChar("abcdef", 'a'));
        int [] a = {1, 3, 5, 8, 11};
        int [] b = {4, 12};
        int [] c = merge(a, b);

        printArr(c);
        orderOddEven(c);
        printArr(c);

        System.out.println(isSub(a, b));
        System.out.println(div4Or7(b));
    }

    public static void printArr(int [] a) {
        for (int i=0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static int [] merge( int [] a, int [] b) {

        int lenA = a.length;
        int lenB = b.length;
        int [] c = new int[lenA + lenB];

        merge(a, b, c, 0, 0);

        return c;
    }

    private static void merge(int [] a, int [] b, int [] c, int aIdx, int bIdx){

        if (aIdx + bIdx == c.length)
            return;

        if (bIdx == b.length || aIdx < a.length && a[aIdx] < b[bIdx] ) {
            c[aIdx + bIdx] = a[aIdx];
            aIdx++;
            merge(a, b, c, aIdx, bIdx);
        } else {
            c[aIdx + bIdx] = b[bIdx];
            bIdx++;
            merge(a, b, c, aIdx, bIdx);
        }
    }

    public static void orderOddEven(int [] a) {
        orderOddEven(a, 0, a.length - 1);
    }
    private static void orderOddEven(int [] a, int left, int right) {
        
        if (left > right)
            return;

        if (a[left] % 2 == 1) {
            orderOddEven(a, left+1, right);
        }
        else if (a[right] % 2 == 0) {
            orderOddEven(a, left, right-1);
        }
        else {
            swap(a, left, right);
            orderOddEven(a, left+1, right-1);
        }
    }

    public static boolean isSub(int [] base, int [] sub) {
        return isSub(base,0, sub);
    }

    private static boolean isSub(int [] base, int bIdx, int [] sub){
        if (base.length - bIdx < sub.length)
            return false;
        
            if (isSub(base, bIdx, sub, 0))
                return true;

        return isSub(base, bIdx+ 1, sub);
    }

    private static boolean isSub(int [] base, int bIdx, int [] sub, int sIdx){
        
        if (bIdx == sub.length)
            return true;
        
        if (base[bIdx] != sub[sIdx])
            return false;
        
            return isSub(base, bIdx+1, sub, sIdx+1);
        
        
    }

    public static boolean div4Or7(int [] a) {
        return div4Or7(a, 0, 4) || div4Or7(a,0, 7);
    }

    private static boolean div4Or7(int [] a, int idx, int div) {
        if (idx == a.length)
            return true;
        if (a[idx] % div != 0)
            return false;

        return div4Or7(a, idx+1, div);
    }



    private static void swap(int [] a, int idx, int jdx)
    {
        int tmp = a[idx];
        a[idx] = a[jdx];
        a[jdx] = tmp;
    }
}


