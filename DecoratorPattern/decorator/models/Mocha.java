package decorator.models;

import decorator.models.abstracts.Bevrage;

public class Mocha implements Bevrage {

	@Override
	public int cost() {
		return 3;
	}

	@Override
	public String description() {
		return "Mocha";
	}

}
