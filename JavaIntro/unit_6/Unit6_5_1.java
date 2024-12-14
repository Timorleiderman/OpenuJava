package unit_6;

public class Unit6_5_1 {

    public static void main(String [] args) {
        int[] a = {2,5,3,1,7,9,3,5,7};
        int[] b = {1,2,3,4,5,6,7,8,9};

        printArr(a);
        printArr(b);
        System.out.println(find1(a, b, 5));
        
    }

    public static void sort123(int [] a) {

        int i = 0;
        while (i < a.length && a[i] == 0) {
            i++;
        }
        int j = i+1;
        while (j < a.length) {
            if ( a[j] == 0 ) {
                swap(a, i, j);
                i++;
            } else {
                j++;
            }
        }

        while (i < a.length && a[i] == 1) {
            i++;
        }
        j = i + 1;
        while (j < a.length) {
            if ( a[j] == 1 ) {
                swap(a, i, j);
                i++;
            } else {
                j++;
            }
        }
        
    }

    public static void sort123_b(int [] a) {
        int zeroIdx = 0;
        while (zeroIdx < a.length && a[zeroIdx] == 0) {
            zeroIdx++;
        }

        int oneIdx = zeroIdx;
        int twoIdx = a.length - 1;

        while (oneIdx <= twoIdx) {
            if (a[oneIdx] == 2){
                swap(a, oneIdx, twoIdx);
                twoIdx--;
            } else if (a[oneIdx] == 1) {
                oneIdx++;
            } else {
                swap(a, zeroIdx, oneIdx);
                zeroIdx++;
            }
        }


    }
    public static void swap(int [] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sortMod5(int [] a) {

            int idx = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = idx; j < a.length ; j++) {
                    if (a[j] % 5 == i){
                        swap(a, idx, j);
                        idx++;
                    }
                }
            }
    }

    public static boolean find1(int[] a, int [] b, int num) {

        for (int i=0; i<a.length; i++) {
            if (binarySearch(b, num - a[i]) != -1) {
                return true;
            }
        }
        return true;
    }

    public static boolean find2(int[] a, int [] b, int num) {
        int low = 0;
        int high = b.length - 1;

        while (low < a.length && high >=0) {
            if (a[low] + b[high] == num) // found
                return true;
            if (a[low] + b[high] < num) // need to enlarge the sum
                low++;
            else // need to reduce the sum
                high--;
        }

        return false;
    }

    public static int binarySearch(int [] a, int num) {
        int low = 0;
        int high = a.length;

        int mid;
        while (low <= high) {
            mid = (low + high ) / 2;
            if (a[mid] == num)
                return mid;

            if (a[mid] < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void printArr(int [] a) {
        for (int i=0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}

