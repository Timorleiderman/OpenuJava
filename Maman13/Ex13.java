

public class Ex13 {

    public static int findSingle (int [] a){
        
        for (int i = 0; i < a.length - 1; i += 2) {
            if (a[i] != a[i + 1]) {
                return a[i];
            }
        }
        return a[a.length - 1];
    }

    // public static String findPassword (Password p, int i){
    //     return "";
    // }

    public static int waterVolume (int [] a){
        return 1;
    }

    
    public static int cntTrueReg (boolean [][] a){
        return 1;
    }


}   
