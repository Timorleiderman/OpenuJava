/**
 * Maman14 Exercise 
 * 
 * @author (Timor Leiderman) 
 * @version (2024)
 */

public class IntListTwo
{
    IntNodeTwo _head, _tail;
    // שימו לב ! בכוונה, ובניגוד למה שלמדתם בקורס,
    // לא הגדרנו את שתי התכונות הללו כ-private.
    // הסיבה לכך היא לצורך הבדיקה שלנו את העבודה שלכם.
    // השאירו הגדרה זאת כפי שהיא ואל תשנו אותה !

    /**
     * Empty constructor initialize _head and _tail to null
     */
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * adds a new node to the end of the list where its value is the received number
     * @param num - integer
     */
    public void addToEnd (int num) {

        IntNodeTwo newNode = new IntNodeTwo(num);
        if (_head == null) { // List empty, new node is new head
            _head = newNode;
            _tail = newNode;
        }
        else {
            newNode.setPrev(_tail);
            _tail.setNext(newNode);
            _tail = newNode;
        }
    }

    //the method return a String that represents the list
    /**
     * Returns a String that represents the list
     * @return a String that represents the list in the print format:
     * {first value, second before, ..., last value}
     */
    public String toString()
    {
        //if the list is empty return empty parentheses
        if(_head == null)
            return "{}";

        //opening parenthesis
        String s = "{";
        IntNodeTwo temp = _head;

        //for each node return its value and + ", "
        while (temp != _tail)
        {
            s += temp.getNum() + ", ";
            temp = temp.getNext();
        }

        //the last and closing parenthesis
        s += _tail.getNum() + "}";
        return s;
    }

    /**
     * calculate the length of the list
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * @return the length of the liked list
     */
    public int size()
    {
        IntNodeTwo temp;
        int result;
        for (temp = _head, result = 0;
        temp != null;
        result++, temp = temp.getNext());
        return result;
    }

    /**
     * 
     * the strategy is to calculate the sum of the even and the sum of the odd and take the bigger one
     * if we mark all even nodes in black and all odd ones in white 
     * if the first player starts from the right (took the odd coin) the second player can take only the second and the 2*n coin
     * so the strategy will be to take all the even or all the odds
     * for wining the first needs to take the bigger sum of even or odds indexes 
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * 
     * @return the absolute difference between the odd sum and the even sum
     */
    public int win()
    {
        if (_head == null)
            return 0; // list is empty

        int oddSum = 0;
        int evenSum = 0;
        IntNodeTwo node = _head;
        // list must be 2*n length
        while (node != null) { // calculate the even sum and the odd sum
            evenSum += node.getNum();
            oddSum += node.getNext().getNum();
            node = node.getNext().getNext();
        } // here we already know the winner but lets print it to stdout

        playWin(oddSum, evenSum);
        return Math.abs(evenSum - oddSum);
    }
    /**
     * prints to stdout the game
     * 
     *  Time complexity O(n)
     * Space complexity O(1)
     * 
     * @param oddSum sum of the odd nodes in the list
     * @param evenSum sum of all the even nodes in the list
     */
    private void playWin(int oddSum, int evenSum) {
        IntNodeTwo left = _head;
        IntNodeTwo right = _tail;
        boolean even = evenSum > oddSum;

        while (left.getPrev() != right || right.getNext() != left) {

            if (even) {
                System.out.println("Amir Took " + left.getNum());
                left = left.getNext();
            }
            else {
                System.out.println("Amir Took " + right.getNum());
                right = right.getPrev();
            }

            if (left.getNum() > right.getNum())
            {
                System.out.println("Tamar Took " + left.getNum());
                left = left.getNext();
            }
            else
            {
                System.out.println("Tamar Took " + right.getNum());
                right = right.getPrev();
            }
        }

        System.out.println("Final Score:");
        if (even) {
            System.out.println("Amir total: " + evenSum);
            System.out.println("Tamar total: " +  oddSum);
        } else {
            System.out.println("Amir total: " + oddSum);
            System.out.println("Tamar total: " + evenSum);
        }
    }

    /**
     * Calculate the sum from low node to high
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * @param low index of the node from where to start summing
     * @param high index fo the node to stop summing
     * @return the sum from node low to high
     * 

     */
    private int f(int low, int high)
    {
        int result = 0;
        IntNodeTwo temp = _head;
        for (int i = 0; i < low; i++)
            temp = temp.getNext();
        for (int j = low; j <= high; j++)
        {
            result += temp.getNum();
            temp = temp.getNext();
        }
        return result;
    }

    /**
     * finds the sum of a sub linked list that will sum to num
     * if it finds the sum equal to num it will print to stdout
     * between ## and ##
     * otherwise it will print 
     * No 
     * Time complexity O(n^3)
     * Space complexity O(1)
     * 
     * @param num the sum of the sub linked list to search
     * @return true if found a sub linked list with sum equal to num
     */
    public boolean what(int num)
    {        
        int listSize = size();
        for (int i = 0; i < listSize; i++)
        {
            for (int j = i; j < listSize; j++)
            {
                if (f(i, j)  == num)
                {
                    System.out.println("between " + i + " and " + j);
                    return true;
                }
            }
        }
        System.out.println("No ");
        return false;
    }

    /**
     * finds the sum of a sub linked list that will sum to num
     * if it finds the sum equal to num it will print to stdout
     * between ## and ##
     * otherwise it will print 
     * No 
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * @param num the sum of the sub linked list to search
     * @return true if found a sub linked list with sum equal to num
     */
    public boolean betterWhat (int num)
    {
        IntNodeTwo begin =_head;
        IntNodeTwo end = _head;

        int currentSum = 0;
        int i = 0;
        int j = 0;
        int jj = 0;

        while (begin != _tail && end != null) {

            while (currentSum > num && begin != _tail) {
                // if current sum is bigger then we need 
                // to move the begin pointer and subtract it from the sum
                currentSum -= begin.getNum();
                begin = begin.getNext();
                i++;
            }

            if (currentSum == num) {
                // found
                jj = j -1;
                System.out.println("between " + i + " and " + jj);
                return true;
            }

            currentSum += end.getNum();
            end = end.getNext();
            j++;

        }
        System.out.println("No ");
        return false;
    }
    
    /**
     * this will call the recursive method to find the longest common sub list
     * the sub list don't have to be consecutive
     * @param list2 the linked list to compare to
     * @return the length of the longest sub list
     */
    public int longestCommonSublist(IntListTwo list2)
    {
        return longestCommonSublist(_head, list2._head, _head);
    }

    /**
     * recursive method to find to longest sub list with 3 pointers
     * the first pointer is a pointer to the first linked list
     * the second pointer is a pointer to the second linked list
     * we compare first two values of the linked list if they are the same so we move all pointers to the next cell
     * if they are not the same we will move only the first pointer until we reach to the end
     * when the first pointer reaches the end we need to go back to the reference pointer and move the second pointer to the next cell
     * each time the pointers are equal it will accumulate the value and recursively call again
     * @param node1 the first linked list
     * @param node2 the second linked list
     * @param node1Ref the reference to the first linked list
     * @return the length of the sub linked list
     */
    private int longestCommonSublist(IntNodeTwo node1, IntNodeTwo node2, IntNodeTwo node1Ref)
    {
        // write your code here
        if (node2 == null || node1Ref == null)
            return 0;

        if (node1 == null) {
            // reached to the end of the first list now need to go back to ref and move node2 next
            return longestCommonSublist(node1Ref, node2.getNext(), node1Ref.getNext());
        }

        if (node1.getNum() == node2.getNum()) // found move all
            return 1 + longestCommonSublist(node1.getNext(), node2.getNext(), node1.getNext());

        return longestCommonSublist(node1.getNext(), node2, node1Ref);
    }

    /**
     * the method will calculate the longest consecutive list with equal values
     * it will call the private recursive method
     * @return longest consecutive sub list length
     */
    public int maxEqualValue()
    {
        return maxEqualValue(_head.getNext(), _head.getNum(), 1, 1);
    }

    /**
     * recursive method to calculate the max consecutive sub list
     * 
     * @param node current working node
     * @param val the current value to compare
     * @param cnt current counter
     * @param max the max value until this point 
     * @return the max
     */
    private int maxEqualValue(IntNodeTwo node, int val, int cnt, int max)
    {
        if (node == null)
            return max;

        if (node.getNum() == val) { // found
            cnt ++;
            max = Math.max(max, cnt);
            return maxEqualValue(node.getNext(), val, cnt, max);
        }

        return maxEqualValue(node.getNext(), node.getNum(), 1, max);

    }
}
