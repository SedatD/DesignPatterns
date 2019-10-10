package decorator.models.decorators;

import decorator.AddonDecorator;
import decorator.models.abstracts.Bevrage;

public class Chocolate extends AddonDecorator {

	Bevrage bevrage;

	public Chocolate(Bevrage b) {
		this.bevrage = b;
	}

	@Override
	public int cost() {
		return this.bevrage.cost() + 2;
	}

	@Override
	public String description() {
		return "Chocolate " + this.bevrage.description();
	}

}
