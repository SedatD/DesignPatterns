package decorator.models.decorators;

import decorator.AddonDecorator;
import decorator.models.abstracts.Bevrage;

public class Caramel extends AddonDecorator {

	Bevrage bevrage;

	public Caramel(Bevrage b) {
		this.bevrage = b;
	}

	@Override
	public int cost() {
		return this.bevrage.cost() + 2;
	}

	@Override
	public String description() {
		return "Caramel " + this.bevrage.description();
	}

}
