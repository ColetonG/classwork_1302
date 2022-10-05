package prob1;

public class Car {
	private double fuelCapacity;
	private double fuelEfficiency;
	private double fuelLevel;
	private double totalDistance;
	
	
	//get functions	
	public double getfuelCapacity() {
		return fuelCapacity;
	}
	
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	
	public double getFuelLevel() {
		return fuelLevel;
	}
	
	public double getTotalDistance() {
		return totalDistance;
	}
	
	//Two variable Car constructor
	public Car (double fuelCapacity, double fuelEfficiency) {
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		fuelLevel = 0;
		totalDistance = 0;
	}
	
	//Three variable constructor
	public Car (double fuelCapacity, double fuelEfficiency, double fuelLevel) {
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		this.fuelLevel = fuelLevel;
		totalDistance = 0;
	}
	
	// toString
	@Override
	public String toString() {
		double var1 = getFuelLevel();
		double var2 = getTotalDistance();
		double var3 = getfuelCapacity();
		double var4 = getFuelEfficiency();
		String text = String.format("fuelLevel=%.1f, totalDistance=%.1f, "
				+ "fuelCapacity=%.1f, fuelEfficiency=%.1f ", var1, var2, var3, var4);
		return text;
	}
	
	//adding fuel to the tank (don't overflow)
	public void fillUp(double amount) {
		fuelLevel = fuelLevel + amount;
		if (fuelLevel > fuelCapacity) {
			fuelLevel = fuelCapacity;
		}		
	}
	
	//Driving the car
	public void drive(double time, double rate) {
		double milesPossible = fuelEfficiency * fuelLevel;
		double milesAttempted = time * rate;
		if(milesAttempted > milesPossible) {
			fuelLevel = 0;
			totalDistance += milesPossible;
		}
		else {
			fuelLevel = (milesPossible-milesAttempted)/fuelEfficiency;
			totalDistance += milesAttempted;
		}
	}
	
	//
}
