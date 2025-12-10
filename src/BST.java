import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchHelper(val, root);
    }

    // Search helper function
    public boolean searchHelper(int val, BSTNode root){
        // Base case 1: if the val is not in the tree
        if (root == null){
            return false;
        }
        // Base case 2: if val is equal to the root value of this smaller tree
        if (val == root.getVal()){
            return true;
        }
        // If the value is less than the root - go to the left
        else if (val < root.getVal()){
            return searchHelper(val, root.getLeft());
        }
        // If the value is greater than the root - go to the right
        else if (val > root.getVal()){
            return searchHelper(val, root.getRight());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> order = new ArrayList<>();
        inOrderHelper(root, order);
        return order;
    }

    // In order helper function
    public void inOrderHelper(BSTNode node, ArrayList<BSTNode> order){
        // If there is no node then nothing to do
        if (node == null){
            return;
        }
        // Trust that it will return inorder of left side
        inOrderHelper(node.getLeft(), order);
        // Get root
        order.add(node);
        // Trust that it will return inorder of right side
        inOrderHelper(node.getRight(), order);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> order = new ArrayList<>();
        preOrderHelper(root, order);
        return order;
    }

    // Preorder helper
    public void preOrderHelper(BSTNode node, ArrayList<BSTNode> order){
        if (node == null){
            return;
        }
        // Get root first
        order.add(node);
        // Trust that it will return preorder of left side
        preOrderHelper(node.getLeft(), order);
        // Trust that it will return preorder of right side
        preOrderHelper(node.getRight(), order);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> order = new ArrayList<>();
        postOrderHelper(root, order);
        return order;
    }

    public void postOrderHelper(BSTNode node, ArrayList<BSTNode> order){
        if (node == null){
            return;
        }
        // Trust that it will return postorder of left side
        postOrderHelper(node.getLeft(), order);
        // Trust that it will return postorder of right side
        postOrderHelper(node.getRight(), order);
        // Add root last
        order.add(node);
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        root = insertHelper(val, root);
    }

    public BSTNode insertHelper(int val, BSTNode root){
        // If the value is already in the tree don't insert
        if (search(val)){
            return root;
        }
        // If there is no root
        if (root == null){
            // Create the new node
            BSTNode node = new BSTNode(val);
            return node;
        }
        // If val is less than root
        else if (val < root.getVal()){
            // Go to the smaller left tree and trust that the function will insert the value correctly
            root.setLeft(insertHelper(val,root.getLeft()));
        }
        // If val is greater than root
        else if (val > root.getVal()){
            // Go to the smaller right tree and trust that the function will insert the value correctly
            root.setRight(insertHelper(val, root.getRight()));
        }
        return root;
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

    }
}
