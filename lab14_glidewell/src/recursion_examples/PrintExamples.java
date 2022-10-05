package recursion_examples;

public class PrintExamples {

	public static void main(String[] args) {
		recursivePrint1(3);
		System.out.println();
		recursivePrint2(3);
		System.out.println();
		recursivePrint3(3);
		System.out.println();
	}

	private static void recursivePrint1(int n) {
		if( n > 0 ){
			System.out.print( n + " ");
			recursivePrint1(n-1);
		}
	}
	
	private static void recursivePrint2(int n) {
		if( n > 0 ){
			recursivePrint2(n-1);
			System.out.print(n + " ");
		}
	}
	
	private static void recursivePrint3(int n) {
		if( n > 0 ){
			n--;
			recursivePrint3(n);
			System.out.print(n + " ");
		}
	}

}

