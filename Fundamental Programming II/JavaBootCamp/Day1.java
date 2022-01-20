public class Day1 {

	public static void main(String[] args) {
		// Call the methods you complete from the 
		// main method to determine if they work correctly.
		int x = 7;
		int y = 3;
		
		printMax(x,y);
		
		isSpecial(x);
		
		int k = countSpecialToN(y);
		System.out.println("The special count is: "+k);
		
		System.out.printf("The: %dth term is %.0f\n", y, getFibonacci(y));
		
		int LargeNumber = 8432590;
		System.out.printf("The leftmost term of the variable LargeNumber (%d) is %d\n", LargeNumber, getLeftDigit(LargeNumber));
		
		printBox(x,y);
		
		printPattern(x);
	}

	// 1) Design a method named printMax that takes two 
	// integers and outputs the maximum value.
public static void printMax(int a, int b){
	
	if(a>b){
	System.out.println(""+a);
	}
	else{ 
	System.out.println(""+b);
	}
	
		
}	
	

	// 2) Design a method named isSpecial, that takes an
	// integer and determines if it is special 
	//
	// Assume an integer is special if it is divisible
	// by 3 or 7 (or both).

public static boolean isSpecial(int a){

if(a%7==0){
 
	return true;
}
else if(a%3==0){
return true;}
else{return false;}


	
}

	// 3) Design a method named countSpecialToN, that takes
	// an integer n and determines how many special
	// integers there are between 1 and n (inclusive).
	//
	// This method MUST call the method you designed in 1)
public static int countSpecialToN (int n){
	int count = 0;
	for(int k = 1; k<=n; k++){
		if(isSpecial(k)){
		count++;}
	}
	return count;	
}


	// 4) Design a method named getFibonacci that takes
	// an integer n and returns the nth term in the 
	// Fibonacci sequence. 
	//
	// In the Fibonacci sequence, the first two terms
	// are 1, and every term following is the sum of the 
	// two previous terms. For example: 1 1 2 3 5 8 13 21 34...
public static float getFibonacci (int n){
	float term1 = 1;
	float term2 = 1;
	float newTerm = 0;
	
	for(int i=3; i<=n; i++){
		newTerm = term1+term2;
		term1 = term2;
		term2=newTerm;
	}
	
	return newTerm;
}


	// 5) Design a method named getLeftDigit that takes 
	// an integer and returns the leftmost digit.
	//
	// For example: if given 8,432,590, then 8 would be
	// returned, as it is the leftmost digit.
	//
	// You must use a while-loop in your solution.
public static int getLeftDigit(int n){
	while((n/10)!= 0){
	 n = n/10;
	
	}
	return n;
}


	// 6) Design a method named printBox that takes two 
	// integers representing the height and width of a 
	// box. The method should output a box with the
	// correct dimensions.
	//
	// For example, printBox(6,3) outputs:
	// ***
	// ***
	// ***
	// ***
	// ***
	// ***
public static void printBox(int row, int column){
	for(int i = 0; i<row; i++){
		for(int k = 0; k<column; k++){
			System.out.print("*");
		}
		System.out.println("");
	}
	System.out.println("");
}


	// 7) Design a method named printPattern that an 
	// integer n representing the size of the pattern
	// to output. The method outputs a triangle n
	// lines long. 
	//
	// For example, printPattern(5) outputs:
	// *
	// **
	// ***
	// ****
	// *****
public static void printPattern(int n){
int count = 1;
	for(int k =0; k<n; k++){
		for(int i =0; i<count; i++){
			System.out.print("*");
		}
		count++;
		System.out.println("");
	}
}



//Bracket for whole thing	
}
