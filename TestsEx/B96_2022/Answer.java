package TestsEx.B96_2022;

public class Answer {
    
    public static void main(String[] args) {
        
        System.out.println("\n\n=========== Question 1 ===============\n\n");

        int temp = calc(3, 36, 4);
        if (temp != 3)
            System.out.println("Somthing went wrong with 3,36,4");
        temp = calc(5,50,4);

        if (temp != 7)
            System.out.println("Somthing went wrong, 5,50,4");
        
        System.out.println("\n\n=========== Question 2 ===============\n\n");

        int [] arr = {3,0,0,4,7,9,0,0,0,0,11,15,0,19,20,0,0,31,40,0};
        System.out.println(searchAlmostKSorted(arr, 9)); // output: 5
        System.out.println(searchAlmostKSorted(arr, 31)); // output: 17
        System.out.println(searchAlmostKSorted(arr, 30)); // output: -1

        int [] arr2 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(searchAlmostKSorted(arr2,1)); // output: 0

        int [] arr3 = {0,0,0,0,0,0,0,0};
        System.out.println(searchAlmostKSorted(arr3,1)); // output: -1

        System.out.println("Done ... ");
    }


    public static int calc(int num, int result, int maxOp){

        return calc(num, result, maxOp, "" + num, num);
    }


    private static int calc(int num, int result, int maxOp, String str, int currentValue) {

        if (maxOp < 0) 
            return 0;

        
        if (currentValue == result) {
            System.out.println(str + " = " + result);
            return 1;
        }
        

        int total = 0;
        total += calc(num, result, maxOp - 1, str + " + " + num, currentValue + num) + 
            calc(num, result, maxOp - 1, str + " - " + num, currentValue - num) +
            calc(num, result, maxOp - 1, str + " * " + num, currentValue * num) +
            calc(num, result, maxOp - 1, str + " / " + num, currentValue / num);
            
        
        return total;
        
    }





    public static int searchAlmostKSorted(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = ( left + right ) / 2;
            if (arr[mid] == num)
                return mid; // found num
            
            if (arr[mid] != 0) { // not 0 then treat it like regular binery search
                if (arr[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // zero

                int midLeft = mid - 1;
                int midRight = mid + 1;
                while (midLeft > left && arr[midLeft] == 0) {
                    midLeft--;
                }
                while (midRight < right && arr[midRight] == 0 ) {
                    midRight++;
                }

                if (midLeft < left || (midRight <= right && Math.abs(arr[midLeft] - num) > Math.abs(arr[midRight] - num))) {
                    left = midRight;
                } else {
                    right = midLeft;
                }

            }

            
        }

        return -1;
    }



}

