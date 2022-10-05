package prob1;

public abstract class Martian implements Comparable<Martian>{
	private int id;
	private int volume;
	
	public Martian(int id, int volume) {
		this.id = id;
		this.volume = volume;
	}
	
	public int compareTo(Martian m) {
		return this.id - m.id;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.id == ((Martian)o).id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public abstract String speak();
			
	}
