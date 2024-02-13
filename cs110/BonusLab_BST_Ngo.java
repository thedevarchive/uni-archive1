import java.util.Scanner; 

public class BonusLab_BST_Ngo
{
    //the Node class
    //holds an integer and pointers to the children
    public static class Node
    {
        int key; 
        Node leftChild; 
        Node rightChild; 

        //node constructor. makes a new node with the indicated key
        //left and right pointers start out as null
        public Node(int k)
        {
            this.key = k; 
            leftChild = null; 
            rightChild = null; 
        }
    }

    //declare array and iterator to be used in the storing the nodes
    public static int[] tree; 
    public static int count = 0; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        //count number of cases
        int cases = 1; 
        while(sc.hasNextInt())
        {
            //create root node
            Node root = null; 

            int nums = sc.nextInt();
            //create an array to store the node keys traversed 
            tree = new int[nums]; 
            //initialize the root node, then insert the rest of the ints that the user inputted in the node 
            for(int i = 0; i < nums; i++)
            {
                if(i == 0) root = new Node(sc.nextInt()); 
                else insert(new Node(sc.nextInt()), root); 
            }
            //traverse nodes
            preOrder(root); 
            //print the node keys traversed in preorder
            System.out.print("Test case #" + cases + ": "); 
            for(int i = 0; i < nums; i++)
            {
                System.out.print(tree[i]); 
                if(i == nums - 1) System.out.println(); 
                else System.out.print(" "); 
            }
            //reset iterator and increment cases
            count = 0; 
            cases++; 
        }
    }

    //inserts node into tree via the root
    //returns the updated root 
    public static Node insert (Node newNode, Node root) 
    {
        if(root == null) root = newNode; 
        else
        {
            if (newNode.key < root.key) root.leftChild = insert(newNode, root.leftChild); 
            else root.rightChild = insert(newNode, root.rightChild); 
        }
        return root; 
    }

    //traverses tree in preorder fashion
    //for every visit, store the key of each node in an array 
    public static void preOrder(Node root)
    {
        tree[count] = root.key; 
        count++; 
        if(root.leftChild != null) preOrder(root.leftChild);
        if(root.rightChild != null) preOrder(root.rightChild); 

    }
}