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

    public boolean betterWhat (int num)
    {
        IntNodeTwo start = _head;
        IntNodeTwo end = _head;
        int currentSum = 0;
        int i = 0;
        int j = 0;
        
        while (end != null) {
            currentSum += end.getNum();

            while (currentSum > num && start != end) {
                currentSum -= start.getNum();
                start = start.getNext();
                i++;
            }

            if (currentSum == num) {
                System.out.println("between " + i + " and " + j);
                return true;
            }
            
            end = end.getNext();
            j++;
                
        }

        System.out.println("No ");
        return false;
    }
    
    public int longestCommonSublist(IntListTwo list2)
    {
        // write your code here
        return 0;
    }

    public int maxEqualValue()
    {
        // write your code here
        return 0;
    }
}
