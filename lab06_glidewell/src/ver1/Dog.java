package ver1;

public class Dog {
	protected String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String bark() {
		return "bark";
	}

	@Override
	public String toString() {
		return "Dog named " + name;
	}
}

