package state;

public class Gate {

	private GateState gateState;

	public Gate() {
		this.gateState = new CloseState(this);
	}

	public void changeState(GateState gs) {
		this.gateState = gs;
	}

	public void enter() {
		this.gateState.enter();
	}

	public void payOk() {
		this.gateState.payOk();
	}

	public void payFailed() {
		this.gateState.payFailed();
	}

}
