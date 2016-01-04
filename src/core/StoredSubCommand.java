package core;

import java.util.Arrays;

public class StoredSubCommand extends StoredCommand{

	public StoredSubCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs) {
		super(command, commandResult, commandArgs);
	}

	@Override
	public String toString() {
		return "SUB " + Arrays.toString(numberArgs) + " => " + result;
	}

}
