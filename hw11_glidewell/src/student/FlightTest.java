package student;

import java.time.LocalDate;

public class FlightTest {
	public static void main(String[] args) {
		testFlightValid_Number();
		testFlightInvalid_Number();
		testToString();
	}
	
	public static void testFlightValid_Number() {
		System.out.println("-->testFlightValid_Number");
		Airport air1 = new Airport("GAA", 44, 55, "Atlanta", "GA");
		Airport air2 = new Airport("NAA", 38.2, 50.1, "Seattle", "WA");
		try {
			Flight flight = new Flight ("123",LocalDate.now(), air1, air2, 
				      					166.20);
			System.out.println("No error thrown, Flight created succesfully\n"
					+ "Flight number: " + flight.getNumber());
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("Error thrown flight number invalid");
			}
	}
	
	public static void testFlightInvalid_Number() {
		System.out.println("\n-->testFlightValid_Number");
		Airport air1 = new Airport("GAA", 44, 55, "Atlanta", "GA");
		Airport air2 = new Airport("NAA", 38.2, 50.1, "Seattle", "WA");
		try {
		Flight flight = new Flight ("1A3",LocalDate.now(), air1, air2, 
			      					166.20);
		System.out.println("No error thrown, Flight created succesfully\n"
				+ "Flight number: " + flight.getNumber());
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Error thrown flight number invalid");
		}
	}
	
	public static void testToString() {
		System.out.println("\n-->testFlightValid_Number");
		Airport air1 = new Airport("GAA", 44, 55, "Atlanta", "GA");
		Airport air2 = new Airport("NAA", 38.2, 50.1, "Seattle", "WA");
		Flight flight = new Flight ("153",LocalDate.now(), air1, air2, 
			      					166.20);
		String msg = flight.toString();
		System.out.println(msg);
	}
	
	
}
