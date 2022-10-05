package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirportLoader {
	
	public static Map<String, Airport> getAirportMap(File airportFile){
		Map<String, Airport> map = new HashMap<>();
		try {
			Scanner input = new Scanner(airportFile);
			while(input.hasNext()){
				String line = input.nextLine();
				String[] tokens = line.split("[\\s]+");
				String code = tokens[0];
				double latitude = Double.parseDouble(tokens[1]);
				double longitude = Double.parseDouble(tokens[2]);
				String city = tokens[3];
				String state = tokens[4];
				Airport airport = new Airport(code, latitude, longitude, city, state);
				map.put(airport.getCode(), airport);
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.print(e);			
		}
		return map;
	}
	
}
