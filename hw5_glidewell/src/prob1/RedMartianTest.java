package prob1;

public class RedMartianTest {

	public static void main(String[] args) {
		testSpeakAndToString();
		testEquals_Success();
		testEquals_Fail();
		testCompareTo_Negative();
		testCompareTo_Positive();
		testCompareTo_Zero();
	}
	
	public static void testSpeakAndToString() {
		System.out.println("-->testSpeakAndToString");
		RedMartian sab = new RedMartian(1, 24, 640);
		String speak = sab.speak();
		String eval = sab.toString();
		System.out.println(speak);
		System.out.println(eval);
	}

	public static void testEquals_Success() {
		System.out.println("\n-->testEquals_Success");
		RedMartian sab = new RedMartian(1, 24, 640);
		RedMartian vie = new RedMartian(1, 56, 641);
		boolean expected = true;
		boolean actual = sab.equals(vie);
		String msg = String.format("Expected=%b, Actual=%b", expected, actual);
		System.out.println(msg);
	}
	
	public static void testEquals_Fail() {
		System.out.println("\n-->testEquals_Fail");
		RedMartian sab = new RedMartian(1, 24, 640);
		RedMartian vie = new RedMartian(2, 56, 641);
		boolean expected = false;
		boolean actual = sab.equals(vie);
		String msg = String.format("Expected=%b, Actual=%b", expected, actual);
		System.out.println(msg);
	}
	
	public static void testCompareTo_Negative() {
		System.out.println("\n-->testCompareTo_Negative");
		RedMartian sab = new RedMartian(1, 24, 640);
		RedMartian vie = new RedMartian(2, 56, 641);
		int exVal = -1;
		int acVal = sab.compareTo(vie);
		String msg = String.format("Expected value=%d, Actual value=%d", exVal, acVal);
		System.out.println(msg);
	}
	
	public static void testCompareTo_Positive() {
		System.out.println("\n-->testCompareTo_Positive");
		RedMartian sab = new RedMartian(4, 24, 640);
		RedMartian vie = new RedMartian(1, 56, 641);
		int exVal = 3;
		int acVal = sab.compareTo(vie);
		String msg = String.format("Expected value=%d, Actual value=%d", exVal, acVal);
		System.out.println(msg);
	}
	
	public static void testCompareTo_Zero() {
		System.out.println("\n-->testCompareTo_Zero");
		RedMartian sab = new RedMartian(4, 24, 640);
		RedMartian vie = new RedMartian(4, 56, 641);
		int exVal = 0;
		int acVal = sab.compareTo(vie);
		String msg = String.format("Expected value=%d, Actual value=%d", exVal, acVal);
		System.out.println(msg);
	}
}
