package factory.models;

import factory.FactoryDodge;
import factory.abstracts.Sedans;

public class DodgeChallanger extends Sedans {
	
	String type = "old";

	public DodgeChallanger(FactoryDodge factoryDodge, int wheel, boolean diesel, boolean coupe) {
		super(wheel, diesel, coupe);
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "DodgeChallanger [type=" + type + ", coupe=" + coupe + ", wheel=" + wheel + ", diesel=" + diesel + "]";
	}
	
}
