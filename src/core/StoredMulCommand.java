package core;

import java.util.Arrays;

public class StoredMulCommand extends StoredCommand{

	public StoredMulCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs) {
		super(command, commandResult, commandArgs);
	}

	@Override
	public String toString() {
		return "MUL " + Arrays.toString(numberArgs) + " => " + result;
	}

}
