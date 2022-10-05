package student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightManager {
	private AirportManager airportmanager;
	private Map<String, Flight> flights = new HashMap<>();
	
	FlightManager(AirportManager airportmanager){
		this.airportmanager = airportmanager;
	}
	
	public boolean addFlight(Flight flight){
		if(!flights.containsKey(flight.getNumber())) {
			flights.put(flight.getNumber(), flight);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addFlight(String number,String date,String originCode,
                             String destinationCode,double cost){
		Airport a1 = airportmanager.getAirport(originCode);
		Airport a2 = airportmanager.getAirport(destinationCode);
		LocalDate newDate = LocalDate.parse(date);
		Flight flight = new Flight(number, newDate, a1, a2, cost);
		return addFlight(flight);
	}
	
	public Flight getFlight(String number) {
		return flights.get(number);
	}
	
	public List<Flight> getFlightsByOrigin(String originCode){
		List<Flight> list = new ArrayList<>();
		for(Flight flight: flights.values()) {
			if(flight.getOrigin().getCode().equals(originCode)) {
				list.add(flight);
			}
		}
		return list;
	}
	
	public List<Flight> getFlightsByOrigin(String originCode, String date){
		List<Flight> list = new ArrayList<>();
		for(Flight flight: flights.values()) {
			if(flight.getOrigin().getCode().equals(originCode)) {
				if(flight.getDate().toString().equals(date)) {
					list.add(flight);
				}
			}
		}
		return list;
	}
	
	public List<Flight> getFlightsByOriginAndDestination(String originCode,
			String destinationCode, String date){
		List<Flight> list = new ArrayList<>();
		for(Flight flight: flights.values()) {
			if(flight.getOrigin().getCode().equals(originCode)) {
				if(flight.getDestination().getCode().equals(destinationCode)) {
					if(flight.getDate().toString().equals(date)) {
						list.add(flight);
					}
				}
			}
		}
		return list;
	}
	
	public int getNumFlights() {
		return flights.size();
	}
	
	public Flight removeFlight(String number) {
		return flights.remove(number);
	}
	
	public List<Flight> getFlights(){
		List<Flight> list =  new ArrayList<>(flights.values());
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
