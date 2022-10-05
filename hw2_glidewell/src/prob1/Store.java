package prob1;
import emps.Employee;

public class Store {
	private Employee[] emps = new Employee[20];
	private int numEmps;

	public Store() {
		this.numEmps = 0;
		
	}
	
	public void addEmployee(Employee e) {
		if(numEmps<emps.length) {
			emps[numEmps] = e;
			numEmps++;
		}
	}
	
	public Employee getEmployee(int i) {
		if(i>=0 && i<numEmps) {
			return emps[i];
		}
		else {return null;}
	}
	
	public Employee getEmployeeWithName(String e) {
		for(int i =0; i<numEmps; i++) {
			String testName = emps[i].getName();
			if(testName == e) {
				return emps[i];
			}
		}
		return null;
	}
	
	public int getNumEmployees() {
		return numEmps;
	}
	
	public double getTotalHours() {
		double totalHoursWorked = 0.0;
		for(int i =0; i<numEmps; i++) {
			totalHoursWorked += emps[i].getTotalHours();
		}
		return totalHoursWorked;
	}
	
	public double getTotalPay() {
		double totalPay = 0.0;
		for(int i =0; i<numEmps; i++) {
			totalPay += emps[i].getPay();
		}
		return totalPay;
	}
	
	public Employee removeEmployee(int i) {
		if(i>=0 && i<numEmps) {
			Employee returnEmployee = emps[i];
			for (int j=i+1; j<numEmps; j++) {
				emps[j-1]= emps[j];
			}
			numEmps--;
			return returnEmployee;
		}
		return null;	
	}
	
	@Override
	public String toString() {	
		String line1 = "Payroll Report";
		String line2= String.format("Num Employees:%d, total hrs:%.2f, total pay=$%.2f\n",
				getNumEmployees(), getTotalHours(), getTotalPay());
		int numEmps = getNumEmployees();
		String msg ="";
		for (int i =0; i<numEmps; i++) {
			msg += emps[i].toString() + "\n\n";
		}
		String fullString = line1+ "\n\n" + line2+ "\n" + msg;
		return fullString;
	}
	
	
}
