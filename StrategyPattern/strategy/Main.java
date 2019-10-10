package strategy;

import java.util.ArrayList;

import strategy.models.JungleDuck;
import strategy.models.RiverDuck;
import strategy.models.abstracts.Animal;
import strategy.models.abstracts.Duck;

public class Main {

	public static void main(String[] args) {

		Animal.staticMethod();

		Animal animal = new Duck("abstract", -1);
		animal.normalMethod();
		System.out.println();

		Duck basicDuck = new Duck("basic duck", 2);
		basicDuck.doQuack();
		basicDuck.doFly();
		System.out.println();

		JungleDuck jungleDuck = new JungleDuck("jungle duck", 3, true);
		jungleDuck.doQuack();
		jungleDuck.doFly();
		System.out.println();

		Duck riverDuck = new RiverDuck("river duck", 4, 5.3f);
		riverDuck.doQuack();
		riverDuck.doFly();
		System.out.println();

		System.out.println("printing by each");
		System.out.println(animal);
		System.out.println(basicDuck);
		System.out.println(jungleDuck);
		System.out.println(riverDuck);

		System.out.println();

		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(animal);
		animalList.add(basicDuck);
		animalList.add(jungleDuck);
		animalList.add(riverDuck);

		System.out.println("printing with animal");
		for (Animal a : animalList) {
			System.out.println(a);
		}

	}

}
