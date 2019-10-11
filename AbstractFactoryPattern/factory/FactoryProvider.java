package factory;

import factory.abstracts.AbstractFactory;

public class FactoryProvider {

	public static AbstractFactory getFactory(String make) {
		if (make.equalsIgnoreCase("FORD")) {
			return new FactoryFord();
		}
		if (make.equalsIgnoreCase("DODGE")) {
			return new FactoryDodge();
		}
		return null;
	}

}
