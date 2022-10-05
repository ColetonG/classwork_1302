package student;

import java.util.Comparator;

public class AirportStateComparator implements Comparator<Airport>{
	@Override
	public int compare(Airport a1, Airport a2) {
		int diff = a1.getState().compareTo(a2.getState());
		if(diff != 0) {
			return diff;
		}
		else {
			return a1.getCity().compareTo(a2.getCity());
		}
	}

}
