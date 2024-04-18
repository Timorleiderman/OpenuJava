package unit_6;

public class Unit6_1 {

    public static void main(String [] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 6};

        swap(arr, 3, 4);
        
        for (int i=0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    public static void swap(int [] a, int i, int j){
        int len_arr = a.length;
        if (i>=0 || j>=0 || i<len_arr || j<len_arr) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public static int maxFirstLast(int [] m) {
        return Math.max(m[0], m[m.length - 1]);
    }

    public static int[] getFirstLast(int [] a) {
        int[] res = {a[0], a[a.length - 1]};
        return res;
    }

    public static int med(int[] a) {
        int mid = a.length / 2;
        int med = a[mid];

        if (a.length % 2 == 0)
            med = (a[mid] + a[mid+1]) / 2;
            
        return med;
    }

    public static int [] mergeStartEnd(int[] a, int[] b) {
        int[] res = {Math.min(a[0], b[0]), Math.max(a[a.length - 1], b[b.length -1])};
        return res;
    }
}

