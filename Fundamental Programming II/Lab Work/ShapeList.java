public class ShapeList{
    
	private static final int DEFAULT_SIZE = 2;

	private Shape[] elements;
	private int count;

	public ShapeList() {
		elements = new Shape[DEFAULT_SIZE];
		count = 0;
	}

	/*
	 * Purpose: returns the number of elements in list
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		int size = 0;

		for(int i=0; i<elements.length; i++){
		if(elements[i]!=null){
			size++;}
		}
		return size;
	}
	

	/*
	 * Purpose: adds Shape s to back of this list
	 * Parameters: Shape - s
	 * Returns: nothing
	 *
	 * IMPLEMENTATION NOTE: if elements is full, a new
	 * array should be created to hold all of the original
	 * elements and also shape s.
	 */
	public void add(Shape s) {
	for(int i =0; i<elements.length; i++){
		if(elements[i]==null){
			elements[i]=s;
			break;
		}
	}
	if(elements[elements.length-1]!= null && elements[elements.length-1]!= s){
		Shape[] BiggerElements = new Shape[elements.length+1];
	for(int i =0; i<elements.length; i++){
		BiggerElements[i]=elements[i];
	}
	BiggerElements[elements.length]= s;
	elements = BiggerElements;
	}
	}

	/*
	 * Purpose: returns a String reprensentation of the elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<elements.length; i++) {
		if(elements[i]!=null){
			s  += elements[i] + "\n";}
		}

		return s;
	}

	/*
	 * Purpose: removes the first element in this list
	 * Parameters: none
	 * Returns: nothing
	 *
	 * IMPLEMENTATION NOTE: After removing the first element,
	 * all other elements should be shuffled forward 
	 * so that there are no gaps in the array.
	 */
	public void removeFront() {
		// You are not required to implement this method for lab 2
		// It is here as an additional exercise for those of you
		// who would like a little more practice working with 
		// arrays of objects in Java.
	}
    
    
}
