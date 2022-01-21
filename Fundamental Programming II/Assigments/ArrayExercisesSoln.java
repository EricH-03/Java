public class ArrayExercisesSoln {

	public static void main (String[] args) {

		// Q1. Complete the arrayReview Questions
		//arrayReview ();

		// Q2. Complete the implementation of ArraysEqual, which 
		// determines if two arrays have the same elements in the same order.

		testArraysEqual();


		// Q3. Write and test a method that takes an array of integers,
		// and doubles all the values in the array

		testDouble();


		// Q4. Write and test a method that given an array of integers,
		//  returns the sum of all the odd numbers in the array 

		testSumOdd();

	}

	public static void arrayReview () {
			
		// Q1a. What is the output of the following:
		int[] array1 = new int[3];
		System.out.println("array1: " + array1);

		// Q1b. What is the output of the following:
		array1[1] = 2;
		System.out.println("array1[1]: " + array1[1]);

		// Q1c. What is the output of the following:
		int[] array2 = {4, 5, 6};
		System.out.println("array2: " + array2);
		System.out.println("array2[1]: " + array2[1]);

		// Q1d. What is the output of the following:
		double[] array3 = new double[10];
		System.out.println("array3[10]: " + array3[0]);
		System.out.println("array3[10]: " + array3[10]);

	}     

	public static void testArraysEqual() {
		int[] asc1 = {1, 2, 3, 4};
		int[] asc2 = {1, 2, 3, 4, 5};
		int[] des1 = {4, 3, 2, 1};
		int[] des2 = {4, 3, 2, 1};
		int[] asc3 = {1, 2, 3, 5};
		boolean same = arraysEqual(asc1, asc2);
		System.out.println("expected false");
		System.out.println("value returned: " + same);
		
		same = arraysEqual(asc1, des1);
		System.out.println("expected false");
		System.out.println("value returned: " + same);
		
		same = arraysEqual(des1, des2);
		System.out.println("expected true");
		System.out.println("value returned: " + same);
	
		same = arraysEqual(asc1, asc3);
		System.out.println("expected false");
		System.out.println("value returned: " + same);
	}
	
	/*
	 * Purpose: Determines whether two arrays are equal
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays are the same length with 
	 *                    the same values at each position
	 */
	public static boolean arraysEqual(int[] a, int[] b) {
		if (a.length == b.length) {
			//we know the lengths are the same
			
			//check the values at each position are equal
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
			// the values at EVERY position were equal
			return true;			
		} 
		return false;
	}


	public static void testDouble() {
		int[] a1 = {7, 1, 3, 4};
		int[] a1x2 = {14, 2, 6, 8};
		int[] a1x2x2 = {28, 4, 12, 16};
		
		doubleAll(a1);
		System.out.println("doubleAll {7,1,3,4} should now equal a1x2");
		System.out.println("a1 equals a1x2: " + arraysEqual(a1, a1x2));
		// NOTE: we can use our arraysEqual method we defined above
		//       to check for array equality!
		
		doubleAll(a1);
		System.out.println("doubleAll {14, 2, 6, 8} should now equal a1x2x2");
		System.out.println("a1 equals a1x2x2: " + arraysEqual(a1, a1x2x2));
		
		int[] a2 = {5, 4, 9};
		int[] a2x2 = {10, 8, 18};
		int[] a2x2x2 = {20, 16, 36};
		
		doubleAll(a2);
		System.out.println("doubleAll {5,4,9} equals {10,8,18}: " + arraysEqual(a2, a2x2));
		
		doubleAll(a2);
		System.out.println("doubleAll {10,8,18} equals {20,16,36}: " + arraysEqual(a2, a2x2x2));
		
		System.out.println();
	}
	
	/*
	 * Purpose: Doubles the values of all elements in given array
	 * Parameters: int[] arr - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]*2;
		}
	}
	
	
	public static void testSumOdd() {
		int result = 0;
		int expected = 0;
		
		int[] a1 = {2};
		result = sumOdd(a1);
		System.out.println("sumOdd {2} should be 0, result: " + result);
		
		int[] a2 = {2, 3, 4, 5};
		result = sumOdd(a2);
		expected = 8;
		System.out.println("sumOdd {2,3,4,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);

		int[] a3 = {7, 9, 15, 2, 5};
		result = sumOdd(a3);
		expected = 7 + 9 + 15 + 5;
		System.out.println("sumOdd {7,9,15,2,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		System.out.println();
	}
	
	/*
	 * Purpose: Determine the sum of all odd values in given array
	 * Parameters: int[] arr 
	 * Returns: int - the sum of all odd values found in array
	 */
	public static int sumOdd(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%2 == 1) {
				result += arr[i];
			}
		}
		return result;
	} 

}
