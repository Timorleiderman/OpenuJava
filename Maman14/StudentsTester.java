public class StudentsTester
{
    public static void main(String [] args)
    {
        System.out.println("\n\n=========  Question 1 =========\n\n");
        
        IntListTwo l0 = new IntListTwo();
        l0._head = null;
        l0.addToEnd(15);
        l0.addToEnd(19);
        l0.addToEnd(21);
        l0.addToEnd(13);
        l0.addToEnd(14);
        l0.addToEnd(30);
        l0.addToEnd(23);
        l0.addToEnd(16);
        
        int tempA = l0.win();
        if (tempA == 7)
            System.out.println("Correct");
        else
            System.out.println("Somthing went wrong with l0 win this shouldent be " + tempA);
        
        System.out.println("\n\n=========  Question 2 =========\n\n");
        
        boolean tempB;
        tempB = l0.what(1);
        if (tempB)
            System.out.println("Somthing went wrong with 1");
        else
            System.out.println("Correct");

        tempB = l0.what(15);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 15");

        tempB = l0.what(57);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 57");

        tempB = l0.what(82);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 82");

        tempB = l0.betterWhat(1);
        if (tempB)
            System.out.println(" Somthing went wrong with 1");
        else
            System.out.println("Correct");

        tempB = l0.betterWhat(15);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 15");

        tempB = l0.betterWhat(57);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 57");

        tempB = l0.betterWhat(82);
        if (tempB)
            System.out.println("Correct");
        else
            System.out.println(" Somthing went wrong with 82");


        System.out.println("\n\n=========  Question 3 =========\n\n");

        IntListTwo l1 = new IntListTwo();
        IntListTwo l2 = new IntListTwo();
        IntListTwo l3 = new IntListTwo();
        IntListTwo l4 = new IntListTwo();

        // L1
        l1.addToEnd(1);
        l1.addToEnd(2);
        l1.addToEnd(-3);
        l1.addToEnd(4);
        l1.addToEnd(5);
        l1.addToEnd(-6);
        l1.addToEnd(7);
        l1.addToEnd(8);
        l1.addToEnd(9);

        // L2
        l2.addToEnd(2);
        l2.addToEnd(-3);
        l2.addToEnd(10);
        l2.addToEnd(0);
        l2.addToEnd(-15);
        l2.addToEnd(-6);
        l2.addToEnd(8);

        // L3
        l3.addToEnd(-15);
        l3.addToEnd(10);
        l3.addToEnd(4);

        // L4
        l4.addToEnd(-56);
        l4.addToEnd(156);
        l4.addToEnd(-12);


        int tempC;
        tempC = l1.longestCommonSublist(l2);
        if (tempC == 4)
            System.out.println( "L1 with L2 correct");
        else
            System.out.println( "L1 with L2 wrong not " + tempC);

        tempC = l2.longestCommonSublist(l3);
        if (tempC == 1)
            System.out.println( "L2 with L3 correct");
        else
            System.out.println( "L3 with L3 wrong not " + tempC);

        tempC = l4.longestCommonSublist(l1);
        if (tempC == 0)
            System.out.println( "L4 with L1 correct");
        else
            System.out.println( "L4 with L1 wrong not " + tempC);

        tempC = l4.longestCommonSublist(l2);
        if (tempC == 0)
            System.out.println( "L4 with L2 correct");
        else
            System.out.println( "L4 with L2 wrong not " + tempC);

        tempC = l4.longestCommonSublist(l3);
        if (tempC == 0)
            System.out.println( "L4 with L3 correct");
        else
            System.out.println( "L4 with L3 wrong not " + tempC);


        System.out.println("\n\n=========  Question 4 =========\n\n");


        tempC = l1.maxEqualValue();

        System.out.println("====================");
    
    }
}
