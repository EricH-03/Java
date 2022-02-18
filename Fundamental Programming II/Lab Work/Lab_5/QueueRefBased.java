public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	//private int count;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
		//count = 0;
	}

	public int size() {	
		int count = 0;
		QueueNode temp = front;
		if(!isEmpty()){
			while(temp != null){
				count++;
				
				temp = temp.next;
				
			}
		}
		return count;			
	}

	public boolean isEmpty() {
	if(front== null ){
		return true;
	}
	return false;	
	}

	public void enqueue (int value) {
	QueueNode newnode = new QueueNode(value);
	QueueNode temp = front;
		if(front == null){
		front = newnode;
		back = front;
	}
else{
front = back;
front.next = newnode;
back = newnode;
front = temp;
	//front = this.getNext();

}

	}

	public int dequeue() {
		int store =0;
		if(!isEmpty()){
		store = front.getValue();
		front = front.next;}
		return store; // so it compiles
	}

	public int peek()  {
		return back.getValue(); // so it compiles
	}

	public void makeEmpty() {
	front = null;
	back = null;
	}
}
