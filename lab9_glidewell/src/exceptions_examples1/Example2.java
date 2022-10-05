package exceptions_examples1;

public class Example2 {
	public static void main(String[] args) {
		int x=0;
		try {
			System.out.println(inverse(x));
		}
		catch(ArithmeticException e) {
			System.out.println("exception caught: " + e);
			System.out.println("\nstack trace:\n");
			e.printStackTrace();
		}
		System.out.println("all done!");
	}

	public static int inverse( int x) {
		return 1/x;
	}
}

