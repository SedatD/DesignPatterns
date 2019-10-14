package command.commands;

import command.InterfaceCommand;
import command.LightBulb;

public class OffCommand implements InterfaceCommand {
	
	private LightBulb lightBulb;
	
	public OffCommand(LightBulb lightBulb) {
		this.lightBulb = lightBulb;
	}

	@Override
	public void execute() {
		lightBulb.lightsOff();
	}

	@Override
	public void unexecute() {
		lightBulb.lightsOn();
	}

}
