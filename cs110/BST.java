// Data structure to store a Binary Search Tree node
class Node
{
	int data;
	Node left, right;

	// Function to create a new binary tree node having given key
	Node(int key)
	{
		data = key;
		left = right = null;
	}
};

class BST
{
	// Function to perform inorder traversal of the tree
	public static void inorder(Node root)
	{
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Recursive function to insert an key into BST
    public static Node insert(Node root, Node newNode) {
        if (root == null) { 
            root = newNode;
        } else {
            if(root.data > newNode.data) {
                root.left = insert(root.left, newNode);
            } else {
                root.right = insert(root.right, newNode);
            }
        }
        return root;
        }
        
        

	// main function
	public static void main(String[] args)
	{
		Node root = new Node(10);
    insert(root, new Node(5));
    insert(root, new Node(3));
    insert(root, new Node(6));
    insert(root, new Node(1));
		inorder(root);
	}
}