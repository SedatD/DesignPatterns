package factory;

import factory.abstracts.AbstractFactory;
import factory.abstracts.Sedans;
import factory.abstracts.Trucks;
import factory.models.FordF2500;
import factory.models.FordMustang;

public class FactoryFord extends AbstractFactory {

	@Override
	public Sedans makeSedan(int wheel, boolean diesel, boolean coupe) {

		boolean haveEnoughGTEngine = true; // check db for making GT Mustang or regular Mustang

		if (haveEnoughGTEngine)
			return new FordMustang(this, wheel, diesel, coupe, true);
		else
			return new FordMustang(this, wheel, diesel, coupe, false);
	}

	@Override
	public Trucks makeTruck(int wheel, boolean diesel, int axles) {
		// some logic // see FactoryFord makseSedan
		return new FordF2500(this, wheel, diesel, axles);
	}

}
