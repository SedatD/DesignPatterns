package strategy.models.abstracts;

public abstract class Animal {

	protected String kind;

//	public Animal() {
//
//	}

	public Animal(String kind) {
		this.kind = kind;
	}

	public static void staticMethod() {
		System.out.println("I'm static method in abstract Animal class and i called WITHOUT instance");
	}

	public void normalMethod() {
		System.out.println("normal method called with instance");
	}

	@Override
	public String toString() {
		return "Animal [kind=" + kind + "]";
	}

}
