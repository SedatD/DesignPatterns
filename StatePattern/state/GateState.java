package state;

public interface GateState {

	public void enter();

	public void payOk();

	public void payFailed();

}
