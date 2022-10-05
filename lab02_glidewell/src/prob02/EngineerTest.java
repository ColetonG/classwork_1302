package prob02;

public class EngineerTest {
	public static void main(String[] args) {
		double[] hours = {8.0,8.0,8.0,8.0,8.0,0,0};
		
		//Call the constructor to create an Engineer object named: "e"
		Engineer e = new Engineer("Wilma", hours);
		
		//Call the getWages method on e
		double wages = e.getWages(20.0);
		String msg = e.getName() + "made $" + wages;
		System.out.println(msg);
	}
}
