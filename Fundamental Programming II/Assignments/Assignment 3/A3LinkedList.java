// Name:Eric Huber
// Student number: v00980396

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
	A3Node f = head;
    A3Node newNode = new A3Node(s);
    newNode.next = f; 
    this.head = newNode;
    if (f == null){
        this.tail = newNode;}
    else{
        f.prev = newNode;}
	
	this.length++;
	
	}

	public void addBack(String s) {
		A3Node l = tail;
		A3Node newNode = new A3Node(s);
		newNode.prev = l; 
		tail = newNode;
		if (l == null){
			head = newNode;}
		else{
			l.next = newNode;}
		
		this.length++; 

		
}
		
	public int size() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
if(!isEmpty()){
	if(length ==1){
		head = null;
		tail = null;
		length--;
	}
else{
	head = head.next;
	
	if(head!= null){
		head.prev = null;
	}

	length--;}
}
	}
	

	
	public void removeBack() {
		if(!isEmpty()){
			if(length == 1){
				head = null;
				tail = null;
				length--;
			}
		else{
		tail = tail.prev;
		tail.next = null;
		length--;}
	}
	
	
	}
	
	
	public void rotate(int n) {
if(length==0 || n%length==0){}
else{
	for(int i =0; i<n; i++){
	
		A3Node temp = tail;
		tail.next = head;
	
		head.prev = tail;
	
		tail = tail.prev;
		head = head.prev;

		tail.next = null;
		temp.prev = null;

	}
}

	}
	
	public void interleave(A3LinkedList other) {
if(length<= 1){
	return;
}
	A3Node cur = new A3Node("");
	A3Node othercur = new A3Node("");
for(int i =0; i<(length-1);i++){
	cur.next =this.head;
	cur.prev= other.head;
	

	for(int k =0; k<i; k++){
		cur.next = cur.next.next;
		cur.prev = cur.prev.next;
	}

	
	othercur.next = cur.next.next;
	
	othercur.prev = cur.prev.next;

	cur.next.next =cur.prev.next;
	
	cur.prev.next = othercur.next;
	
	cur.prev.next.prev = cur.prev;
	
	othercur.prev.prev = cur.next;

	tail = othercur.prev;
	other.tail = othercur.next;

			
		}
	
		

}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	