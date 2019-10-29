package state;

public class OpenState implements GateState {

	private Gate gate;

	public OpenState(Gate g) {
		this.gate = g;
	}

	@Override
	public void enter() {
		System.out.println("gate is open and you just entered. and gate closed now");
		gate.changeState(new CloseState(gate));
	}

	@Override
	public void payOk() {
		System.out.println("gate is already open you dont need to pay again");
		gate.changeState(new OpenState(gate));
	}

	@Override
	public void payFailed() {
		System.out.println("gate is already open and your payment just failed but gate still open");
		gate.changeState(new CloseState(gate));
	}

}
