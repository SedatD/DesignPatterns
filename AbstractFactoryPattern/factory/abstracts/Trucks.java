package factory.abstracts;

public abstract class Trucks extends Car {

	public int axles;

	public Trucks(int wheel, boolean diesel, int axles) {
		super(wheel, diesel);
		this.axles = axles;
	}

	public abstract String getName();

}
