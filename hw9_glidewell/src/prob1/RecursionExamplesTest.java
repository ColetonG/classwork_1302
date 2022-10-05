package prob1;

public class RecursionExamplesTest {

	public static void main(String[] args) {
		testSumSeries();
		testPrintReverse2();
		testPrintReverse();
		testCountVowels();
		testCountLength();
		testGetMax();
		testCountCode();		
	}
	
	// Problem 1a
	public static void testSumSeries() {
		System.out.println("-->testSumSeries()");
		double val = RecursionExamples.sumSeries(5);
		double val2 = RecursionExamples.sumSeries(1);
		double val3 = RecursionExamples.sumSeries(3);
		System.out.println(val + " sumSeries(5)");
		System.out.println(val2 + " sumSeries(1)");
		System.out.println(val3 + " sumSeries(3)");
	}

	// Problem 1b
	public static void testPrintReverse2() {
		System.out.println("-->testPrintReverse2()");
		RecursionExamples.printReverse2("fedcba");
		RecursionExamples.printReverse2("456123");
		RecursionExamples.printReverse2("7456123");
		RecursionExamples.printReverse2("abc");
	}
	
	// Problem 1c
	public static void testPrintReverse() {
		System.out.println("-->testPrintReverse()");
		RecursionExamples.printReverse("1234567", 3);
		RecursionExamples.printReverse("3412", 2);
		RecursionExamples.printReverse("789456123", 3);
		RecursionExamples.printReverse("abcdefghijklmnopqrstuvwxyz", 10);
	}

	// Problem 1d
	public static void testCountVowels() {
		System.out.println("-->testCountVowels()");
		System.out.println(RecursionExamples.countVowels("aekmitoeub"));
		System.out.println(RecursionExamples.countVowels("bbbbbbb"));
		System.out.println(RecursionExamples.countVowels("aiiouu"));
		System.out.println(RecursionExamples.countVowels("a"));
	}
	
	// Problem 1e, requires a helper
	public static void testCountLength() {
		System.out.println("-->testCountLength()");
		String[] strs = {"abc", "bb", "defg", "z"};
		String[] strs2 = {"four", "six", "eight"};
		String[] empty = {};
		System.out.println(RecursionExamples.countLength(strs));
		System.out.println(RecursionExamples.countLength(strs2));
		System.out.println(RecursionExamples.countLength(empty));
	}

	// Problem 1f, requires a helper
	public static void testGetMax() {
		System.out.println("-->testGetMax()");
		int[] vals = {3,8,2,9,1,7};
		int max = RecursionExamples.getMax(vals);
		System.out.println(max);
		int[] vals2 = {-100,-1,-10,-20,-3,-1000};
		int max2 = RecursionExamples.getMax(vals2);
		System.out.println(max2);
	}

	// Problem 1g, requires a helper
	public static void testCountCode() {
		// *** WRITE TEST CODE HERE ***
		System.out.println("-->testCountCode()");
		System.out.println(RecursionExamples.countCode("xbabcabcdkabmabc", "abc"));
		System.out.println(RecursionExamples.countCode("Dac","ac"));
		System.out.println(RecursionExamples.countCode("Dac12ac","ac"));
		System.out.println(RecursionExamples.countCode("acacac","ac"));
		System.out.println(RecursionExamples.countCode("1112131111234411","11"));
	}

}
