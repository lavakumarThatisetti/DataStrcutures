package examples_others;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

class BinarySearchTree {
    // Fill this class as an implementation of binary search tree for the following methods 

    // Node class with int value and pointers to left and right child nodes
    class Node {
        int value;
        Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // Initialize root to null for empty binary search tree
    Node root;
    public BinarySearchTree() {
        root = null;
    }


/////////////////////////////////////////////////////////////////////////////////////////////

    /* Given an int value, create a new node in the correct place in our binary search tree.
    Use iterative approach to insertion, inserting 3, 1, 2, 5, 7, 0 would give 
       3
      /  \
     1    5
    /  \    \
    0   2    7.
    */
    void insert(int value) {
    	if (root == null) {
    		root = new Node(value, null, null);
            return;
    	}
        Node node = root;
        while (true) {
            if (value > node.value) {
                if(node.right == null){
                    node.right = new Node(value,null,null);
                    break;
                }
                node = node.right;
            } else if (value < node.value) {
                if(node.left == null){
                    node.left = new Node(value,null,null);
                    break;
                }
                node = node.left;
            } else {
                // Value is already in tree so no insertion
            	break;
            }
        }
    }

    
    
    
/////////////////////////////////////////////////////////////////////////////////////////////
    boolean search(int value) {
    	/* Search through binary search tree, starting from root, for value in O(height) time. 
        Return true if value exists in tree, false otherwise. */
        Node node = root;
        while (node != null) {
            if (value > node.value)
                node = node.right;
            else if (value < node.value)
                node = node.left;
            else
                return true;
        }
        return false;
    }



/////////////////////////////////////////////////////////////////////////////////////////////    
    void delete(int value) {
        /* Delete a value from binary search tree if it exists in the tree. For example:
                  3                                                             
                /  \
                1    5
                /  \    \
                0   2    7       
                with 1 deleted becomes:
                  3
                /  \
                2    5
                /     \
                0       7
        */
        // TODO: implement this function
        root = deleteHelper(root, value);
    }
    Node deleteHelper(Node root, int key)
    {
        if (root == null)
            return null;
        if (key < root.value)
            root.left = deleteHelper(root.left, key);
        else if (key > root.value)
            root.right = deleteHelper(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = minValue(root.right);
            root.right = deleteHelper(root.right, root.value);
        }
        return root;
    }
    int minValue(Node root)
    {
        int min = root.value;
        while (root.left != null)
        {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }



    /////////////////////////////////////////////////////////////////////////////////////////////
    ArrayList<Integer> postNodes = new ArrayList<Integer>();
    ArrayList<Integer> postorderTraversal() {
        /* Return the values of the tree in post-order: left-subtree, then right-subtree, then node. */ 
        // TODO: implement this function
        return postorderTraversal(root);
    }

    
    ArrayList<Integer> postorderTraversal(Node node) {
        Stack<Node> S = new Stack<>();
        if (node == null)
            return postNodes;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty())
        {
            Node current = S.peek();
            if (prev == null || prev.left == current ||
                    prev.right == current)
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    postNodes.add(current.value);
                }
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    postNodes.add(current.value);
                }
            }
            else if (current.right == prev)
            {
                S.pop();
                postNodes.add(current.value);
            }

            prev = current;
        }
        return postNodes;
    }



/////////////////////////////////////////////////////////////////////////////////////////////
    // Functions for inorder traversal are given for testing purposes
    ArrayList<Integer> inorderNodes = new ArrayList<Integer>();
    ArrayList<Integer> inorderTraversal() {
        /* Returns the values of the tree in increasing order. For
                  3                                                             
                /  \
                1    5
               /  \   \
              0   2    7     
        Returns [0, 1, 2, 3, 5, 7].
        */
        return inorderTraversal(root);
    }

    
    ArrayList<Integer> inorderTraversal(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                Node node = stack.pop();
                inorderNodes.add(node.value);
                p = node.right;
            }
        }
    	return inorderNodes;
    }
 
 
 /////////////////////////////////////////////////////////////////////////////////////////////
    int predecessor = -1;
    int predecessor(int value) {
        /* Given an integer, return the largest value in the binary search tree that it is greater than, or -1 if none exist.
        For
                  3                                                             
                /  \
                1    5
                /  \    \
                0   2    7    
        predecessor(5) = 3, predecessor(3) = 2, predecessor(0) = -1, predecessor(6) = 5
                */
        // TODO: implement this function
        predecessor = -1;
        predecessorHelper(root,value);
        return predecessor >= 0 ? predecessor : -1 ;
    }
    private void predecessorHelper(Node root, int val) {
        if (root != null) {
            if (root.value == val) {
                if (root.left != null) {
                    Node t = root.left;
                    while (t.right != null) {
                        t = t.right;
                    }
                    predecessor = t.value;
                }
            } else if (root.value > val) {
                predecessorHelper(root.left, val);
            } else {
                predecessor = root.value;
                predecessorHelper(root.right, val);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        BinarySearchTree insert1 = new BinarySearchTree();

        try {
            insert1.insert(5);
            insert1.insert(2);
            insert1.insert(7);
            insert1.insert(1);
            insert1.insert(3);
            insert1.insert(16);
            insert1.insert(8);
            insert1.insert(51);
            insert1.insert(22);
            insert1.insert(0);
            insert1.insert(100);
            insert1.insert(61);
            insert1.insert(18);
            for (int i = 0; i < 50; i++) {
                if (i % 2 == 0) {
                    insert1.insert(i + 10);
                } else if (i % 3 == 0) {
                    insert1.insert(5);
                } else {
                    insert1.insert(i * 4);
                }
            }
            FileWriter outFile = new FileWriter("output");
            for (int i = 0; i < 20; i++) {
                outFile.write(String.valueOf(insert1.search(i)));
                outFile.write(", ");
            }
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
