package factory;

import factory.abstracts.AbstractFactory;
import factory.abstracts.Sedans;
import factory.abstracts.Trucks;
import factory.models.DodgeChallanger;
import factory.models.DodgeRam1500;

public class FactoryDodge extends AbstractFactory {

	@Override
	public Sedans makeSedan(int wheel, boolean diesel, boolean coupe) {
		// some logic // see FactoryFord makseSedan
		return new DodgeChallanger(this, 4, false, false);
	}

	@Override
	public Trucks makeTruck(int wheel, boolean diesel, int axles) {
		// some logic // see FactoryFord makseSedan
		return new DodgeRam1500(this, wheel, diesel, axles);
	}

}
