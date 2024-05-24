

public class Ex13Tester
{
    public static void main(String[] args){
        System.out.println ("********** Question 1 **********\n");
        int[] array1 = {6, 6, 18, 18, -4, -4, 12, 9, 9};
        int[] array2 = {2, 1, 1, 4, 4, 5, 5, 3, 3};
        System.out.println(Ex13.findSingle(array1));
        System.out.println(Ex13.findSingle(array2));

    }

    public static void printMat(boolean [][]mat){
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++)
                if(mat[i][j]== true)
                    System.out.print("1\t");
                else
                    System.out.print("0\t");
            System.out.println();
        }
    }

}

