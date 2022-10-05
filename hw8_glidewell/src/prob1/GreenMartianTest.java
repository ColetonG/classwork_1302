package prob1;

public class GreenMartianTest {

	public static void main(String[] args) {
		testSpeakAndTeleportAndToString();
		testEquals_Success();
		testEquals_Fail();
		testEqualsRedAndGreen_Success();
		testCompareToRedAndGreenSuccess();
	}
	
	public static void testSpeakAndTeleportAndToString() {
		System.out.println("-->testSpeakAndTeleportAndToString");
		GreenMartian greg = new GreenMartian(24);
		String dest = "Earth";
		String msg = String.format("Test Speak: %s", greg.speak());
		msg += String.format("\nTest Teleport: %s", greg.teleport(dest));
		msg += String.format("\nTest toString: %s", greg.toString());
		System.out.println(msg);
	}
	
	public static void testEquals_Success() {
		System.out.println("\n-->testEquals_Success");
		GreenMartian srav = new GreenMartian (6, 90);
		GreenMartian vars = new GreenMartian (6, 2);
		boolean ex = true;
		boolean ac = srav.equals(vars);
		String msg = String.format("Expected result: %b, Actual result: %b", ex, ac);
		System.out.println(msg);
	}
	
	public static void testEquals_Fail() {
		System.out.println("\n-->testEquals_Fail");
		GreenMartian srav = new GreenMartian (7, 90);
		GreenMartian vars = new GreenMartian (6, 2);
		boolean ex = false;
		boolean ac = srav.equals(vars);
		String msg = String.format("Expected result: %b, Actual result: %b", ex, ac);
		System.out.println(msg);
	}
	
	public static void testEqualsRedAndGreen_Success() {
		System.out.println("\n-->testEqualsRedAndGreen_Success");
		GreenMartian srav = new GreenMartian (7, 90);
		RedMartian bob = new RedMartian(7, 45, 3);
		boolean ex = true;
		boolean ac = srav.equals(bob);
		String msg = String.format("Expected result: %b, Actual result: %b", ex, ac);
		System.out.println(msg);
	}
	
	public static void testCompareToRedAndGreenSuccess() {
		System.out.println("\n-->testCompareToRedAndGreenSuccess");
		RedMartian sab = new RedMartian(4, 24, 640);
		GreenMartian vie = new GreenMartian(4, 56);
		int exVal = 0;
		int acVal = sab.compareTo(vie);
		String msg = String.format("Expected value=%d, Actual value=%d", exVal, acVal);
		System.out.println(msg);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
