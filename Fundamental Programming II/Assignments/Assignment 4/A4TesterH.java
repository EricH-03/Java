
public class A4TesterH {

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

		testStack.push(5);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack still isn't empty");
		displayResults(result==5, "top works after second push");
				

		int popResult = testStack.pop();
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack isn't empty after one pop");
		displayResults(result==2, "top works after one pop");
		displayResults(popResult==5, "pop removed correct value");

		popResult = testStack.pop();
		displayResults(testStack.isEmpty(), "stack is empty after two pops");
		displayResults(popResult==2, "second pop removed correct value");

		displayResults(testStack.top()==null, "there is no top value in an empty list");
		displayResults(testStack.pop()==null, "pop removed nothing in an empty list");

		testStack.push(5);
		testStack.push(4);
		testStack.push(65);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack isn't empty after multiple pushes");
		displayResults(result==65, "top works after multiple pushes");

		testStack.popAll();
		displayResults(testStack.isEmpty(), "stack is empty after popAll");
		displayResults(testStack.top()==null, "there is no top value in an empty list");

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

		displayResults(s1.isEmpty(), "Integer Stack is empty to start");
		displayResults(s2.isEmpty(), "String Stack is empty to start");
		displayResults(s3.isEmpty(), "Double Stack is empty to start");
		
		s1.push(3);
		s1.push(8);

		s2.push("CSC");
		s2.push("ENGR");

		s3.push(5.5);
		s3.push(9.1);

		displayResults(!s1.isEmpty(), "Integer Stack is no longer empty");
		displayResults(!s2.isEmpty(), "String Stack is no longer empty");
		displayResults(!s3.isEmpty(), "Double Stack is no longer empty");
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1==8, "Integer Stack after one pop");
		displayResults(result2.equals("ENGR"), "String Stack after one pop");
		displayResults(result3==9.1, "Double Stack after one pop");		
		
		result1 = s1.top();
		result2 = s2.top();
		result3 = s3.top();
		
		displayResults(result1==3, "Integer Stack top after one pop");
		displayResults(result2.equals("CSC"), "String Stack top after one pop");
		displayResults(result3==5.5, "Double Stack top after one pop");
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1==3, "Integer Stack after a second pop");
		displayResults(result2.equals("CSC"), "String Stack after a second pop");
		displayResults(result3==5.5, "Double Stack after a second pop");		
		
		displayResults(s1.top()==null, "Integer Stack has no top value after second pop");
		displayResults(s2.top()==null, "String Stack has no top value after second pop");
		displayResults(s3.top()==null, "Double Stack has no top value after second pop");

		displayResults(s1.isEmpty(), "Integer Stack is empty after two pops");
		displayResults(s2.isEmpty(), "String Stack is empty after two pops");
		displayResults(s3.isEmpty(), "Double Stack is empty after two pops");
		
		s1.push(3);
		s1.push(8);

		s2.push("CSC");
		s2.push("ENGR");

		s3.push(5.5);
		s3.push(9.1);

		displayResults(!s1.isEmpty(), "Integer Stack is no longer empty");
		displayResults(!s2.isEmpty(), "String Stack is no longer empty");
		displayResults(!s3.isEmpty(), "Double Stack is no longer empty");

		s1.popAll();
		s2.popAll();
		s3.popAll();
		
		displayResults(s1.isEmpty(), "Integer Stack is empty after popAll");
		displayResults(s2.isEmpty(), "String Stack is empty after popAll");
		displayResults(s3.isEmpty(), "Double Stack is empty after popAll");

		displayResults(s1.top()==null, "Integer Stack has no top value after popAll");
		displayResults(s2.top()==null, "String Stack has no top value after popAll");
		displayResults(s3.top()==null, "Double Stack has no top value after popAll");

		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		Plate p6 = new Plate(15);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		s2.push(p1);
		s2.push(p4);
		
		boolean result = false;
		
		A4Stack<Plate> originalS1 = s1;
		A4Stack<Plate> originalS2 = s2;

		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly");
		displayResults(originalS1==s1, "s1 hasn't been altered");
		
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(!result, "s2 stacked incorrectly");
		displayResults(originalS2==s2, "s2 hasn't been altered");

		s2.pop();
		originalS2 = s2;
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(result, "s2 stacked correctly after removing a plate");
		displayResults(originalS2==s2, "s2 hasn't been altered");

		s2.pop();
		originalS2 = s2;
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(result, "stacked correctly with no plates");
		displayResults(originalS2==s2, "s2 hasn't been altered");
		
		s1.push(p6);
		originalS1 = s1;
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(!result, "s1 no longer stacked correctly");
		displayResults(originalS1==s1, "s1 hasn't been altered");

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
		
		displayResults(s1.isEmpty(), "stack starts empty");

		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into empty stack");
		displayResults(!s1.isEmpty(), "stack is no longer empty");

		s1.popAll();
		displayResults(s1.isEmpty(), "stack starts empty");

		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into stack");
		displayResults(!s1.isEmpty(), "stack is no longer empty");

		insert = new Plate(3);
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into stack with a same size plate");

		s1.pop();
		A4Exercises.insertPlate(s1, p3);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert to top of stack");

		insert = new Plate(15);
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert to bottom of stack");
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