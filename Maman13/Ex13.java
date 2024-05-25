import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Ex13 {
    /**
     *  iterate over all elements worst case it will iterate all the elemtns
     *  int the best case it will iterate over the first two
     *  Time complexity O(n)
     *  Space complexity O(1)
     * @param a non empty input array with one integer that not appear twice in a row
     * @return the single int that was found
     */
    // public static int findSingle(int [] a) {
       
    //     for (int i = 0; i < a.length - 1; i += 2) {
    //         if (a[i] != a[i + 1]) {
    //             return a[i];
    //         }
    //     }
    //     return a[a.length - 1];
    // }

    /**
     *  like binery search compare even index if the even index and nex are the same the number is on the right
     *  if the even index and the next are not the same the number is on the left
     *  Time complexity O(log n)
     *  Space complexity O(1)
     * @param a non empty input array with one integer that not appear twice in a row
     * @return the single int that was found
     */
    public static int findSingle(int [] a) {
       
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid %2 == 1)
                mid--;
            
            if (a[mid] == a[mid+1])
                left = mid+2;
            else
                right = mid;
        }
        
        return a[left];
    }

    /**
     * this function will iterate for each tower finding the max tower to the left and to the right
     * then i will add to the total water sum the minimal tower found less the the hight of the current tower
     *  Time complexity O(n*n) = O(n^2)
     *  Space complexity O(1)
     * @param a array of towers hights positive integers non zero
     * @return water volume to fill
     */
    public static int waterVolume (int [] a){
        
        int leftMax;
        int rightMax;
        int water = 0;
        int minLeftRigth;
        for (int i = 1; i < a.length - 1; i++){
            leftMax = 0;
            rightMax = 0;
            
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(leftMax, a[l]);
            }

            for (int r = i+1; r < a.length; r++) {
                rightMax = Math.max(rightMax, a[r]);
            }

            minLeftRigth = Math.min(leftMax, rightMax);
            
            if (minLeftRigth > a[i]) {
                water = water + (minLeftRigth - a[i]);
            }
        }

        return water;
    }

    
    public static int cntTrueReg (boolean [][] a){
        return 1;
    }

    public static String findPassword(Password p, int length){
        return "";
    }

}   
