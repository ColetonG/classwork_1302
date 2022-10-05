package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AirportManager {
	private Map<String, Airport> airports;
	
	public AirportManager(Map<String, Airport> airports) {
		this.airports = airports;
	}
	
	public Airport getAirport(String code) {
		return airports.get(code);
	}
	
	public List<Airport> getAirports(){
		ArrayList<Airport> list = new ArrayList<>(airports.values());
		return list;
	}
	
	public List<Airport> getAirportByCity(String city){
		List<Airport> list = new ArrayList<>();
		for(Airport selected: airports.values()) {
			if(selected.getCity().equals(city)) {
				list.add(selected);
			}
		}
		return list;
	}
	
	public List<Airport> getAirportByCityState(String city, String state){
		List<Airport> list = new ArrayList<>();
		for(Airport selected: airports.values()) {
			if(selected.getCity().equals(city)) {
				if(selected.getState().equals(state)) {
					list.add(selected);
				}
			}
		}
		return list;
	} 
	
	public double getDistanceBetween(Airport airport1, Airport airport2) {
		double lat1 = airport1.getLatitude();
		double long1 = airport1.getLongitude();
		double lat2 = airport2.getLatitude();
		double long2 = airport2.getLongitude();
		double distance = DistanceCalculator.getDistance(lat1, long1, lat2, long2);
		return distance;
	}
	
	public double getDistanceBetween(String code1, String code2) {
		Airport airport1 = getAirport(code1);
		Airport airport2 = getAirport(code2);
		return getDistanceBetween(airport1, airport2);
	}
	
	public List<Airport> getNWSNamedAirports(){
		List<Airport> list = new ArrayList<>();
		for(Airport selected: airports.values()) {
			if(selected.getCode().charAt(2) == 'X') {
					list.add(selected);
				}
			}
		return list;
	}
	
	public List<Airport> getAirportsSortedBy(String sortType){
		List<Airport> list = new ArrayList<>(airports.values());
		if(sortType.equals("City")) {
			Collections.sort(list, new AirportCityComparator());
			return list;
		}
		else if(sortType.equals("State")) {
			Collections.sort(list, new AirportStateComparator());
			return list;
		}
		else {
			return null;
		}
	}
	
	public Airport getAirportClosestTo(String code) {
		Airport closest = new Airport("", Integer.MAX_VALUE, Integer.MAX_VALUE, "", "");
		airports.put(closest.getCode(), closest);
		for(Airport selected: airports.values()){
			String closeCode = closest.getCode();
			String selectedCode = selected.getCode();
			if(selectedCode.equals(code)){
				continue;
			}
			double airportToClosest = getDistanceBetween(code, closeCode);
			double airportToSelected = getDistanceBetween(code, selectedCode);
			if(airportToSelected < airportToClosest) {
				closest = selected;
			}
		}
		return closest;
	}
	
	public List<Airport> getAirportWithin(String code, double withinDist){
		List<Airport> within = new ArrayList<>();
		for(Airport airport: airports.values()) {
			double distance = getDistanceBetween(code, airport.getCode());
			if(airport.getCode().equals(code)) {
				continue;
			}
			if(distance <= withinDist) {
				within.add(airport);
			}
		}
		return within;
	}
	
	public List<Airport> getAirportWithin(String code1, String code2, double withinDist){
		List<Airport> list1 = getAirportWithin(code1, withinDist);
		List<Airport> list2 = getAirportWithin(code2, withinDist);
		List<Airport> combined = new ArrayList<>(list1);
		combined.retainAll(list2);
		return combined;
	}
	
	
	public List<Airport> getAirportsClosestTo(String code, int num) {
		List<Airport> returnList = new ArrayList<>();
		for(int i=0; i< num; i++) {
			Airport airport = getAirportClosestTo(code);
			returnList.add(airport);
			airports.remove(airport.getCode());
		}
		for(Airport air: returnList) {
			airports.put(air.getCode(), air);
		}
		return returnList;
	}
	
	public List<Airport> getAirportsWithin(double withinDist, double lat, double lon){
		List<Airport> list = new ArrayList<>();
		Airport dummy = new Airport("FAK", lat, lon, "fake", "fake");
		for(Airport sel: airports.values()) {
			double dist = getDistanceBetween(dummy, sel);
			if(dist <= withinDist) {
				list.add(sel);
				
			}
		}
		return list;
	}
}
