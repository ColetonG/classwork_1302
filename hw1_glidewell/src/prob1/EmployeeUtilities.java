package prob1;

public class EmployeeUtilities {
	
//	Constructor
	public EmployeeUtilities() {}
	
	public double getTotalPay(Employee[] emps) {
		double sum = 0;
		for(int i=0; i< emps.length; i++) {
			sum += emps[i].getPay();				
		}
		return sum;
	}
	
	public Employee getEmployeeWithMostHours(Employee[] emps) {
		Employee mostHours = emps[0];
		for (int i=1; i< emps.length; i++) {
			if(emps[i].getTotalHours() > mostHours.getTotalHours()) {
				mostHours = emps[i];
			}
		}
		return mostHours;
	}
	
	public double[] getHoursArray(Employee[] emps) {
		double[] hoursArray = new double[emps.length];
		for (int i =0; i< emps.length; i++) {
			hoursArray[i] = emps[i].getTotalHours();
		}
		return hoursArray;
	}
}
