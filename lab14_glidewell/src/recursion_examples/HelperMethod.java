package recursion_examples;

public class HelperMethod {

	public static void main(String[] args) 
	{
		String msg = "sutus";
		System.out.println( msg + " is palindrone=" + isPalindrone(msg) );
	}

	public static boolean isPalindrone( String msg )
	{
		return isPalindrone( msg, 0, msg.length()-1 );
	}

	private static boolean isPalindrone( String msg, int first, int last )
	{
		if( first >= last ) 
			return true;
		if( msg.charAt(first) != msg.charAt(last) )
			return false;
		else
			return isPalindrone( msg, first+1, last-1 );
	}
}

