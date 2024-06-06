/**
 * Maman14 Exersize 
 * 
 * @author (Timor Leiderman) 
 * @version (2024)
 */

public class IntListTwo
{
    IntNodeTwo _head, _tail;
    // ���� �� ! ������, ������� ��� ������ �����,
    // �� ������ �� ��� ������� ���� �-private.
    // ����� ��� ��� ����� ������ ���� �� ������ ����.
    // ������ ����� ��� ��� ���� ��� ���� ���� !

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
     * @return a String that represents the list in the fprmat:
     * {first value, seconed bofore, ..., last value}
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
     * for wining the first needs to take the bigger sum
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * 
     * @return the difference betwen the odd sum and the even sum
     */
    public int win()
    {
        return Math.abs(sumSkip(_head) - sumSkip(_head.getNext()));
    }

    /**
     * 
     * this method will calculate the sum of all nodes but will skip one each time
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * @param node the node to start from
     * @return the sum of all nodes when skips one each time
     */
    private int sumSkip(IntNodeTwo node) {

        if (node == null)
            return 0;

        int sum = node.getNum();
        IntNodeTwo temp = node;
        // will skip a single element each time
        while (temp != null && temp.getNext() != null) {
            sum += temp.getNum();
            temp = temp.getNext().getNext();
        }

        return sum;
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
    private int f (int low, int high)
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
     * n + (n-1) + (n-2) .... 1 = n * ( n + 1 ) / 2
     * Time complexity O(n*n) = O(n^2)
     * Space complexity O(1)
     * 
     * @param num the sum of the sub linked list to search
     * @return true if found a sub linked list with sum equal to num
     */
    public boolean what (int num)
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
                // if currecnt sum is bigger then we need 
                // to move the begin pointer and subract it from the sum
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
     * this will call the recrusive method to find the longest common sub list
     * the sub list dont have to be consecutive
     * @param list2 the linked list to compare to
     * @return the length of the longest sub list
     */
    public int longestCommonSublist(IntListTwo list2)
    {
        return longestCommonSublist(_head, list2._head, _head);
    }

    /**
     * recrusive method to find to longest sub list with 3 pointers
     * the first pointer is apointer to the first linked list
     * the seconf pointer is a pointer to the second likned list
     * we compare first two values of the linked list if they are the same so we move all pointers to the next cell
     * if they are not the same we will move only the first pointer until we reach to the end
     * when the first pointer reches the end we need to go back to the refrence pointer and move the second pointer to the next cell
     * each time the pointers are equal it will accumulate the value and recrusivly call again
     * @param node1 the first linked list
     * @param node2 the second linked list
     * @param node1Ref the refernce to the first linked list
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
     * it will call the private recrusive method
     * @return longest consecutive sub list length
     */
    public int maxEqualValue()
    {
        return maxEqualValue(_head.getNext(), _head.getNum(), 1, 1);
    }

    /**
     * recrusive method to calculate the max consecutive sub list
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
