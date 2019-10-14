package command;

import command.commands.*;

public class CommandController {

	private InterfaceCommand onCommand;
	private InterfaceCommand offCommand;
	private InterfaceCommand dimUpCommand;

	public CommandController(OnCommand onCommand, OffCommand offCommand, DimUpCommand dimUpCommand) {
		this.onCommand = onCommand;
		this.offCommand = offCommand;
		this.dimUpCommand = dimUpCommand;
	}

	public void onClickListener(String button) {

		System.out.println("clicked for : " + button);

		switch (button) {
		case "on":
			this.onCommand.execute();
			break;
		case "off":
			this.offCommand.execute();
			break;
		case "dimUp":
			this.dimUpCommand.execute();
			break;
		case "dimDown":
			this.dimUpCommand.unexecute();
			break;
		}
	}

}
