package unit_6;

public class Unit6_3 {

    public static void main(String [] args) {
        
        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println(maxOddEvenSeq(arr));
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
}

