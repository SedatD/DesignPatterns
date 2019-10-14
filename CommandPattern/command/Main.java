package command;

import command.commands.DimUpCommand;
import command.commands.OffCommand;
import command.commands.OnCommand;

public class Main {

	public static void main(String[] args) {

		LightBulb lightBulb = new LightBulb(false, 25);

		OnCommand onCommand = new OnCommand(lightBulb);
		OffCommand offCommand = new OffCommand(lightBulb);
		DimUpCommand dimUpCommand = new DimUpCommand(lightBulb);

		CommandController commandController = new CommandController(onCommand, offCommand, dimUpCommand);

		System.out.println(lightBulb);
		System.out.println();

		commandController.onClickListener("on");
		System.out.println(lightBulb);
		System.out.println();

		commandController.onClickListener("off");
		System.out.println(lightBulb);
		System.out.println();

		commandController.onClickListener("dimUp");
		System.out.println(lightBulb);
		System.out.println();

		commandController.onClickListener("dimDown");
		System.out.println(lightBulb);

	}

}
