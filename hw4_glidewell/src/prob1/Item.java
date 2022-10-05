package prob1;

public class Item {
 protected String name;
 protected double weight;
 
 public Item(String name, double weight) {
	 this.name = name;
	 this.weight = weight;
 }
 
 public double cost() {
	 return weight * 2;
 }
 
 public String getName() {
	 return name;
 }
 
 public double getWeight() {
	 return weight;
 }
 
 
 public boolean equals(Object o) {
	 if(o == this) {
		 return true;
	 }
	 else if(!(o instanceof Item)){
		 return false;
	 }
	 else {
		 Item p = (Item)o;
		 return p.getName().equals(this.name);
	 }
 }
 
 @Override
 public String toString() {
	 String msg = String.format("name=%s, cost=$%.2f, weight=%.2f", name, cost(), weight);
	 return msg;
 }
}
