package prob4;

public class Engineer {
	
	//Instance Variables
	private String name;
	private double hours[];
	
	//Constructor
	public Engineer(String name, double[] hours) {
		this.name = name;
		this.hours = hours;
	}
	
	//Getter for name instance variable
	public String getName() {
		return name;
	}
	
	//Method
	public double getWages(double payRate) {
		double totalHours = 0.0;
		for(double h : hours) {
			totalHours += h;
		}
		double wages = totalHours*payRate;
		return wages;
	}
	
	//Method
	@Override
	public String toString() {
		return name;
	}
}


