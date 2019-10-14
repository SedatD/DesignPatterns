package command.commands;

import command.InterfaceCommand;
import command.LightBulb;

public class OnCommand implements InterfaceCommand {

	private LightBulb lightBulb;

	public OnCommand(LightBulb lightBulb) {
		this.lightBulb = lightBulb;
	}

	@Override
	public void execute() {
		lightBulb.lightsOn();
	}

	@Override
	public void unexecute() {
		lightBulb.lightsOff();
	}

}
