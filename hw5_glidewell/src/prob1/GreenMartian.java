package prob1;

public class GreenMartian extends Martian implements Teleporter{

	public GreenMartian(int id) {
		super(id, 1);
	}
	
	public GreenMartian(int id, int volume) {
		super(id, volume);
	}
	
	@Override
	public String speak() {
		return "id=" + getId() + ", Grobldy Grock";
	}
		
	@Override
	public String teleport(String dest) {
		return "id=" + getId() + ", teleporting to " + dest;
	}
	
	@Override
	public String toString() {
		return "Green Martian - id=" + getId() + ", vol=" + getVolume();
	}
}
