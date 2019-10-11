package factory.models;

import factory.FactoryDodge;
import factory.abstracts.Trucks;

public class DodgeRam1500 extends Trucks {
	
	int horsePower = 1500;

	public DodgeRam1500(FactoryDodge factoryDodge, int wheel, boolean diesel, int axles) {
		super(wheel, diesel, axles);
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "DodgeRam1500 [horsePower=" + horsePower + ", axles=" + axles + ", wheel=" + wheel + ", diesel=" + diesel
				+ "]";
	}

}
