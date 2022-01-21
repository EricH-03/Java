public class Day2{

	public static void main(String[] args) {
		// Call the methods you complete from the 
		// main method to determine if they work correctly.
		int a[] = {5,2,6, -3};
		int b[] = new int[1];
		System.out.println("average value of a is " + averageValue(a));
		System.out.println("the sum of the postive of a is " + sumPositive(a));
		System.out.println("get min of a is " + getMin(a));
		System.out.println("get min of b is " + getMin(b));
	}

	/*
	 * 1) Write a method named averageValue that takes an
	 *    array of integers and returns the average value
	 *    of all elements found in the array. Assume the array
	 *    contains at least one element.
	 */
public static double averageValue( int array[]) {
double sum = 0;
int count = 0;
		for(int i =0; i<array.length; i++){
	sum = sum + array[i];
	count++;
			
		}
return sum/count;
}	
	/*
	 * 2) Write a method named sumPositive that takes an
	 *    array of integers and returns the sum of all 
	 *    the positive valued elements found in the array.
	 */
public static int sumPositive (int b[]){

int sum =0;
	for(int i =0; i<b.length; i++){
		if(b[i]>0){sum= sum + b[i];}
	}
return sum;
}	
	/*
	 * 3) Write a method named getMin that takes an array
	 *    of positive integers and returns the minimum 
	 *    value found in the array. If the array does 
	 *    not contain any elements, -1 is returned.
	 */

public static int getMin (int a[]){
System.out.println(a.length);

if( a.length <= 0){
	
	return -1;}
	
int i = 0;
int smallest = a[i];

	for(i=1; i<a.length; i++){
		if(a[i]<smallest){smallest = a[i];}
	}
return smallest;
}	
	/*
	 * 4) Write a method named allOdd that determines
	 *    if an array of integers contains only odd-numbered
	 *    elements (i.e. the array does not contain any
	 *    even-numbered elements).
	 */
//public static boolean 
	/*
	 * 5a) Write a method named reverse that takes an
	 *     array of integers and reverses all of the
	 *     elements found in the given array.
	 */
	
	/*
	 * 5b) Write a method named reverse that takes an
	 *     array of integers and returns a new array that
	 *     contains the same elements as the given array, 
	 *     but in reverse order. 
	 */

}