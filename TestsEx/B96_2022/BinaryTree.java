
package TestsEx.B96_2022;

public class BinaryTree {



    public static int f(Node root){

        if(root == null){
            return 0;
        }

        int left = f(root.getLeftSon());
        int right = f(root.getRightSon());

        return 1 +(left>right ? left:right);
    }



    public static boolean secret(Node root){

        if(root == null){
            return true;
        }

        int a = f(root.getLeftSon());
        int b = f(root.getRightSon());

        return Math.abs(a-b) <= 1 &&
                secret(root.getLeftSon()) &&
                secret(root.getRightSon());
    }


    public static Node what (int arr[])
    {
        return what(arr, 0, arr.length-1);
    }


    private static Node what(int arr[], int k, int j)
    {
        if (k > j)
            return null;
        int m = (k + j) / 2;
        Node node = new Node(arr[m]);
        node.setLeftSon(what(arr, k, m - 1));
        node.setRightSon(what(arr, m + 1, j));
        return node;
    }



}


