package exceptions_examples1;

public class Example3 {
	public static void main(String[] args) {
		int x=4;
		try {
			System.out.println( inverse(x));
		}
		catch(ArithmeticException e) {
			System.out.println("exception caught");
		}
		finally {
			System.out.println("finally block executed");
		}
		System.out.println("all done!");
	}

	public static int inverse( int x) {
		return 1/x;
	}
}

