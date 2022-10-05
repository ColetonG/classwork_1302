package animals2;

public class Bird extends Animal implements Flyer{
	public Bird(String name) {
		super(name);
	}

	public String makeSound() {
		return "Chirp";
	}

	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "bird flap-flap";
	}
}

