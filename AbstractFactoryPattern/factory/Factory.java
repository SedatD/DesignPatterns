package factory;

import factory.abstracts.Sedans;
import factory.abstracts.Trucks;

public interface Factory {

	Sedans makeSedan(int wheel, boolean diesel, boolean coupe);

	Trucks makeTruck(int wheel, boolean diesel, int axles);

}
