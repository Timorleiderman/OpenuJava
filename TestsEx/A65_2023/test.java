package TestsEx.A65_2023;

public class test {
    
    public static void main(String [] args) {
        System.out.println("Hey");
        System.out.println(countPairs(3));

        System.out.println(superInc(new int[]{2,3,8,27}, 30));
        System.out.println(superInc(new int[]{2,3,8,27}, 29));
        System.out.println(superInc(new int[]{2,4,8,27},7));
        System.out.println(superInc(new int[]{2,4,8,27},5));
        System.out.println(superInc(new int[]{2,4,8,27},2));
        System.out.println(superInc(new int[]{2,4,8,27},8));
    }

    public static int countPairs (int n) {
        if (n < 1)
            return 0;
        
        return countPairs(n, 0, 0, "");
    }

    private static int countPairs (int n, int left, int rigth, String out) {
        if (left == n && rigth == n) {
            System.out.println(out);
            return 1;
        }

        int cnt = 0;
        if (left < n)
            cnt += countPairs(n, left+1, rigth, out + "{");

        if (left > rigth) 
            cnt += countPairs(n, left, rigth+1, out + "}");

        return cnt;
    }

    public static boolean superInc(int [] arr, int k) {

        int sum = k;

        for (int i=arr.length-1; i>=0 ; i--) {
            if (sum >=arr[i])
                sum -= arr[i];

            if (sum == 0)
                return true;
        }

        return false;
    }
}
