package prob1;
import java.util.ArrayList;

public class Warehouse {
	protected ArrayList<Item> vals = new ArrayList<>();
	private int numItems;
	
	public Warehouse(){}
	
	public boolean addItem(Item e) {
		if(vals.contains(e)) {
			return false;
		}
		else {
			vals.add(e);
			numItems++;
			return true;
		}
	}
	
	public Item getItem(int i) {
		if(i >= 0 && i < vals.size()) {
			return vals.get(i);
		}
		return null;
	}
	
	public Item getItem(String name) {
		Item dummy = new Item (name, 0);
		if(vals.contains(dummy)) {
			return vals.get(vals.indexOf(dummy));
			}
		return null;
	}
	
	public ArrayList<Item> getItemsWithName(String e){
		ArrayList<Item> newList = new ArrayList<>();
		for (int i =0; i<numItems;i++) {
			if(vals.get(i).getName().contains(e)) {
				newList.add(vals.get(i));
			}
		}
		return newList;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public double getAverageTemp() {
		double totalTemps = 0;
		double numOfTemps = 0;
		double average = 0;
		for(int i= 0; i<numItems; i++) {
			if(vals.get(i) instanceof RefrigeratedItem) {
				RefrigeratedItem x = (RefrigeratedItem)vals.get(i);
				totalTemps += x.getTemp();
				numOfTemps++;
			}
		average = totalTemps/numOfTemps;
		}
		return average;
	}
	
	public RefrigeratedItem[] getRefrigeratedItems() {
		int numR = 0;
		for(Item v: vals) {
			if(v instanceof RefrigeratedItem) {
				numR++;
			}
		}
		RefrigeratedItem[] rList = new RefrigeratedItem[numR];
		int loc = 0;
		for(int i=0; i< numItems; i++) {
			Item it = vals.get(i);
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
			double currCost = vals.get(i).cost();
			totalCost += currCost;
		}
		return totalCost;
	}
	
	public double getTotalRefrigeratedCost() {
		double totalCost =0;
		for(int i=0; i<numItems; i++) {
			if (vals.get(i) instanceof RefrigeratedItem) {
			double currCost = vals.get(i).cost();
			totalCost += currCost;
			}
		}
		return totalCost;
	}
	
	public Item removeItem(int e) {
		if(e>=0 && e<numItems) {
			Item returnItem = vals.get(e);
			vals.remove(e);
			numItems--;
			return returnItem;
		}
		return null;
	}
	
	public Item removeItem(String e) {
		Item dummy = new Item(e, 0);
		return removeItem(vals.indexOf(dummy));			
	}
	
	public boolean hasItem(String name) {
		Item dummy = new Item(name, 0);
		return vals.contains(dummy);
	}
	
	@Override
	public String toString() {
		String msg = "";
		for(int i=0; i<numItems; i++) {
			msg += vals.get(i).toString() + "\n";
		}
		return msg;
	}
}
