/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3TesterH {
    
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
	testAddFront();
		testAddBack();
	testSizeAndIsEmpty();
		testRemoveFront();
	
		testRemoveBack();
		
		/* Part 2 */
		testRotate();
	
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
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeBack();
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");

		list1.removeFront();
		result = list1.size();
		displayResults(result==2, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
	}
	
	public static void testRemoveFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{INK}"), "testRemoveFront");
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{KNI}"), "testRemoveFront");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");
		result = list1.backToFront();
		displayResults(result.equals("{KN}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");
		result = list1.backToFront();
		displayResults(result.equals("{K}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{}"), "testRemoveBack");

	}
	
	public static void testRemoveBack() {
		// Write all of your own tests here 
		String result = "";
		A3LinkedList list1 = new A3LinkedList();

		list1.addBack("P");
		list1.addBack("O");
		list1.addBack("T");
		list1.addBack("A");
		list1.addBack("T");
		list1.addBack("O");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{POTAT}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{TATOP}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{POTA}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{ATOP}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{POT}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{TOP}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PO}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{OP}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{P}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{P}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{}"), "testRemoveBack");

		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBack");
		result = list1.backToFront();
		displayResults(result.equals("{}"), "testRemoveBack");
	}
	
	public static void testRotate() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
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
		result = list1.backToFront();
		displayResults(result.equals("{FEDCBAG}"), "testRotate");
		
		list1.rotate(3);
		result = list1.frontToBack();
		displayResults(result.equals("{DEFGABC}"), "testRotate");
		result = list1.backToFront();
		displayResults(result.equals("{CBAGFED}"), "testRotate");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly. */
		
		list1.rotate(3);
		result = list1.frontToBack();
		displayResults(result.equals("{ABCDEFG}"), "testRotate");
		result = list1.backToFront();
		displayResults(result.equals("{GFEDCBA}"), "testRotate");

		list1.rotate(2);
		result = list1.frontToBack();
		displayResults(result.equals("{FGABCDE}"), "testRotate");
		result = list1.backToFront();
		displayResults(result.equals("{EDCBAGF}"), "testRotate");

		list1.rotate(7);
		result = list1.frontToBack();
		displayResults(result.equals("{FGABCDE}"), "testRotate");
		result = list1.backToFront();
		displayResults(result.equals("{EDCBAGF}"), "testRotate");

		A3LinkedList list2 = new A3LinkedList();
		list2.rotate(3);
		result = list2.frontToBack();
		displayResults(result.equals("{}"), "testRotate");
		result = list2.backToFront();
		displayResults(result.equals("{}"), "testRotate");
	}

	public static void testInterleave() {
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
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

		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly. */

	    result1 = list1.backToFront();
	    result2 = list2.backToFront();
	    displayResults(result1.equals("{GQEOCMA}"), "testInterleave");
		System.out.println(result1);
		displayResults(result2.equals("{RFPDNBL}"), "testInterleave");
		System.out.println(result2);

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave");
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave");

		result1 = list1.backToFront();
	    result2 = list2.backToFront();
		displayResults(result1.equals("{GFEDCBA}"), "testInterleave");
		displayResults(result2.equals("{RQPONML}"), "testInterleave");

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
