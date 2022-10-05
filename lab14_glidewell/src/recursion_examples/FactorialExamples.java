package recursion_examples;

public class FactorialExamples {

	public static void main(String[] args) {
		int x = 3;
		System.out.println(factorial(x));
	}

	public static int factorial(int n) {
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
}

