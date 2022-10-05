package prob3;

public class Worker {
	private String firstName;

	public Worker(String name) {
		super();
		this.firstName = name;
	}

	
	public String getName() { 
		return firstName;	
	}
	 

	public void setName(String name) {
		this.firstName = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + firstName + "]";
	}
}
