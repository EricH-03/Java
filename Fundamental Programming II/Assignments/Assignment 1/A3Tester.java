/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */

public class A3Tester {
    
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
		//testAddFront();
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
		System.out.println(result);
		displayResults(result.equals("{JAVA}"), "testAddFront");
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{AVAJ}"), "testAddFront");

		A3LinkedList list2 = new A3LinkedList();
		result = list2.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list2.addFront("Ah");
		result = list2.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{Ah}"), "testAddFrontList2");

		list2.addFront("C");
		list2.addFront("U");
		list2.addFront("M R");
		result = list2.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{M RUCAh}"), "testAddFrontList2");
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
		
		list1.addBack("");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBackEric");

		list1.addBack("is broken?");
		result = list1.backToFront();
		displayResults(result.equals("{is broken?NUF}"), "testAddBackEric broekn?");
		result = list1.frontToBack();
		displayResults(result.equals("{FUNis broken?}"), "testAddBackEric broekn?");

		list1.removeFront();
		list1.removeBack();
		list1.removeFront();
		list1.removeFront();
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{}"), "testAddBackEricList1");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBackEricList1");

		list1.addFront("U");
		list1.addBack("N");
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{UN}"), "testAddBackEricList1");

		A3LinkedList list2 = new A3LinkedList();
		list2.addBack("HelloThere");
		result = list2.frontToBack();
		displayResults(result.equals("{HelloThere}"), "testAddBackEricList2");

		list2.addBack("#");
		result = list2.frontToBack();
		displayResults(result.equals("{HelloThere#}"), "testAddBackEricList2");

		list2.addBack("This is a really long input with lots of spaces, will this be an issue for my function (whoops its a method in java don't get those confused!");
		result = list2.frontToBack();
		displayResults(result.equals("{HelloThere#This is a really long input with lots of spaces, will this be an issue for my function (whoops its a method in java don't get those confused!}"), "testAddBackEricList2");

		A3LinkedList list3 = new A3LinkedList();
		list3.addBack("Adding two lists?");
		result = list3.frontToBack();
		displayResults(result.equals("{Adding two lists?}"), "testAddBackEricList3");
		
	/*	String list2contains = list2.frontToBack();
		list3.addBack(list2contains);
		result = list3.frontToBack();
		displayResults(result.equals("{Adding two lists?{HelloThere#This is a really long input with lots of spaces, will this be an issue for my function (whoops its a method in java don't get those confused!}}"), "testAddBackEricList3");
	*/

		list3.addBack(list2.frontToBack());
		result =list3.frontToBack();
		//System.out.println(result);
		displayResults(result.equals("{Adding two lists?{HelloThere#This is a really long input with lots of spaces, will this be an issue for my function (whoops its a method in java don't get those confused!}}"), "testAddBackEricList3");
		

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
		
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		list1.addBack("115");
		result = list1.size();
		displayResults(result==13, "testSize");
		displayResults(list1.isEmpty()==false, "testIsEmpty");

		list1.removeFront();
		list1.removeBack();

		result = list1.size();
		displayResults(result==11, "testSize");
		displayResults(list1.isEmpty()==false, "testIsEmpty");

		list1.removeFront();
		result = list1.size();
		displayResults(result==10, "testSize");
		displayResults(list1.isEmpty()==false, "testIsEmpty");

		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		list1.removeFront();
		result = list1.size();
		displayResults(result==0, "testSize");
		displayResults(list1.isEmpty()==true, "testIsEmpty");

		list1.removeFront();
		result = list1.size();
		displayResults(result==0, "testSize");
		displayResults(list1.isEmpty()==true, "testIsEmpty");


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
		displayResults(result.equals("{INK}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{NK}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{K}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");

		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront");

		

		A3LinkedList list2 = new A3LinkedList();
		list2.addBack("PUNK");
		list2.addBack("INK");
		list2.addBack("N%%%%%");
		list2.addBack("This is a really long input, it does not do to dwell on dreams and forget to live. In the case wherre theta is bigger than 90 degrees it would be negative in this quadrant");
		result = list2.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{PUNKINKN%%%%%This is a really long input, it does not do to dwell on dreams and forget to live. In the case wherre theta is bigger than 90 degrees it would be negative in this quadrant}"), "testRemoveFront");

		
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */
				
	}
	
	public static void testRemoveBack() {
		// Write all of your own tests here 
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveBack");
		
		list1.removeBack();
		result = list1.frontToBack();
		displayResults(result.equals("{PIN}"), "testRemoveBackEric");
		
		list1.removeBack();
		result = list1.frontToBack();
		//System.out.println(result);
		displayResults(result.equals("{PI}"), "testRemoveBackEric");

		list1.removeBack();
		result = list1.frontToBack();
		//System.out.println(result);
		displayResults(result.equals("{P}"), "testRemoveBackEric");

		list1.removeBack();
		result = list1.frontToBack();
		//System.out.println(result);
		displayResults(result.equals("{}"), "testRemoveBackEric");

		list1.removeBack();
		//System.out.println(result);
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveBackEric");



		A3LinkedList list2 = new A3LinkedList();
		list2.addBack("PUNK");
		list2.addBack("INK");
		list2.addBack("N%%%%%");
		list2.addBack("This is a really long input, it does not do to dwell on dreams and forget to live. In the case wherre theta is bigger than 90 degrees it would be negative in this quadrant");
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
		System.out.println(result);
		displayResults(result.equals("{GABCDEF}"), "testRotate");
		
		list1.rotate(3);
		result = list1.frontToBack();
		displayResults(result.equals("{DEFGABC}"), "testRotate");

		list1.rotate(4);
		result = list1.frontToBack();
		displayResults(result.equals("{GABCDEF}"), "testRotate");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly. */
		
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
		System.out.println(result2);
		
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "testInterleave");
		//System.out.println(result1);
		displayResults(result2.equals("{LBNDPFR}"), "testInterleave");
		//System.out.println(result2);


		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave");
		//System.out.println(result1);
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave");
		//System.out.println(result2);

	/*	list2.removeBack();
		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "testInterleave");
		//System.out.println(result1);
		displayResults(result2.equals("{LBNDPF}"), "testInterleave");
		//System.out.println(result2); */

		A3LinkedList list3 = new A3LinkedList();
		A3LinkedList list4 = new A3LinkedList();
		String result3 = "";
		String result4 = "";
		list3.interleave(list4);
		result3 = list3.frontToBack();
		result4 = list4.frontToBack();
		displayResults(result3.equals("{}"), "testInterleave");
		//System.out.println(result3);
		displayResults(result4.equals("{}"), "testInterleave");
		//System.out.println(result4);

		list4.addBack("A");
		list4.interleave(list3);
		result3 = list3.frontToBack();
		result4 = list4.frontToBack();
		displayResults(result3.equals("{}"), "testInterleave");
		//System.out.println(result3);
		displayResults(result4.equals("{A}"), "testInterleave");
		//System.out.println(result4);

		list3.addBack("B");
		list3.addBack("C");// BC
		list4.addBack("D");//AD
		list4.interleave(list3);
		result3 = list3.frontToBack();
		result4 = list4.frontToBack();
		displayResults(result3.equals("{BD}"), "testInterleave");
		//System.out.println(result3);
		displayResults(result4.equals("{AC}"), "testInterleave");
		//System.out.println(result4);


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
