package decorator;

import decorator.models.Latte;
import decorator.models.Mocha;
import decorator.models.abstracts.Bevrage;
import decorator.models.decorators.Caramel;
import decorator.models.decorators.Chocolate;

public class Main {

	public static void main(String[] args) {

		System.out.println("Mocha : " + new Mocha().cost());
		System.out.println("Latte : " + new Latte().cost());

		Bevrage bevrage1 = new Caramel(new Mocha());
		Bevrage bevrage2 = new Caramel(new Latte());
		Bevrage bevrage3 = new Chocolate(new Mocha());
		Bevrage bevrage4 = new Chocolate(new Latte());

		System.out.println(bevrage1.description() + " : " + bevrage1.cost());
		System.out.println(bevrage2.description() + " : " + bevrage2.cost());
		System.out.println(bevrage3.description() + " : " + bevrage3.cost());
		System.out.println(bevrage4.description() + " : " + bevrage4.cost());

	}

}
