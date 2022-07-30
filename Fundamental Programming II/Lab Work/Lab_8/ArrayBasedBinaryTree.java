/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 5;
    protected Integer[] data;
    protected int root;
    protected int size;
    
	public ArrayBasedBinaryTree() {
		// TODO...
		// allocate space for data array.
		// What index are you choosing the root to be?
		// initialize your size as the number of elements in the empty tree
		data = new Integer[CAPACITY];
		root = 0;
		size = 0;
	}

	/*
	 * Purpose: inserts the given value into data at next available
	 *  position in a level-order traversal
	 *  The tree remains complete after insertion.
	 * Parameters: Integer value - value to insert
	 * Returns: nothing
	 */
	public void insert(Integer value) {
		// TODO...
		// NOTE: The underlying data structure is an array,
		//  but we are just USING the array to store the data.
		//  The way we traverse the data will expose its binary tree structure
	if(size>= CAPACITY){
		expandAndCopy();
	}

	data[size]=value;
	size++;
	}

	protected void expandAndCopy() {
		Integer[] newData = new Integer[data.length*2];
		for(int i=0; i<data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/*
	 * Purpose: calculates and returns the index of t's left child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of left child
	 */
	protected int getLeft(int t) {
	
		return t*2+1;
	}

	/*
	 * Purpose: calculates and returns the index of t's right child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of right child
	 */
	protected int getRight(int t) {
		return t*2+2;
	}


	public void inOrder(){
		if(size == 0){
			return;
		}

	inOrderRec(0);//root
	System.out.println("");
		
}

	public void inOrderRec(int index){
		if(index>= size){
			return;
			}

		inOrderRec((2*index)+1);
		System.out.print(data[index]+" ");
		inOrderRec((2*index)+2);
		
		


		
}
	


	public void preOrder(){
		if(size == 0){
			return;
		}

	preOrderRec(0);//root -0 based
	System.out.println("");

	}

	public void preOrderRec(int index){

		if(index>= size){
			return;
			}
		
		System.out.print(data[index]+" ");
		preOrderRec((2*index)+1);
		preOrderRec((2*index)+2);
	
	
	}


	public void postOrder(){
		if(size == 0){
			return;
		}

	postOrderRec(0); // root = 0 
	System.out.println("");
	}

	public void postOrderRec(int index){
	
		if(index>= size){
			return;
			}
		
		postOrderRec((2*index)+1);
		postOrderRec((2*index)+2);
		System.out.print(data[index]+" ");
		
		
	
	}


	public int height() {
		return height(root); //0
	}

	/*
	 * Purpose: computes and returns the height of a 
	 *          binary tree rooted at index t 
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 * NOTE: a BinaryTree with no nodes is height -1
	 *       a BinaryTree with just a root is height 0
	 *
	 *       the height of a node in a tree is equal to 
	 *       1 + the height of its largest subtree
	 */
	protected int height(int t) {
		if (t>= 0) {
            return 0;
        } 
		// TODO: complete the rest
		int left_size = 0;
		int right_size = 0;

		while(left_size < size){
			left_size = left_size*2+1;
		}

		while(right_size < size){
			right_size = right_size*2+2;
		}

		if(left_size > right_size){
			return 1+ left_size;
		}
		else{
		return 1+ right_size; // so it compiles
		}
		
	}
	

	/*
	 * Purpose: returns a String reprensentation of a in-order traversal
	 *     of this ArrayBasedBinaryTree
	 * Parameters: none
	 * Returns: String - the representation
	 */
	// written for you - do not change
	// NOTICE: we use the helper methods to get the index of the left/right
	//   children of the current position in the tree.
	// This method will not work until you have completed those methods correctly.
	public String toString() {
		return toString(root);
	}

	private String toString(int t) {
        if (t >= size) {
            return "";
        } 
        String s = "";
        s += toString(getLeft(t));
        s += data[t] + " ";
        s += toString(getRight(t));

        return s;
	}

	public static void main(String[] args) {
		
		ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
		for(int i=2; i<8; i++) {
			myTree.insert(i);
			//System.out.println(myTree);
			//System.out.println("I value added "+i);
		}
		System.out.println("in");
		myTree.inOrder();
		System.out.println("pre");
		myTree.preOrder();
		System.out.println("post");
		myTree.postOrder();
		
		System.out.println("toString\n" + myTree);
	}
    
}
