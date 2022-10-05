package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor");
		Item z = new Item("Cell", 4.5);
		String exName = "Cell";
		String acName = z.getName();
		double exWeight = 4.5;
		double acWeight = z.getWeight();
		String msg = String.format("Expected name:%s Actual name:%s\n", exName, acName);
		msg += String.format("Expected weight:%.2f Actual name:%.2f\n", exWeight, acWeight);
		System.out.println(msg); 
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		Item z = new Item("None", 2.2);
		double exCost = 4.40;
		double acCost = z.cost();
		String msg = String.format("Expected cost: $%.2f Actual cost: $%.2f\n", exCost, acCost);
		System.out.println(msg); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item z = new Item("Cracker", 2.25);
		System.out.println(z); 
	}

}
