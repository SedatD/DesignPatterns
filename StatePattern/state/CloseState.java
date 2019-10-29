package state;

public class CloseState implements GateState {

	private Gate gate;

	public CloseState(Gate g) {
		this.gate = g;
	}

	@Override
	public void enter() {
		System.out.println("gate is closed you cant pass");
		gate.changeState(new CloseState(gate));
	}

	@Override
	public void payOk() {
		System.out.println("gate is closed you paid successefully and gate is open now");
		gate.changeState(new OpenState(gate));
	}

	@Override
	public void payFailed() {
		System.out.println("gate is closed your payment failed and gate is still closed");
		gate.changeState(new CloseState(gate));
	}

}
