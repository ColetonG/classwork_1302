package student;

import java.time.LocalDate;

public class Flight {
	private double cost;
	private LocalDate date;
	private Airport destination;
	private double distance;
	private String number;
	private Airport origin;
	
	public Flight(String number,LocalDate date, Airport origin, Airport destination, 
			      double cost ) throws IllegalArgumentException {
		if(!isFlightNumValid(number)) {
			throw new IllegalArgumentException("Invalid flight number");
		}
		else {
		this.number = number;
		this.date = date;
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
		this.distance = DistanceCalculator.getDistance(origin.getLatitude(), origin.getLongitude(),
				destination.getLatitude(), destination.getLongitude());
		}
	}
	
	public double getCost() {
		return cost;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Airport getDestination() {
		return destination;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Airport getOrigin() {
		return origin;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	@Override
	public String toString() {
		String msg = "  Flight: " + number + ", Date: " + date + "\n";
		msg +=       "    From: " + origin.toString().substring(1, 17) + "\n";
		msg +=       "      To: " + destination.toString().substring(1, 17) + "\n";
		msg +=  String.format("Distance: %.2f, miles, Cost: $%.2f", getDistance(), cost);
		return msg;
	}
	
	private boolean isFlightNumValid(String number) {
		try {
			Integer.parseInt(number);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
//	private String location(Airport a) {
//		return null;
//	}
	
	
}