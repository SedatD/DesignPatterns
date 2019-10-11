package factory.abstracts;

public abstract class AbstractFactory {

	public abstract Sedans makeSedan(int wheel, boolean diesel, boolean coupe);

	public abstract Trucks makeTruck(int wheel, boolean diesel, int axles);

}
