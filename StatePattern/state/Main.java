package state;

public class Main {

	public static void main(String[] args) {

		Gate gate = new Gate();

		gate.enter();
		gate.payFailed();
		gate.payOk();
		gate.enter();

		System.out.println("\n new scenario \n");

		gate.payFailed();
		gate.payOk();
		gate.payOk();
		gate.enter();
		gate.enter();

	}

}
