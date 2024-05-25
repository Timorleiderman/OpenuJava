import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Ex13 {
    
    private static final int ALPHABET_LENGTH = 26;
    private static final int RECRUSION_DEPTH = 4000;
    /**
     * ********** Question 1 **********
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
     * ********** Question 1 **********
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
     * ********** Question 2 **********
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

    /**
     * it will call the private method to recrusivvly find the password
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @return password String found
     */
    public static String findPassword(Password p, int length){
        return findPassword(p, length, 0, -1);
    }

    /**
     * This method will call recrusivly the search index method with a counter parameter to count the number of calls
     * the counter is to prevent stck overflow for large strings
     * this code can only work with string up to 5 charecters 
     * for more charecters you will need to increese the stack size
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @param idx - string index represent the needed string to be generated
     * @param resIdx - index of the found Password string
     * @return password String found
     */
    private static String findPassword(Password p, int length, int idx, int resIdx) {
        if (resIdx != -1)
            return generatePassword(length, resIdx);

        int newResIdx = findPassword(p, length, generatePassword(length, idx), idx, 0);
        return findPassword(p, length, idx + RECRUSION_DEPTH + 1, newResIdx);
    }

    /**
     * 
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @param guess - password guess string
     * @param idx - index that represents the guess
     * @param cnt - counter to protect agains stuck overflow
     * @return index of the correct string
     */
    private static int findPassword(Password p, int length, String guess, int idx, int cnt) {
        // System.out.println("GUESS: " + guess + "  needs + " + p.getPassword());
        
        if (p.isPassword(guess)) 
            return idx;

        if (cnt >= RECRUSION_DEPTH)
            return -1;
        
        String nextGuess = generatePassword(length, idx + 1);
        return findPassword(p, length, nextGuess, idx+1, cnt+1);

    }

    /**
     * recrusive method to create string with the length given
     * for very large string it will have stuck overfow
     * @param length - length of the password
     * @param idx - index that represents the guess
     * @return string that represents the index
     */
    private static String generatePassword(int length, int idx) {
        if (length <= 0)
            return "";
        char suffix = (char) ('a' + idx % ALPHABET_LENGTH);
        return suffix + generatePassword(length - 1, idx / ALPHABET_LENGTH);
    }

}   
