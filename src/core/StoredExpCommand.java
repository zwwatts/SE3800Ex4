package core;

import java.util.Arrays;

public class StoredExpCommand extends StoredCommand{

	public StoredExpCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs) {
		super(command, commandResult, commandArgs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EXP " + Arrays.toString(numberArgs) + " => " + result;
	}

}
