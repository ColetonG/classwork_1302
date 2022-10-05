package prob1;

public class Warehouse {
	protected Item[] items = new Item[10];
	private int numItems;
	
	public Warehouse(){}
	
	public void addItem(Item e) {
		if(numItems < items.length) {
			items[numItems++] = e;		
		}
	}
	
	public Item getItem(int i) {
		if(i>=0 && i<numItems) {
			return items[i];
		}
		else {return null;}
	}
	
	public Item getItem(String name) {
		for(int i =0; i<numItems; i++) {
			String testName = items[i].getName();
			if(testName == name) {
				return items[i];
			}
		}
		return null;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public double getAverageTemp() {
		double totalTemps = 0;
		double numOfTemps = 0;
		double average = 0;
		for(int i= 0; i<numItems; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				RefrigeratedItem x = (RefrigeratedItem)items[i];
				totalTemps += x.getTemp();
				numOfTemps++;
			}
		average = totalTemps/numOfTemps;
		}
		return average;
	}
	
	public RefrigeratedItem[] getRefrigeratedItems() {
		int numR = 0;
		for(Item v: items) {
			if(v instanceof RefrigeratedItem) {
				numR++;
			}
		}
		RefrigeratedItem[] rList = new RefrigeratedItem[numR];
		int loc = 0;
		for(int i=0; i< numItems; i++) {
			Item it = items[i];
			if( it instanceof RefrigeratedItem) {				
				rList[loc] = (RefrigeratedItem) it;
				loc++;
			}
		}
		return rList;
	}
	
	public double getTotalCost() {
		double totalCost = 0;
		for(int i=0; i<numItems; i++) {
			double currCost = items[i].cost();
			totalCost += currCost;
		}
		return totalCost;
	}
	
	public double getTotalRefrigeratedCost() {
		double totalCost =0;
		for(int i=0; i<numItems; i++) {
			if (items[i] instanceof RefrigeratedItem) {
			double currCost = items[i].cost();
			totalCost += currCost;
			}
		}
		return totalCost;
	}
	
	public Item removeItem(int e) {
		if(e>=0 && e<numItems) {
			Item returnItem = items[e];
			for (int j=e+1; j<numItems; j++) {
				items[j-1]= items[j];
			}
			numItems--;
			return returnItem;
		}
		return null;
	}
	
	public Item removeItem(String e) {
		for(int i=0; i<numItems; i++) {
			String c = items[i].getName();
			if(e.equals(c)) {
				Item returnItem = items[i];
				for (int j=i+1; j<numItems; j++) {
					items[j-1]= items[j];
				}
				numItems--;
				return returnItem;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String msg = "";
		for(int i=0; i<numItems; i++) {
			msg += items[i].toString() + "\n";
		}
		return msg;
	}
}
