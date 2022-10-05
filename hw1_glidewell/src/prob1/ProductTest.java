package prob1;

public class ProductTest {

	/***
	 * YOU SHOULD WRITE THESE TEST METHODS.
	 * 
	 */
	public static void main(String[] args) {
		testProductConstructor_Plant_3chars_Batch_2chars();
		testProductConstructor_Plant_3chars_Batch_1chars();
		testProductConstructor_Plant_2chars_Batch_2chars();
		testProductConstructor_Plant_2chars_Batch_1chars();
		testIsAfter2000Test_True_Year2019();
		testIsAfter2000Test_True_Year2000();
		testIsAfter2000Test_False_Year1994();
		testIsMonthEqual_True();
		testIsMonthEqual_False();
	}
	
	/***
	 * Construct a product where the plant has 3 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_2chars() {
		System.out.println("-->testProductConstructor_Plant_3chars_Batch_2chars()");
		
		Product z = new Product("Val0424200234");
		String code = z.getCode();
		String plant = z.getPlant();
		String date = z.getDate();
		int batch = z.getBatch();
		String msgExpected = String.format("Expected: code=%s, plant=%s, date=%s, batch=%d", "Val0424200234", "Val", "04/24/2002", 34);
		String msgActual =   String.format("  Actual: code=%s, plant=%s, date=%s, batch=%d", code, plant, date, batch);
		System.out.println(msgExpected);
		System.out.println(msgActual);
		
		
	}

	/***
	 * Construct a product where the plant has 3 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_3chars_Batch_1chars()");
		
		Product z = new Product("Zen060320199");
		String code = z.getCode();
		String plant = z.getPlant();
		String date = z.getDate();
		int batch = z.getBatch();
		String msgExpected = String.format("Expected: code=%s, plant=%s, date=%s, batch=%d", "Zen060320199", "Zen", "06/03/2019", 9);
		String msgActual =   String.format("  Actual: code=%s, plant=%s, date=%s, batch=%d", code, plant, date, batch);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_2chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_2chars()");
		
		Product z = new Product("Ak0507198873");
		String code = z.getCode();
		String plant = z.getPlant();
		String date = z.getDate();
		int batch = z.getBatch();
		String msgExpected = String.format("Expected: code=%s, plant=%s, date=%s, batch=%d", "Ak0507198873", "Ak", "05/07/1988", 73);
		String msgActual =   String.format("  Actual: code=%s, plant=%s, date=%s, batch=%d", code, plant, date, batch);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_1chars()");
		
		Product z = new Product("Ak050719887");
		String code = z.getCode();
		String plant = z.getPlant();
		String date = z.getDate();
		int batch = z.getBatch();
		String msgExpected = String.format("Expected: code=%s, plant=%s, date=%s, batch=%d", "Ak0507198873", "Ak", "05/07/1988", 7);
		String msgActual =   String.format("  Actual: code=%s, plant=%s, date=%s, batch=%d", code, plant, date, batch);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the year is 2019 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2019() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2019()");
		
		Product z = new Product("Ak050720197");
		boolean isAfter = z.isAfter2000();
		String msgExpected = String.format("Expected: After 2000: %b", true);
		String msgActual =   String.format("  Actual: After 2000: %b", isAfter);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the year is 2000 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2000() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2000()");
		
		Product z = new Product("Alk050720007");
		boolean isAfter = z.isAfter2000();
		String msgExpected = String.format("Expected: After 2000: %b", true);
		String msgActual =   String.format("  Actual: After 2000: %b", isAfter);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the year is 1994 and then call isAfter2000() which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_False_Year1994() {
		System.out.println("\n-->testIsAfter2000Test_False_Year1994()");
		
		Product z = new Product("Alk0507199473");
		boolean isAfter = z.isAfter2000();
		String msgExpected = String.format("Expected: After 2000: %b", false);
		String msgActual =   String.format("  Actual: After 2000: %b", isAfter);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(2) which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_True() {
		System.out.println("\n-->testIsMonthEqual_True()");
		
		Product z = new Product("Alk0207199473");
		boolean currMonth = z.isMonthEqual(2);
		String msgExpected = String.format("Expected: Is month equal: %b", true);
		String msgActual =   String.format("  Actual: Is month equal: %b", currMonth);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(3) which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_False() {
		System.out.println("\n-->testIsMonthEqual_False()");
		
		Product z = new Product("Alk0207199473");
		boolean currMonth = z.isMonthEqual(5);
		String msgExpected = String.format("Expected: Is month equal: %b", false);
		String msgActual =   String.format("  Actual: Is month equal: %b", currMonth);
		System.out.println(msgExpected);
		System.out.println(msgActual);
	}

}
