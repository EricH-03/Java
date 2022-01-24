public class factorial{
/*
Find the Factorial of an given int n
No Test Cases, but it has been tested and works 
*/	
	
public static void main(String[] args) {
          }	
	//Given n of 1 or more, return the factorial of n (which is n * (n-1) * (n-2) ... 1). 
	//Wanted to practice using recursion, so I wrote this recusively without loops
	public int factorial(int n) {
  if (n==1){
    return 1;
  }

  return n*factorial(n-1);
}

}