package factory.abstracts;

public abstract class Car {

	public int wheel;
	public boolean diesel;

	public Car(int wheel, boolean diesel) {
		this.wheel = wheel;
		this.diesel = diesel;
	}

	abstract String getName();

}
