package TestsEx.B96_2022;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BinaryTreeTest {

        @Test
        public void testMethods2() {
            // Construct the tree
            Node root = new Node(1);
            root._leftSon = new Node(2);
            root._rightSon = new Node(3);
            root._leftSon._leftSon = new Node(4);
            root._leftSon._rightSon = new Node(5);
            root._leftSon._leftSon._leftSon = new Node(6);
            root._leftSon._rightSon._rightSon = new Node(8);
            root._leftSon._rightSon._leftSon = new Node(7);
            root._leftSon._rightSon._leftSon._rightSon = new Node(9);


            Node root2 = new Node(1);
            root2._leftSon = new Node(2);
            root2._rightSon = new Node(3);
            root2._leftSon._leftSon = new Node(4);
            root2._leftSon._rightSon = new Node(5);
            root2._leftSon._leftSon._leftSon = new Node(6);
            root2._leftSon._rightSon._leftSon = new Node(7);
            root2._rightSon._rightSon = new Node(8); // Moved node 8 here
            root2._leftSon._rightSon._leftSon._rightSon = null; // Removed node 9



            // Test f method

            int isF = BinaryTree.f(root);
            assertEquals(isF, 5);

            // Test secret method for original tree
            boolean isSecret = BinaryTree.secret(root);
            assertFalse(isSecret);

            // Test secret method for new tree
            boolean isSecret2 = BinaryTree.secret(root2);
            assertTrue(isSecret2);


            int[] a = {-3,2,4,8};
            // Test what method
            Node total_nodes = BinaryTree.what(a);
            assertEquals(total_nodes.getNumber(), 2);



        }



    }

