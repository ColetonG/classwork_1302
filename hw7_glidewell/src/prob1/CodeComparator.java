package prob1;

import java.util.Comparator;

public class CodeComparator implements Comparator<Product>{
	public int compare(Product e1, Product e2) {
		if(getFirst(e1).equals("QC") && (getFirst(e2).equals("DA") || getFirst(e2).equals("MZ"))) {
			return -1;
		}
		if(getFirst(e1).equals("DA")&& getFirst(e2).equals("QC")) {
			return 1;
		}
		if(getFirst(e1).equals("DA")&& getFirst(e2).equals("MZ")) {
			return -1;
		}
		if(getFirst(e1).equals("MZ") && (getFirst(e2).equals("QC") || getFirst(e2).equals("DA"))) {
			return 1;
		}
		else {
			String x = getLast(e1);
			String y = getLast(e2);
			return x.compareTo(y);  			
		}
		}


//----------------
// Helper Methods
//----------------

	public String getFirst(Product e) {
		return e.getCode().substring(0,2);
	}
	
	public String getLast(Product e) {
		return e.getCode().substring(3);
	}
}