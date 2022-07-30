import javax.security.auth.login.CredentialExpiredException;

/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used.
		this.storage = new Comparable[DEFAULT_SIZE];
		this.currentSize = 0; 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
		this.storage = new Comparable[size];
		this.currentSize = 0; 
	}

	public boolean isALeaf(int index){
		if(currentSize <= ((index*2)+1)){
			return true;
		}
		else{
			return false;
		}
	}

	public void Swap(int indexOne, int indexTwo){
	Comparable temp = storage[indexTwo];

	storage[indexTwo] = storage[indexOne];
	storage[indexOne] = temp;

	}

	public int minChild(int index){
		
		if(currentSize <= index*2+2){
			return index*2+1;
		}

		if(storage[index*2+1].compareTo(storage[index*2+2])<= 0){
			return index*2+1;
		}

		return ((index*2)+2); 
	
	}


	public void insert (Comparable element) throws HeapFullException {
		// TODO: implement this
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.
		 if(isFull()){
			throw new HeapFullException();
		}		

		storage[currentSize]=  element;
		currentSize++;
		bubbleUp(currentSize-1); 
	
    }
	
	public void bubbleUp(int index) {
		// TODO: implement this
		if(index <= 0){
			return;
		}
		int bubble = ((index-1)/2);

		// Check if one is larger than the other
		if(storage[index].compareTo(storage[bubble]) < 0){
		// Do the switch and recurseindex
			Swap(index, bubble);
			bubbleUp(bubble);
		}
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		// TODO: implement this
		if(isEmpty()){
			throw new HeapEmptyException();
	
		}

		Comparable store = storage[0];
		Swap(0,(currentSize-1));

		storage[currentSize-1] = null;
		currentSize--;
		bubbleDown(0);

		return store; // so it compiles 
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		if(isALeaf(index)){
			return;
		}
		int min = minChild(index);


		if(storage[min].compareTo(storage[index])< 1){
			Swap(index, min);
			bubbleDown(min);
		}
	}

	public boolean isEmpty(){
		// TODO: implement this


		return currentSize == 0; // so it compiles
	}
	
	public boolean isFull() {
		// TODO: implement this
	

		return currentSize == storage.length; // so it compiles
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
