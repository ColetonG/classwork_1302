package student;

public class AirportTest {
	public static void main(String[] args) {
		testEqualsMethod_True();
		testEqualsMethod_False();
		testToString();
	}
	
	
	public static void testEqualsMethod_True() {
		System.out.println("-->testEqualsMethod_True");
		Airport alaska = new Airport("ALA");
		Airport alabama = new Airport("ALA");
		boolean ex = true;
		boolean ac = alaska.equals(alabama);
		String msg = String.format("Expected output: %b\nActual output: %b", ex, ac);
		System.out.println(msg);
	}
	
	public static void testEqualsMethod_False() {
		System.out.println("\n-->testEqualsMethod_False");
		Airport alaska = new Airport("ALA");
		Airport flordia = new Airport("FLA");
		boolean ex = false;
		boolean ac = alaska.equals(flordia);
		String msg = String.format("Expected output: %b\nActual output: %b", ex, ac);
		System.out.println(msg);
	}
	
	public static void testToString() {
		System.out.println("\n-->testToString");
		Airport ga = new Airport("GAA", 44, 55, "Atlanta", "GA");
		String msg = String.format("Airport toString():\n%s", ga.toString()); 
		System.out.println(msg);
	}
}
