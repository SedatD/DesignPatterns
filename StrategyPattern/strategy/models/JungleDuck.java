package strategy.models;

import strategy.models.abstracts.Duck;

public class JungleDuck extends Duck {

	private boolean jungling;

	public JungleDuck(String kind, int age, boolean jungling) {
		super(kind, age);
		this.jungling = jungling;
	}

	@Override
	public void doFly() {
		System.out.println(kind + " : doing some JUNGLE fly");
	}

	@Override
	public String toString() {
		return "JungleDuck [jungling=" + jungling + ", toString()=" + super.toString() + "]";
	}

}
