package decorator;

import decorator.models.abstracts.Bevrage;

public abstract class AddonDecorator implements Bevrage {

	public abstract int cost();

	public abstract String description();

}
