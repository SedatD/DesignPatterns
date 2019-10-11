package factory.models;

import factory.FactoryFord;
import factory.abstracts.Sedans;

public class FordMustang extends Sedans {

	boolean GT = true;

	public FordMustang(FactoryFord factoryFord, int wheel, boolean diesel, boolean coupe, boolean GT) {
		super(wheel, diesel, coupe);
		this.GT = GT;
	}

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "FordMustang [GT=" + GT + ", coupe=" + coupe + ", wheel=" + wheel + ", diesel=" + diesel + "]";
	}

}
