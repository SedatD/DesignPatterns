package adapter;

public class Main {

	public static void main(String[] args) {

		ITarget target = new Adapter(new Adaptee());
		target.request();

	}

}
