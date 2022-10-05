package prob1;

public class RedMartian extends Martian{
	private int tenasity;

	public RedMartian(int id, int tenasity) {
		super(id, 1);
		this.tenasity = tenasity;
	}
	
	public RedMartian(int id, int volume, int tenasity) {
		super(id, volume);
		this.tenasity = tenasity;
	}
	
	public int getTenacity() {
		return this.tenasity;
	}
	
	public String speak() {
		String msg = String.format("id=%d, Rubly Rock", getId());
		return msg;
	}
	
	@Override
	public String toString() {
		String msg = String.format("Red Martian - id=%d, vol=%d, ten=%d",
								   getId(), getVolume(), getTenacity());
		return msg;
	}
	
}
