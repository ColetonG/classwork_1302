package prob1;

public class RecursionExamples {

	// Problem 1a
	public static double sumSeries(int n) {
		if(n<=1) {
			return 1;
		}
		if(n % 2 == 0) {
			return sumSeries(n-1) + 1.0/n;
		}
		else {
			return sumSeries(n-1) - 1.0/n;
		}
	}

	// Problem 1b
	public static void printReverse2(String s) {
		if(s.length() <= 3) {
			System.out.println(s);
		}
		else {
			System.out.print(s.substring(s.length()-3));
			printReverse2(s.substring(0,s.length()-3));
		}
	}
	
	// Problem 1c
	public static void printReverse(String s, int n) {
		if(s.length() <= n) {
			System.out.println(s);
		}
		else {
			System.out.print(s.substring(s.length()-n));
			printReverse(s.substring(0,s.length()-n), n);
		}
	}

	// Problem 1d
	public static int countVowels(String s) {
		String vowels = "aeiou";
		if(s.length() <= 0) {
			return 0;
		}
		String hold = String.valueOf(s.charAt(0));
		if(vowels.contains(hold)){
			return 1 + countVowels(s.substring(1));
		}
		return 0 + countVowels(s.substring(1));
	}
	
	// Problem 1e, requires a helper
	public static int countLength(String[] strs) {
		return countLength(strs, 0);
	}

	// Problem 1f, requires a helper
	public static int getMax(int[] vals) {
		return getMax(vals, Integer.MIN_VALUE, 0);
	}

	// Problem 1g, requires a helper
	public static int countCode(String msg, String code ) {
		return countCode(msg, code, 0);
	}

	
//-------------------------------------
//	Helper Methods for problems e, f, g
//-------------------------------------
	
	private static int countLength(String[] strs, int loc) {
		if(loc >= strs.length) {  //base case
			return 0;
		}
		else{
			return strs[loc].length() + countLength(strs, loc+1);
			
		}
	}
	
	private static int getMax(int[] vals, int max, int loc) {
		if(loc >= vals.length) {
			return max;
		}
		else {
			if(vals[loc] > max) {
				max = vals[loc];
				return getMax(vals, max, loc+1);
			}
			return getMax(vals, max, loc+1);
		}
	}
	
	private static int countCode(String msg, String code, int pos) {
		int codeL = code.length();
		if(pos >= msg.length() - (codeL - 1)) {
			return 0;
		}
		else {
			if(msg.substring(pos, pos + codeL).equals(code)) {
				return 1 + countCode(msg, code, pos + codeL + 1);
			}
			else {
				return 0 + countCode(msg, code, pos+1);
			}
		}
	}
}
