package student;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AirportManagerTest {
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
		testManagerConstructor();
		testGetAirport();
		testGetAirports_Small();
		testGetDistanceBetween_Airport();
		testGetDistanceBetween_Code();
		testGetAirportsByCity();
		testGetAirportsByCityState();
		testGetNWSNamedAirports();
		testGetAirportsSortedBy_City();
		testGetAirportsSortedBy_State();
		testGetAirportClosestTo();
		testGetAirportWithin_OneCode();
		testGetAirportWithin_TwoCode();
		testGetAirportsClosestTo_Integer();
		testGetAirportsWithin();
	}
	
	public static void testManagerConstructor() {
		System.out.println("-->testManagerConstructor");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager vod = new AirportManager(airports);
		vod.getAirport("AQQ");
		System.out.println("Manager constructed named: vod");
	}

	public static void testGetAirport() {
		System.out.println("\n-->testGetAirport");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager vod = new AirportManager(airports);
		String ex = "(VLD-Valdosta, GA:  30.78, 83.28)";
		String ac = vod.getAirport("VLD").toString();
		String msg = String.format("Find airport code VLD\n"
				     + "Expected output: %s\nActual output: %s", ex, ac);
		System.out.println(msg);
	}
	
	public static void testGetAirports_Small() {
		System.out.println("\n-->testGetAirports");
		System.out.println("List of airport:");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> list = vod.getAirports();
		Iterator<Airport> iter = list.iterator();
		while(iter.hasNext()) {
			Airport airport = iter.next();
			String msg = airport.toString();
			System.out.println(msg);
		}
	}
	
	public static void testGetDistanceBetween_Airport() {
		System.out.println("\n-->testGetDistanceBetween_Airport");
		System.out.println("Test distance between BHM and AQQ:");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager vod = new AirportManager(airports);
		double ex = 283.93;
		double ac = vod.getDistanceBetween(vod.getAirport("BHM"), vod.getAirport("AQQ"));
		String msg = String.format("Expected distance: %.2f\nActual distance: %.2f", ex, ac);
		System.out.println(msg);
	}
	
	public static void testGetDistanceBetween_Code() {
		System.out.println("\n-->testGetDistanceBetween_Code");
		System.out.println("Test distance between NSE and ABY:");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager vod = new AirportManager(airports);
		double ex = 177.04;
		double ac = vod.getDistanceBetween("NSE", "ABY");
		String msg = String.format("Expected distance: %.2f\nActual distance: %.2f", ex, ac);
		System.out.println(msg);
	}
	
	public static void testGetAirportsByCity() {
		System.out.println("\n-->testGetAirportsByCity");
		System.out.println("Test get airports with city \"Greenville\" total(5):");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSameCitiesFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> sameCities = vod.getAirportByCity("Greenville");
		String msg = "";
		for(Airport airport: sameCities) {
			msg += airport.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportsByCityState() {
		System.out.println("\n-->testGetAirportsByCityState");
		System.out.println("Test get airports with city \"Greenville\" "
				           + "and state \"SC\" total(2):");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSameCitiesFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> sameCitiesState = vod.getAirportByCityState("Greenville", "SC");
		String msg = "";
		for(Airport airport: sameCitiesState) {
			msg += airport.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetNWSNamedAirports() {
		System.out.println("\n-->testGetNWSNamedAirports");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> nsw = vod.getNWSNamedAirports();
		String msg = "";
		for(Airport airport: nsw) {
			msg += airport.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportsSortedBy_City() {
		System.out.println("\n-->testGetNWSNamedAirports");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> sorted = vod.getAirportsSortedBy("City");
		String msg = "";
		for(Airport airport: sorted) {
			msg += airport.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportsSortedBy_State() {
		System.out.println("\n-->testGetNWSNamedAirports");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> sorted = vod.getAirportsSortedBy("State");
		String msg = "";
		for(Airport airport: sorted) {
			msg += airport.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportClosestTo(){
		System.out.println("\n-->testGetAirportClosestTo");
		System.out.println("Get airport closest to \"53Q\":");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		Airport closest = vod.getAirportClosestTo("53Q");
		String ex = "(51Q-SanFrancisco, CA:  37.75,   122.68)";
		String ac = closest.toString();
		String msg = String.format("Expected airport: %s\n"
				                   +"Actual airport: %s", ex, ac);
		System.out.println(msg);
	}
	
	public static void testGetAirportWithin_OneCode() {
		System.out.println("\n-->testGetAirportWithin_OneCode");
		System.out.println("Get airports within distanceof \"AQQ\" distance: 166.16");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> list = vod.getAirportWithin("AQQ", 166.16);
		String msg = "";
		for(Airport selected: list) {
			msg += selected.toString() + "	distance between: " + 
		    vod.getDistanceBetween(selected, vod.getAirport("AQQ")) + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportWithin_TwoCode() {
		System.out.println("\n-->testGetAirportWithin_TwoCode");
		System.out.println("Get airports within distanceof \"ANB\" and \"VLD\" distance: 150.00");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> list = vod.getAirportWithin("ANB", "VLD", 150);
		String msg = "";
		for(Airport selected: list) {
			msg += selected.toString() + "\n";
		}
		System.out.println(msg);
	}

	
	public static void testGetAirportsClosestTo_Integer() {
		System.out.println("\n-->testGetAirportsClosestTo");
		System.out.println("Get 3 airports closest to \"AQQ\" result:");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> list = vod.getAirportsClosestTo("AQQ", 3);
		String msg = "";
		for(Airport selected: list) {
			msg += selected.toString() + "\n";
		}
		System.out.println(msg);
	}
	
	public static void testGetAirportsWithin() {
		System.out.println("\n-->testGetAirportsWithin");
		double withinDist = 100;
		double lat = 34.6;
		double lon = 84.6;
		String start = "Get airports within 100 of (" + lat +"," + lon +"):\n";
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager vod = new AirportManager(airports);
		List<Airport> list = vod.getAirportsWithin(withinDist, lat, lon);
		String msg = "";
		for(Airport airport: list) {
			msg += airport.toString() + "\n";
		}
		System.out.println(start+ msg);
	}	
	
}
