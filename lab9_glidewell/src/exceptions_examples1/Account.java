package exceptions_examples1;

public class Account {
	protected double balance;
	
	public static void main (String[] args) {
		try {
			Account a = new Account(4.0);
			System.out.println(a);
		}
		catch(RuntimeException e) {
			System.out.println(e);
		}
	}
	
	public Account(double balance) {
		if(balance > 0) {
			this.balance = balance;
		}
		else {
			throw new IllegalArgumentException ("Balance Invalid");
		}
	}
	
	@Override
	public String toString() {
		String msg = "Balance: " + Double.toString(balance);
		return msg;
	} 
}
