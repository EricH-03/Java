/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3TesterO {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in A3LinkedList.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		// testAddFront(); DID NOT ADD ANY TESTS
		// testAddBack(); DID NOT ADD ANY TESTS
		testSizeAndIsEmpty();
		testRemoveFront(); 
		testRemoveBack(); 
		//
		/* Part 2 */
		// testRotate();
		 testInterleave();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		displayResults(result.equals("{JAVA}"), "testAddFront");
		result = list1.backToFront();
		displayResults(result.equals("{AVAJ}"), "testAddFront");


	}
	
	public static void testAddBack() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		int sizer = 0;
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==4, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==2, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==1, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");
		sizer = list1.size();
		displayResults(sizer==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
				
	}
	
	public static void testRemoveBack() {
		int sizer = 0;
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");
		sizer = list1.size();
		displayResults(sizer==4, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testRemoveBack");
		sizer = list1.size();
		displayResults(sizer==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PI}"), "testRemoveBack");
		sizer = list1.size();
		displayResults(sizer==2, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{P}"), "testRemoveBack");
		sizer = list1.size();
		displayResults(sizer==1, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");
		sizer = list1.size();
		displayResults(sizer==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");sizer = list1.size();
		displayResults(sizer==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");

	}
	
	public static void testRotate() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList empt = new A3LinkedList();

		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result = list1.frontToBack();
		displayResults(result.equals("{ABCDEFG}"), "testRotate");
		
		list1.rotate(1);
		result = list1.frontToBack();
		displayResults(result.equals("{GABCDEF}"), "testRotate");
		
		list1.rotate(3);
		result = list1.frontToBack();
		displayResults(result.equals("{DEFGABC}"), "testRotate");
		
		list1.rotate(3);
		result = list1.frontToBack();
		displayResults(result.equals("{ABCDEFG}"), "testRotate");

		list1.rotate(7);
		result = list1.frontToBack();
		displayResults(result.equals("{ABCDEFG}"), "testRotate");

		list1.rotate(49);
		result = list1.frontToBack();
		displayResults(result.equals("{ABCDEFG}"), "testRotate");

		list1.rotate(50);
		result = list1.frontToBack();
		displayResults(result.equals("{GABCDEF}"), "testRotate");

		empt.rotate(1);
		result = empt.frontToBack();
		displayResults(result.equals("{}"), "testRotate");

		empt.rotate(100);
		result = empt.frontToBack();
		displayResults(result.equals("{}"), "testRotate");
	}

	public static void testInterleave() {
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		A3LinkedList ollie = new A3LinkedList();
		A3LinkedList brown = new A3LinkedList();
		String result1 = "";
		String result2 = "";
		
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave");
		
		list2.addBack("L");
		list2.addBack("M");
		list2.addBack("N");
		list2.addBack("O");
		list2.addBack("P");
		list2.addBack("Q");
		list2.addBack("R");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave");
		
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "testInterleave");
		displayResults(result2.equals("{LBNDPFR}"), "testInterleave");

		ollie.addBack("A");
		ollie.addBack("B");
		result1 = ollie.frontToBack();
		displayResults(result1.equals("{AB}"), "testInterleave BASIC");
		brown.addBack("L");
		brown.addBack("M");
		result2 = brown.frontToBack();
		displayResults(result2.equals("{LM}"), "testInterleave BASIC");
		
		ollie.interleave(brown);
		result1 = ollie.frontToBack();
		result2 = brown.frontToBack();
		displayResults(result1.equals("{AM}"), "testInterleave Ollie");
		displayResults(result2.equals("{LB}"), "testInterleave Brown");
		// System.out.println(result1); all the commented lines are just for debugging
		//System.out.println(result1); 

		//System.out.println("What?" + ollie.frontToBack());
		ollie.addBack("A");
		ollie.addBack("B");

		//result1 = ollie.backToFront();
		//System.out.println(result1);
		result1 = ollie.frontToBack();
		System.out.println(result1);
		displayResults(result1.equals("{AMAB}"), "testInterleave BASIC");
		brown.addBack("L");
		brown.addBack("M");
		//result2 = brown.backToFront();
		//System.out.println(result2);
		result2 = brown.frontToBack();
		System.out.println(result2);
		displayResults(result2.equals("{LBLM}"), "testInterleave BASIC");

		brown.interleave(ollie);
		result1 = ollie.frontToBack();
		result2 = brown.frontToBack();
		displayResults(result1.equals("{ABAM}"), "testInterleave Ollie");
		displayResults(result2.equals("{LMLB}"), "testInterleave Brown");

		ollie.interleave(ollie);
		result1 = ollie.frontToBack();
		displayResults(result1.equals("{ABAM}"), "testInterleave Ollie");
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
