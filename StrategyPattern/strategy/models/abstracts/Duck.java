package strategy.models.abstracts;

import strategy.interfaces.Fly;
import strategy.interfaces.Quack;

public class Duck extends Animal implements Quack, Fly {

	private int age;

	public Duck(String kind, int age) {
		super(kind);
		this.age = age;
	}

	@Override
	public void doQuack() {
		System.out.println(kind + " : doing some basic quack");
	}

	@Override
	public void doFly() {
		System.out.println(kind + " : doing some basic fly");
	}

	@Override
	public String toString() {
		return "Duck [age=" + age + ", toString()=" + super.toString() + "]";
	}

}
