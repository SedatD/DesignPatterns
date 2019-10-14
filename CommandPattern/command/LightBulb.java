package command;

public class LightBulb {

	private boolean status;
	private int dim;

	public LightBulb(boolean status, int dim) {
		this.status = status;
		this.dim = dim;
	}

	public void lightsOn() {
		this.status = true;
		System.out.println("lights are on");
	}

	public void lightsOff() {
		this.status = false;
		System.out.println("lights are off");
	}

	public void lightDimUp() {
		this.dim += 5;
		System.out.println("lights are increased");
	}

	public void lightDimDown() {
		this.dim -= 10;
		System.out.println("lights are decreased");
	}

	@Override
	public String toString() {
		return "LightBulb [status=" + status + ", dim=" + dim + "]";
	}

}
