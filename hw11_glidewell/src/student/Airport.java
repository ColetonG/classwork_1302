package student;

public class Airport {
	private String city;
	private String code;
	private double latitude;
	private double longitude;
	private String state;
	
	protected Airport(String code) {
		this.code = code;
	}
	
	protected Airport(String code, double latitude, double longitude,
					  String city, String state) {
		this.code= code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.code.equals(((Airport)o).code);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public String getState() {
		return this.state;
	}
	
	@Override
	public String toString() {
		String output = String.format("(%s-%s, %s:  %.2f,   %.2f)",
		code, city, state, latitude,longitude);
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
}
