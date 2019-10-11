package factory.abstracts;

public abstract class Sedans extends Car {
	
	public boolean coupe;
	
	public Sedans(int wheel, boolean diesel, boolean coupe) {
		super(wheel, diesel);
		this.coupe = coupe;
	}

	public abstract String getName();

}
