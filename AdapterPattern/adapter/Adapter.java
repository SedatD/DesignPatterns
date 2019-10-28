package adapter;

public class Adapter implements ITarget {

	private Adaptee adaptee;

	public Adapter(Adaptee a) {
		this.adaptee = a;
	}

	@Override
	public void request() {
		System.out.println("request");

		adaptee.specificRequest();

		Adaptee.specificStaticRequest();
	}

}
