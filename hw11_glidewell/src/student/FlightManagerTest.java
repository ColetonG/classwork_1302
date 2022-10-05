package student;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightManagerTest {
	static final String path = "src/student/";
	static final String airportsSmallFileName = path + "airportsSmall.txt";
	static final String airportsMediumFileName = path + "airportsMedium.txt";
	static final String airportsSameCitiesFileName = path + "airportsSameCities.txt";
	static final String airportsAllFileName = path + "airports.txt";
	static final File airportsSmallFile = new File(airportsSmallFileName);
	static final File airportsMediumFile = new File(airportsMediumFileName);
	static final File airportsSameCitiesFile = new File(airportsSameCitiesFileName);
	static final File airportsAllFile = new File(airportsAllFileName);

	public static void main(String[] args) {		
		testAddFlight_OneParameter();
		testAddFlight_MultiParameter();
		testGetFlight();
		testGetFlightsByOrigon_OriginCode();
		testGetFlightsByOrigin_WithDate();
		testGetFlightsByOriginAndDestination();
		testGetNumFlights();
		testRemoveFlight();
	}

	public static void testAddFlight_OneParameter() {
		System.out.println("-->testAddFlight_OneParameter");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		Flight flight1 = new Flight("123", LocalDate.parse("2021-12-02"), vod.getAirport("AQQ"), vod.getAirport("BHM"), 144.55);
		flightManager.addFlight(flight1);	
		System.out.println("Test Succesful Flight Added:\n" + flightManager.getFlight("123").toString());
	}
	
	public static void testAddFlight_MultiParameter() {
		System.out.println("\n-->testAddFlight_MultiParameter");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);	
		System.out.println("Test Succesful Flight Added:\n" + flightManager.getFlight("123").toString());
	}
	
	public static void testGetFlight() {
		System.out.println("\n-->testGetFlight");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 1000.05);
		String ex = "Flight number 400 and it toSting";
		String ac = flightManager.getFlight("400").toString();
		String msg = String.format("Get flight number 400:\nExpected: %s"
				     + "\nActual: \n%s", ex, ac);
		System.out.println(msg);
	}
	
	public static void testGetFlightsByOrigon_OriginCode() {
		System.out.println("\n-->testGetFlightsByOrigon_OriginCode");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 1000.05);
		flightManager.addFlight("403", "2021-04-16", "TCL", "ATU", 1000.05);
		flightManager.addFlight("341", "2021-07-16", "AQQ", "ADK", 1000.05);
		flightManager.addFlight("416", "2021-04-16", "AQQ", "TCL", 1000.05);
		List<Flight> flights= flightManager.getFlightsByOrigin("AQQ");
		String msg = "Get flight by origin code \"AQQ\":\n";
		for(Flight flight: flights) {
			msg += flight.toString() + "\n"; 
		}
		System.out.println(msg);
	}
	
	public static void testGetFlightsByOrigin_WithDate() {
		System.out.println("\n-->testGetFlightsByOrigin_WithDate");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 165.95);
		flightManager.addFlight("403", "2021-04-16", "TCL", "ATU", 1000.05);
		flightManager.addFlight("341", "2021-07-16", "AQQ", "ADK", 10.05);
		flightManager.addFlight("416", "2021-04-16", "AQQ", "TCL", 20000.05);
		flightManager.addFlight("183", "2021-04-16", "AQQ", "TCL", 100.05);
		flightManager.addFlight("241", "2021-04-16", "TCL", "AQQ", 100.05);
		List<Flight> flights= flightManager.getFlightsByOrigin("TCL", "2021-04-16");
		String msg = "Get flight by origin code \"TCL\" on Date \"2021-04-16\":\n";
		for(Flight flight: flights) {
			msg += flight.toString() + "\n"; 
		}
		System.out.println(msg);
	}
	
	public static void testGetFlightsByOriginAndDestination() {
		System.out.println("\n-->testGetFlightsByOriginAndDestination");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("43", "2021-04-16", "AQQ", "TCL",  40.85); //this one
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 165.95);
		flightManager.addFlight("403", "2021-04-16", "TCL", "ATU", 1000.05);
		flightManager.addFlight("341", "2021-07-16", "AQQ", "ADK", 10.05);
		flightManager.addFlight("416", "2021-04-16", "AQQ", "TCL", 20000.05);//this one
		flightManager.addFlight("183", "2021-04-16", "AQQ", "TCL", 100.05);//and this one
		flightManager.addFlight("241", "2021-04-16", "TCL", "AQQ", 100.05);
		List<Flight> flights= flightManager.getFlightsByOriginAndDestination("AQQ", "TCL", "2021-04-16");
		String msg = "Get flight from \"AQQ\" to \"TLC\" on \"2021-04-16\":\n";
		for(Flight flight: flights) {
			msg += flight.toString() + "\n"; 
		}
		System.out.println(msg);
	}
	
	public static void testGetNumFlights() {
		System.out.println("\n-->testGetNumFlights");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("43", "2021-04-16", "AQQ", "TCL",  40.85); //this one
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 165.95);
		flightManager.addFlight("403", "2021-04-16", "TCL", "ATU", 1000.05);
		flightManager.addFlight("341", "2021-07-16", "AQQ", "ADK", 10.05);
		flightManager.addFlight("416", "2021-04-16", "AQQ", "TCL", 20000.05);//this one
		flightManager.addFlight("183", "2021-04-16", "AQQ", "TCL", 100.05);//and this one
		flightManager.addFlight("241", "2021-04-16", "TCL", "AQQ", 100.05);
		int ex = 8;
		int ac = flightManager.getNumFlights();
		String msg = String.format("Get number of flights:\n Expected: %d\n Actual: %d", ex, ac);
		System.out.println(msg);
	}
	
	public static void testRemoveFlight() {
		System.out.println("\n-->testRemoveFlight");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		FlightManager flightManager = new FlightManager(vod);
		flightManager.addFlight("123", "2021-12-02", "AQQ", "BHM", 144.55);
		flightManager.addFlight("43", "2021-04-16", "AQQ", "TCL",  40.85); //this one
		flightManager.addFlight("400", "2021-04-16", "TCL", "ADK", 165.95);
		flightManager.addFlight("403", "2021-04-16", "TCL", "ATU", 1000.05);
		List<Flight> before = flightManager.getFlights();
		String start = "";
		for(Flight flight: before) {
			start += flight.toString() + "\n";
		}
		flightManager.removeFlight("43");
		List<Flight> after = flightManager.getFlights();
		String end = "";
		for(Flight flight: after) {
			end += flight.toString() + "\n";
		}
		String msg = String.format("Flights before removal:\n%s\nFlights afterremoval (43):\n%s", start, end);
		System.out.println(msg);
	}
}


