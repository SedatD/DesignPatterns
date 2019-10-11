package singleton;

public class Singleton {

	private static Singleton instance = null;
	
	private String name;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

	@Override
	public String toString() {
		return "Singleton [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
