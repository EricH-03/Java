public class A4Exercises {
	
	/*
	 * Purpose: determine if the stack of plates has been
	 *          stacked correctly (ie. there is never a plate
	 *          on top of a smaller plate)
	 * Parameters: Stack<Plate> s - a stack of plates
	 * Returns: boolean - true if the plates are stacked correctly
	 *                    false otherwise
	 * Post-condition: the contents of s are not modified
	 */
	public static boolean stackedCorrectly(Stack<Plate> s) {
	if(s.isEmpty()){
		return true;
	}
		Stack<Plate> temp = new A4Stack<Plate>();
		Plate data1 = s.pop();

		temp.push(data1);
		int og = data1.getDiameter();
		int compare = 0;
		int i = 1;
	while(!s.isEmpty()){
		i++;
		data1 = s.pop();
		temp.push(data1);
		compare = data1.getDiameter();
	
		if(og>compare){
			for(int k = 0; k<i; k++){
				s.push(temp.pop());
			}
			return false;
		}
		else{
			og = compare;
		}

	}
	for(int k = 0; k<i; k++){
		s.push(temp.pop());
	} 
		return true; // so it compiles
	}
	
	/*
	 * Purpose: insert p into the correct location in the
	 *          stack such that there are no smaller plates 
	 *          below p and no larger plates above p
	 * Parameters: Stack<Plate> s - a stack of plates
	 *             Plate p - the plate to insert into s
	 * Returns: void - nothing
	 * Pre-condition: plates in s have been stacked correctly
	 */
	public static void insertPlate(Stack<Plate> s, Plate p) {
		Stack<Plate> temp = new A4Stack<Plate>();
		
	if(s.isEmpty()){
		s.push(p);
		return;
	}

	Plate data1 = s.pop();
	temp.push(data1);

	int i = 0;
 while(data1.getDiameter()<p.getDiameter()&& !s.isEmpty()){
		data1 = s.pop();
		temp.push(data1);
		i++;
		}
		s.push(p);
	for(int k = i; k<0; k--){
			s.push(temp.pop());
		}
/*
		int og = data1.getDiameter();
		int compare = p.getDiameter();
while(!s.isEmpty()){
	if(compare>= og){
		temp.push(p);
		compare = -999999999;
	}
	data1 = s.pop();
	og = data1.getDiameter();
	temp.push(data1);
	i++;
}

for(int k = 0; k<i; k++){
			s.push(temp.pop());
	} 
		*/
		
	} 






}
