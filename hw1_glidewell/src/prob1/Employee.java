package prob1;

public class Employee {
	private double[] hours = new double[7];
	private String name;
	private double payRate;
	
	//Create Employee
	public Employee(String name, double payRate) {
		this.name = name;
		this.payRate = payRate;
	}
	
	//Return name
	public String getName() {
		return name;
	}
	
	//Set hours
	public void setHours(int day, double hours) {
		this.hours[day] = hours;
	}
	
	//get number of days worked
	public int getNumDaysWorked() {
		int totalDays = 0;
		for(int i=0; i<7; i++ ) {
			if(hours[i]>0) {
				totalDays++;
			}
		}
		return totalDays;
	}
	
	//total hours
	public double getTotalHours() {
		int totalHours = 0;
		for (int i=0; i<7; i++) {
			totalHours += hours[i];
		}
		return totalHours;
	}
	
	//Get weekday hours (0-4) & weekend (5-6)
	public double getWeekdayHours() {
		int weekHours = 0;
		for (int i=0; i<5; i++) {
			weekHours += hours[i];
		}
		return weekHours;
	}
	public double getWeekendHours() {
		int weekendHours = 0;
		for (int i=5; i<7; i++) {
			weekendHours += hours[i];
		}
		return weekendHours;
	}
	
	//Reseting week
	public void newWeek() {
		for(int i =0; i<7; i++) {
			hours[i] = 0;
		}
	}
	
	//merge employee
	public void mergeEmployee(Employee e) {		
		for(int i=0; i<7; i++) {
			hours[i]+= e.hours[i];
		}
	}
	
	//Find total pay for week
	public double getPay() {
		int sum = 0;
		double weekHours = getWeekdayHours();
		int daysWorked = getNumDaysWorked();
		if (weekHours > 40) {
			sum += (payRate * 40) + ((weekHours-40)*(payRate*1.5));
		}
		else {
			sum += (payRate * weekHours);
		}
		for (int i=5; i<7; i++) {
			sum += (2 * payRate * hours[i]);
		}
		if (daysWorked == 7){
			sum += 50;
		}
		return sum;
	}
	
	@Override
	public String toString() {
		int days = getNumDaysWorked();
		double sumHours = getTotalHours();
		double weekHours = getWeekdayHours();
		double weekendHours = getWeekendHours();
		double totalPay = getPay();
		String PayStub = String.format("Pay Stub\n"
				+ "--------\n"
				+ "Name:%s, Pay Rate $%.2f\n"
				+ "Hours:Mon:%.2f Tue:%.2f Wed:%.2f Thur:%.2f Fri:%.2f Sat:%.2f Sun:%.2f\n"
				+ "Days worked:%d, Total Hours:%.2f\n"
				+ "Weekday hours:%.2f, Weekend hours: %.2f\n"
				+ "Total pay: $%.2f",
				name,payRate,hours[0],hours[1],hours[2],hours[3],hours[4],hours[5],hours[6],
				days, sumHours, weekHours, weekendHours, totalPay);
		return PayStub;
	}	
	
	
}
