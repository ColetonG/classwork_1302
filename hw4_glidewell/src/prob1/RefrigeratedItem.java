package prob1;

public class RefrigeratedItem extends Item{
	protected double temp;
	
	public RefrigeratedItem (String name, double weight, double temp) {
		super(name, weight);
		this.temp = temp;
	}
	
	public RefrigeratedItem (Item item, double temp){
		super(item.getName(), item.getWeight());
		this.temp = temp;
	}
	
	@Override
	public double cost() {
		return (2*weight)+(100-temp)*0.1;
	}
	
	public double getTemp() {
		return temp;
	}
	
	@Override
	public String toString() {
		String msg = String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees", name, cost(), weight, temp);
		return msg;
	}	
}
