public class StudentsTester
{
    public static void main(String [] args)
    {
        System.out.println("\n\n=========  Question 1 =========\n\n");
        IntListTwo l1 = new IntListTwo();
        l1._head = null;
        l1.addToEnd(15);
        l1.addToEnd(19);
        l1.addToEnd(21);
        l1.addToEnd(13);
        l1.addToEnd(14);
        l1.addToEnd(30);
        l1.addToEnd(23);
        l1.addToEnd(16);

        System.out.println(l1.toString());
        int tempI = l1.win();

        System.out.println(tempI);
        
        System.out.println("\n\n=========  Question 2 =========\n\n");
        
        boolean tempB = l1.what(1);
        tempB = l1.what(15);
        tempB = l1.what(57);
        tempB = l1.what(82);

        tempB = l1.betterWhat(1);
        tempB = l1.betterWhat(15);
        tempB = l1.betterWhat(57);
        tempB = l1.betterWhat(82);

        IntListTwo l2 = new IntListTwo();
        l2._head = null;
        l2.addToEnd(10);

        tempI = l1.longestCommonSublist(l2);
        tempI = l1.maxEqualValue();

        System.out.println("====================");
    
    }
}
