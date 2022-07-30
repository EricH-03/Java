import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
            return;
        } 
        else{
            insert(value, root);
            return;
        }
        
    }
		

    public TreeNode insert(Integer value, TreeNode l) {
        if (l==null) {
            l = new TreeNode(value);
            return l;
        }

        if(value < l.data){
            l.left = insert(value, l.left);
        }

        else{
            l.right = insert(value, l.right);
        }
        return l;
    }

    public boolean find(int value){
        return find(value,root);
    }


    private boolean find(int value, TreeNode t) {
       if(t == null){
        return false;}

        if(t.getValue() == value){
            return true;
        } 
       
        if(t.getValue() > value){
            boolean left = find(value, t.left);
            return left;
        }
       else{
            boolean right = find(value, t.right);
            return right;
        }
        
    }

    public int getMax() throws TreeEmptyException{
        return getMax(root, 0);
    }

    private int getMax(TreeNode t, int max) throws TreeEmptyException {
        if(root == null){
            throw new TreeEmptyException();
        }
        if(t == null){
            return max;
        }

        while(t.right != null){
            t = t.right;
        }
        
        return t.getValue();

       
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);

        System.out.println(myTree.find(6) + " Should be true");
        System.out.println(myTree.find(99) + " Should be false");

        try{
            System.out.println(myTree.getMax() + " Should be 7");
        }
        catch(TreeEmptyException e){
            System.out.println("Whoops exception thrown");
        }
    }
}
