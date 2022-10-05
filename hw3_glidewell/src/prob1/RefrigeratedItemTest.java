package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testConstructorAcceptsItem();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain");
		RefrigeratedItem z = new RefrigeratedItem("Salad", 2.2, 4.5);
		String exName = "Salad";
		String acName = z.getName();
		double exWeight = 2.2;
		double acWeight = z.getWeight();
		double exTemp = 4.5;
		double acTemp = z.getTemp();
		String msg = String.format("Expected name: %s Actual name: %s\n", exName, acName);
		msg += String.format("Expected weight: %.2f Actual weight: %.2f\n", exWeight, acWeight);
		msg += String.format("Expected temp: %.2f Actual temp: %.2f\n", exTemp, acTemp);
		System.out.println(msg); 
	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem"); 
		Item v = RefrigeratedItemTest.createItem();
		RefrigeratedItem z = new RefrigeratedItem(v, 4.5);
		String exName = "Salad";
		String acName = z.getName();
		double exWeight = 4.4;
		double acWeight = z.getWeight();
		double exTemp = 4.5;
		double acTemp = z.getTemp();
		String msg = String.format("Expected name: %s Actual name: %s\n", exName, acName);
		msg += String.format("Expected weight: %.2f Actual weight: %.2f\n", exWeight, acWeight);
		msg += String.format("Expected temp: %.2f Actual temp: %.2f\n", exTemp, acTemp);
		System.out.println(msg); 
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost");
		Item v = RefrigeratedItemTest.createItem();
		RefrigeratedItem z = new RefrigeratedItem(v, 4.5);
		double exCost = 18.35;
		double acCost = z.cost();
		String msg = String.format("Expected cost: $%.2f Actual name: $%.2f\n", exCost, acCost);
		System.out.print(msg);
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item v = RefrigeratedItemTest.createItem();
		RefrigeratedItem z = new RefrigeratedItem(v, 4.5);
		System.out.println(z); 
	}
	
	//---------------------------------
	// Helper methods below
	//---------------------------------
	
	public static Item createItem() {
		Item t = new Item("Salad", 4.4);
		return t;
	}

}
