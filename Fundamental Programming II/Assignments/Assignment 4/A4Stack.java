public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}
	
	public void push(T value){
		A4Node<T> newnode = new A4Node<T>(value);

		if(head== null){
			head = newnode;

		}

		else{
			newnode.next = head;
			head = newnode;
				
		}
	}

	public T pop(){
		if(isEmpty()){
			return null;
		}
		A4Node<T> temp = head;
		head = head.next;
		return temp.getData();
	}

	public boolean isEmpty(){
		return head==null;
	}

	public T top(){
		if(!isEmpty()){
		return head.getData();}
		
		else
		return null;
	}

	public void popAll(){
		head = null;
	}
}