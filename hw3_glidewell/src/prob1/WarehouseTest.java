package prob1;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem();
		testAddItem_Multiple();
		testGetItem_WithIndex();
		testGetItem_WithName();
		testGetAverageTemp();
		testGetRefrigeratedItems();
		testGetTotalCost();
		testGetTotalCostRefrigerated();
		testRemoveItem_WithIndex();
		testRemoveItem_WithName();
		testToString();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem");
		Warehouse vod = new Warehouse();
		vod.addItem(sampleItem());
		int exNum = 1;
		int acNum = vod.getNumItems();
		String msg = String.format("Expected Num Items: %d "
				+ "Actual Num Items: %d\n", exNum, acNum);
		System.out.println(msg); 
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple"); 
		Warehouse vod = createWarehouse3();
		int exNum = 3;
		int acNum = vod.getNumItems();
		String msg = String.format("Expected Num Items: %d "
				+ "Actual Num Items: %d\n", exNum, acNum);
		System.out.println(msg); 
	}
	
	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex");
		Warehouse vod = createWarehouse3();
		String exItem = "Ice Cream";
		Item acItem = vod.getItem(1);
		String msg = String.format("Expected item: %s\nActual Item: %s\n", exItem, acItem.getName());
		System.out.println(msg); 
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName"); 
		Warehouse vod = createWarehouse3();
		String exItem = "Ice Cream";
		Item acItem = vod.getItem(exItem);
		String msg = String.format("Expected item: %s\nActual Item: %s\n", exItem, acItem.getName());
		System.out.println(msg);
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp");
		Warehouse vod = createWarehouse5();
		double exAvg = 16.96;
		double acAvg = vod.getAverageTemp();
		String msg = String.format("Expected average: %.2f, Actual average: %.2f", exAvg, acAvg);
		System.out.println(msg); 
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems");
		Warehouse vod = createWarehouse5();
		String exItems = "Ice Cream, Pudding, Ice";
		RefrigeratedItem[] acItems = vod.getRefrigeratedItems();
		String msg = String.format("Expected items displayed: %s\nActual Items: ", exItems);
		for(int i =0; i<acItems.length; i++) {
			msg += acItems[i].getName() + " ";
		}
		System.out.println(msg); 
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCost"); 
		Warehouse vod = createWarehouse5();
		double exCost = 63.71;
		double acCost = vod.getTotalCost();
		String msg = String.format("Expected cost: $%.2f, Actual cost: $%.2f", exCost, acCost);
		System.out.println(msg); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated");  
		Warehouse vod = createWarehouse5();
		double exCost = 56.71;
		double acCost = vod.getTotalRefrigeratedCost();
		String msg = String.format("Expected cost: $%.2f, Actual cost: $%.2f", exCost, acCost);
		System.out.println(msg); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex");
		Warehouse vod = createWarehouse5();
		Item e;
		int loc = 2;
		e = vod.removeItem(loc);
		int exNumItems = 4;
		String exName = "Frosting";
		String msg = String.format("5 items, after removeItem(%d):\n ", loc);
		msg += String.format("num items: expected=%d, actual=%d\n", exNumItems, vod.getNumItems());
		String acName = e==null ? "null" : e.getName();
		msg += String.format("item name: expected=%s, actual=%s", exName, acName);
		System.out.println(msg); 
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName"); 
		Warehouse vod = createWarehouse5();
		Item e;
		String name = "Ice";
		e = vod.removeItem(name);
		int exNumItems = 4;
		String exName = "Ice";
		String msg = String.format("5 items, after removeItem(%s):\n ", name);
		msg += String.format("num items: expected=%d, actual=%d\n", exNumItems, vod.getNumItems());
		String acName = e==null ? "null" : e.getName();
		msg += String.format("item name: expected=%s, actual=%s", exName, acName);
		System.out.println(msg); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString");
		Warehouse vod = createWarehouse5();
		String msg = vod.toString();
		System.out.println(msg); 
	}
	
	//---------------------
	// Helper methods
	//---------------------
	
	public static Item sampleItem() {
		Item ex = new Item("Crackers", 2.25);
		return ex;
	}
	
	public static Warehouse createWarehouse3() {
		Warehouse v = new Warehouse();
		Item x = new Item("Crackers", 2.25);
		RefrigeratedItem y = new RefrigeratedItem("Ice Cream", 2.10, 4.8);
		Item z = new Item("Frosting", 1.25);
		v.addItem(x);
		v.addItem(y);
		v.addItem(z);
		return v;
	}
	
	public static Warehouse createWarehouse5() {
		Warehouse vod = createWarehouse3();
		RefrigeratedItem pud = new RefrigeratedItem("Pudding", 2.2, 1.0);
		RefrigeratedItem ice = new RefrigeratedItem("Ice", 11.6, 45.1);
		vod.addItem(pud);
		vod.addItem(ice);
		return vod;
	}

}
