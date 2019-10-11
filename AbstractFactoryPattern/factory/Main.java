package factory;

import factory.abstracts.AbstractFactory;
import factory.abstracts.Sedans;
import factory.abstracts.Trucks;

public class Main {

	public static void main(String[] args) {
		
		// https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

		AbstractFactory factoryDodge = FactoryProvider.getFactory("DODGE");
		AbstractFactory factoryFord = FactoryProvider.getFactory("FORD");

		Sedans makeSedan1 = factoryDodge.makeSedan(4, false, false);
		Trucks makeTruck1 = factoryDodge.makeTruck(8, true, 3);

		Sedans makeSedan2 = factoryFord.makeSedan(4, false, true);
		Trucks makeTruck2 = factoryFord.makeTruck(6, false, 2);

		System.out.println(makeSedan1.getName() + " : " + makeSedan1);
		System.out.println(makeTruck1.getName() + " : " + makeTruck1);
		System.out.println(makeSedan2.getName() + " : " + makeSedan2);
		System.out.println(makeTruck2.getName() + " : " + makeTruck2);

	}

}
