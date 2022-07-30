public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

    public void insert(Integer value) {
      int i = 0;
    
      boolean added = true;
    while(added){

          if(data[i]==null){
              data[i] = value;
              size++;
                added = false;
        }

        if(value.compareTo(data[i]) < 0){
            i = i*2+1;}
    else{
     i = i*2+2;
 }

    }

    }

    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
