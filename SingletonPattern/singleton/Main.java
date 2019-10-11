package singleton;

public class Main {

	public static void main(String[] args) {

		Singleton instance1 = Singleton.getInstance();
		instance1.setName("first name");
		System.out.println("first obj : " + instance1);

		Singleton instance2 = Singleton.getInstance();
		instance2.setName("second name");
		System.out.println("second obj : " + instance2);

		System.out.println();
		System.out.println("see same objs");
		System.out.println("first obj : " + instance1);
		System.out.println("second obj : " + instance2);

	}

}
