package core;

import java.util.Arrays;
/**
 * 
 * @author wattsz
 * Command that represents the exponential functionality
 */
public class StoredExpCommand extends StoredCommand{

	public StoredExpCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs) {
		super(command, commandResult, commandArgs);
	}

	@Override
	public String toString() {
		return "EXP " + Arrays.toString(numberArgs) + " => " + result;
	}

}
