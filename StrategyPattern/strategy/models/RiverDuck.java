package strategy.models;

import strategy.models.abstracts.Duck;

public class RiverDuck extends Duck {

	private float swimSpeed;

	public RiverDuck(String kind, int age, float swimSpeed) {
		super(kind, age);
		this.swimSpeed = swimSpeed;
	}

	@Override
	public void doFly() {
		System.out.println(kind + " : doing some RIVER fly");
	}

	@Override
	public String toString() {
		return "RiverDuck [swimSpeed=" + swimSpeed + ", toString()=" + super.toString() + "]";
	}

}
