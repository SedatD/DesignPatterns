package decorator.models;

import decorator.models.abstracts.Bevrage;

public class Latte implements Bevrage {

	@Override
	public int cost() {
		return 4;
	}

	@Override
	public String description() {
		return "Latte";
	}

}
