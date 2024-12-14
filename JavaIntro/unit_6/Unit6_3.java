package unit_6;

public class Unit6_3 {

    public static void main(String [] args) {
        
        int[] arr = {1,2,3,4,5,6,7,8};
        printArr(arr);
        int [] arr1 = shiftRight(arr, 4);
        printArr(arr1);
        System.out.println(arr);
        System.out.println(arr1);
        
    }
    public static void printArr(int[] arr) {
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static int maxOddEvenSeq(int[] nums) {
        int maxCnt = 1;
        int curCnt = 1;

        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx]%2 == nums[idx-1]%2) {
                curCnt++;
                maxCnt = Math.max(maxCnt, curCnt);
            } else {
                curCnt = 1;
            }
        }

        return maxCnt;
    }

    public static int maxDifferent(int [] a) {
        int max = a[0];
        int min = a[0];

        for (int idx=1; idx<a.length; idx++) {
            if (a[idx] > max)
                max = a[idx];
            else if (a[idx] < min)
                min = a[idx];
        }
        return max - min;
    }

    public static double variance(int [] nums) {

        double sum = 0;

        for (int i=0; i < nums.length; i++) {
            sum += nums[i];
        }

        double avr = sum / nums.length;
        double var = 0;

        for (int i=0; i < nums.length; i++) {
            var += Math.pow(nums[i]- avr, 2);
        }

        return var / nums.length;
    }

    public static int [] shiftRight(int [] a) {
        int [] res = new int[a.length];
        for (int i=1; i < a.length; i++) {
            res[i] = a[i-1];
        }
        res[0] = a[a.length-1];
        return res;
    }

    public static int[] shiftRight(int [] a, int k) {
        int [] res = new int[a.length];

        for (int idx=k; idx<a.length; idx++) {
            res[idx] = a[idx-k];
        }
        for (int idx=0; idx<k; idx++){
            res[idx] = a[a.length - k + idx];
        }

        return res;
    }

}

