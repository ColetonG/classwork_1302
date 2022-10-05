package ver1;

public class Account {
	//Instance variable only available inside class
	private double balance;
	
	// Constructor
	public Account(double initBalance) {
		balance = initBalance;
	}

	
	//Getter used to retreive balance
	public double getBalance() {
		return balance;
	}
	
	//Method used to increase balance amount
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	// Decreases the balance by amount
	public void withdraw(double amount) {
		if(amount>0) {
			balance -= amount;
		}
	}
	
	@Override
	public String toString() {
		String msg = "balance=$" + balance;
		return msg;
	}


	
	//Informal text code
	public static void main(String[] args) {
		Account a1 = new Account(1000.0);
		System.out.println("Balance=$" + a1.getBalance());
		a1.deposit(500.0);
		System.out.println("Balance=$" + a1.getBalance());
		a1.withdraw(200.0);
		System.out.println("Balance=$" + a1.getBalance());
		System.out.println(a1.toString());
		System.out.println(a1);

	}
}
