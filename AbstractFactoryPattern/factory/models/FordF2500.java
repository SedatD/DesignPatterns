package factory.models;

import factory.FactoryFord;
import factory.abstracts.Trucks;

public class FordF2500 extends Trucks {

	int horsePower = 2500;

	public FordF2500(FactoryFord factoryFord, int wheel, boolean diesel, int axles) {
		super(wheel, diesel, axles);
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "FordF2500 [horsePower=" + horsePower + ", axles=" + axles + ", wheel=" + wheel + ", diesel=" + diesel
				+ "]";
	}

}
