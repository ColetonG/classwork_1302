package prob1;

public class Product {
	private String code; //Val0424200234
	private String plant;
	private String date;
	private int batch;
	
	public Product(String code) {
		this.code = code;
		this.plant = extractPlant();
		this.date = extractDate();
		this.batch = extractBatch();
	}
	
	//extract Methods
	private String extractPlant() {
		String empty ="";
		for(int i =0; i<3; i++) {
			if(!isNum(code.substring(i,i+1))) {
				empty += code.substring(i,i+1);
			}			
		}
		return empty;		
	}
	
	private String extractDate() {
		int plant = extractPlant().length();
		String fullDate = "";
		String date = code.substring(plant, plant+8 );
		fullDate += (date.substring(0,2) + "/" + date.substring(2,4) + "/" + date.substring(4));
		return fullDate;
	}
	
	private int extractBatch() {
		int plant = extractPlant().length();
		int y =Integer.parseInt(code.substring(plant+8));
		return y;
	}
	
	//getMethods
	public int getBatch() {
		return batch;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getPlant() {
		return plant;
	}
	
	public String getDate() {
		return date;
	}
	
	//Boolean testers
	public boolean isAfter2000() {
		boolean after2000 = true;
		int startDate = getPlant().length() + 4;
		int endDate = startDate + 4;
		int date = Integer.parseInt(code.substring(startDate, endDate));
		if (date < 2000) {
			after2000 = false;
		}
		return after2000;
	}
	
	public boolean isMonthEqual(int month) {
		boolean isMonth = false;
		int placer = extractPlant().length();
		String testMonth = code.substring(placer, placer + 2);
		int i = Integer.parseInt(testMonth);
		if (i == month) {
			isMonth = true;
		}
		return isMonth;
	}
	
	//toString
	@Override
	public String toString() {
		String summary = String.format("code=%s, plant=%s, date=%s, batch=%d",
				getCode(), getPlant(), getDate(), getBatch());
		return summary;
	}
	
	//Helper methods
	public boolean isNum (String e) {
		char k = e.charAt(0);
		return Character.isDigit(k);
	}
}
