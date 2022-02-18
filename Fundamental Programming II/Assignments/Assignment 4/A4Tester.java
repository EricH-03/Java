
public class A4Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main(String[] args) {
		testStackOperations();
		testStackIsGeneric();
		testStackedCorrectly();
		testInsertPlate();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testStackOperations() {
		System.out.println("Stack Operations Tests:");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		int result = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(2);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==2, "top works after initial push");

		testStack.push(3);
		result = testStack.top();
		displayResults(result==3, "top works further pushes");
		testStack.push(5);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack not empty");
		displayResults(result==5, "top works further pushes");
		

		int poptest = testStack.pop();
		
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack not empty");
	    displayResults(poptest==5, "top returned correctly after removal");
		displayResults(result==3, "top works after pop");
		
		testStack.pop();
		testStack.pop();
		displayResults(testStack.isEmpty(), "stack is empty");
		displayResults(testStack.top()==null, "top is null");

		testStack.pop();
		displayResults(testStack.pop()==null, "pop returns correct value");


		A4Stack<String> testStackStr = new A4Stack<String>();
		String strResult = "";

		displayResults(testStackStr.isEmpty(), "stack initially empty"); 

		testStackStr.push("Hello");
		testStackStr.push("My");
		testStackStr.push("Name");
		testStackStr.push("Is");
		testStackStr.push("What?");
		
				
		strResult = testStackStr.top();
		displayResults(!testStackStr.isEmpty(), "stack no longer empty (string)");
		displayResults(strResult.equals("What?"), "top works after initial push (string)");

		
		String popReturn = testStackStr.pop();
		displayResults(popReturn=="What?", "top returned correctly after removal (string)");

		testStackStr.push("$%$%@");
		testStackStr.push("     ");
		testStackStr.pop();

		strResult = testStackStr.top();
		displayResults(!testStackStr.isEmpty(), "stack no longer empty (string)");
		displayResults(strResult.equals("$%$%@"), "top works after initial push (string)");

		testStackStr.popAll();
		displayResults(testStackStr.isEmpty(), "Stack is empty after pop all (string)");
		displayResults(testStackStr.top()==null, "top is also null");

				
		System.out.println();
	}
	
	public static void testStackIsGeneric() {
		System.out.println("Stack Generics Tests:");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		int result1;
		String result2;
		double result3;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1==8, "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3==9.1, "Double Stack");		
		
		result1 = s1.top();
		result2 = s2.top();
		result3 = s3.top();
		
		displayResults(result1==3, "Integer Stack");
		displayResults(result2.equals("CSC"), "String Stack");
		displayResults(result3==5.5, "Double Stack");
		

		//TODO: add more tests here
		
		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s4 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		s2.push(p1);
		s2.push(p4);
		
		boolean result = false;
		
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(!result, "s2 stacked correctly");

		result = A4Exercises.stackedCorrectly(s4);
		displayResults(result, "s4 (empty) stacked correctly");

		s1.pop();
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly after removed");

		s1.push(p2);
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "s1 stacked correctly after push"); //this one

		s1.popAll();
		s1.push(p2);
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly after pop all and push back");

		s1.push(p4);
		s1.push(p1);
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly after pop all and push back (X2)");
		
		System.out.println();
	}

	public static void testInsertPlate() {
		System.out.println("Testing insertPlate");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		Plate insert = new Plate(6);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		
	
		
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		s2.push(p2);
		s2.push(p4);
		s2.push(insert);
		s2.push(p1);
		s2.push(p5);
		s2.push(p3);
		

		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into empty stack");
		s1.pop();

		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);

		A4Exercises.insertPlate(s1, insert);
		//displayResults(s2==s1, "insert into empty stack"); // not sure if this is even valid 
		displayResults(A4Exercises.stackedCorrectly(s1), "insert stack");

		insert = new Plate(-1);
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert stack");

		s1.pop();
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert stack");

		
		//TODO: add more tests here
	}

	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}