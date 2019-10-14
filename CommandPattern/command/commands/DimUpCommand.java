package command.commands;

import command.InterfaceCommand;
import command.LightBulb;

public class DimUpCommand implements InterfaceCommand {

	private LightBulb lightBulb;

	public DimUpCommand(LightBulb lightBulb) {
		this.lightBulb = lightBulb;
	}

	@Override
	public void execute() {
		lightBulb.lightDimUp();
	}

	@Override
	public void unexecute() {
		lightBulb.lightDimDown();
	}

}
