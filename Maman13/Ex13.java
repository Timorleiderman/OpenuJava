/**
 * Maman13 Exersize 
 * 
 * @author (Timor Leiderman) 
 * @version (2024)
 */


public class Ex13 {
    
    private static final int ALPHABET_LENGTH = 26;
    private static final int RECRUSION_DEPTH = 1024;
    private static final boolean BEEN_HERE = false;
    /**
     * ********** Question 1 **********
     *  like binery search compare even index if the even index and next index are the same the number is on the right side
     *  if the even index and the next index are not the same the number is on the left side
     *  
     *  Time complexity O(log n)
     *  Space complexity O(1)
     * 
     * @param a non empty input array with one integer that not appear twice in a row
     * @return the single int that was found
     */
    public static int findSingle(int [] a) {
       
        int left = 0;
        int right = a.length - 1;
        int mid;
        // two pointers
        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid % 2 == 1)
                mid--;
            
            if (a[mid] == a[mid+1])
                left = mid + 2; // move by two because we know that the next index is the same
            else
                right = mid;
        }
        
        return a[left];
    }

    /**
     * ********** Question 2 **********
     * 
     * this function will iterate for each tower finding the max tower to the left and to the right
     * then i will add to the total water sum the minimal tower found less the the hight of the current tower
     * 
     * Time complexity O(n*n) = O(n^2)
     * Space complexity O(1)
     * 
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
            // the smallest from the max from left or right will be the water level
            minLeftRigth = Math.min(leftMax, rightMax);
            
            if (minLeftRigth > a[i]) {
                // add the water level of the min max and subract current cell level
                water = water + (minLeftRigth - a[i]);
            }
        }

        return water;
    }

    /**
     * ********** Question 3 **********
     * it will call the private method to recrusivly find the password
     * The recrusive private method will try all english alphabet strings with the given length 
     * it will count the number of calls for the recrusion depth to prevent stack overflow
     * this code can only work with string up to 5 charecters 
     * for 6 charecter string you will need to run it with -Xss16m
     * for more charecters you will need to increese the stack size even more
     * 
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @return password String found
     */
    public static String findPassword(Password p, int length){
        return findPassword(p, length, 0);
    }

    /**
     * This method will call recrusivly and try all posible strings with the given length
     * here may be a stack overflow for large strings
     * Time complexity O(n) 
     * Space complexity O(1)
     * 
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @param idx - string index represent the needed string to be generated
     * @param resIdx - index of the found Password string
     * @return password String found
     */
    private static String findPassword(Password p, int length, int idx) {
        
        String guess = findPassword(p, length, idx, 0);
        if (guess.equals("0"))
            return findPassword(p, length, idx + RECRUSION_DEPTH);
        else
            return guess;  
    }

    /**
     * This method will call recrusivly and try all posible strings with the given length
     * the depth is to protect from stack overflow
     * 
     * @param p - Password .class object with isPassword method to check if the guess is correct
     * @param length - length of the password
     * @param guess - password guess string
     * @param idx - index that represents the guess
     * @param cnt - counter to protect agains stuck overflow
     * @return index of the correct string
     */
    private static String findPassword(Password p, int length, int idx, int depth) {
        
        if (depth > RECRUSION_DEPTH)
            return "0";
            
        String guess = generatePassword(length, idx);
        
        if (p.isPassword(guess)) 
            return guess;
    
        return findPassword(p, length, idx+1, depth+1);
    }

    /**
     * recrusive method to create string with the length given
     * for very large string it will have stuck overfow
     * 
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


     /**
     * ********** Question 4 **********
     * 
     * publlic method that will call the recrusive private method to count all the regions in the matrix
     * The recrusive method will go over all the matrix cells and will count and clear each region 
     * this method will change the value of each place in the matrix to false and will count when entering to a new region
     * 
     * Time complexity O(rows*columns) = O(n*n) = O(n^2)
     * Space complexity O(1)
     * 
     * @param a boolean matrix represents the regions
     * @return number of regions
     */
    public static int cntTrueReg(boolean [][] a){
        return cntTrueReg(a, 0, 0);
    }

    /**
     * @param a boolean matrix represents the regions
     * @param row row index
     * @param col column index
     * @param countFlag flag to count the specific index or not
     * @param count the number of regions
     * @return count
     */
    private static int cntTrueReg(boolean [][] a, int row, int col){

        // base case to exit when pass last row
        if (row == a.length)
            return 0;
        // go to next line if reached end of coulumn
        if (col == a[0].length)
            return cntTrueReg(a, row + 1, 0);
        // if true mark all neighbors and self to false, add one to recrusion and continue next to next cell
        if (a[row][col]) {
            cleanNeighbors(a, row, col);
            return 1 + cntTrueReg(a, row, col + 1);
        }

        return cntTrueReg(a, row, col + 1);
    }

    /**
     * recrusive method to mark current cell and all neighbor cells to false
     * this method will not check if the index are in range 
     * the caller to this method check if row and col are valid
     * 
     * @param a boolean matrix represents the regions
     * @param row row index
     * @param col column index
     */
    private static void cleanNeighbors(boolean [][] a, int row, int col) {

        a[row][col] = BEEN_HERE;
        // look up and dont count if connected
        if (row - 1 >= 0 && a[row - 1][col]) {
            cleanNeighbors(a, row - 1, col);
        }
        // look down and dont count if connected
        if (row + 1 < a.length && a[row + 1][col]) {
            cleanNeighbors(a, row + 1, col);
        }
        // look right and dont count if connected
        if (col - 1 >= 0 && a[row][col - 1]) {
            cleanNeighbors(a, row, col - 1);
        }
        // look left and dont count if connected
        if (col + 1 < a[0].length && a[row][col + 1]) {
            cleanNeighbors(a, row, col + 1);
        }
    }

}   
