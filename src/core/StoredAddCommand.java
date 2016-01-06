package core;

import java.util.Arrays;
/**
 * 
 * @author wattsz
 * Command that represents the add functionality
 */
public class StoredAddCommand extends StoredCommand{

	public StoredAddCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs) {
		super(command, commandResult, commandArgs);
	}
	
	@Override
	public String toString(){
		return "ADD " + Arrays.toString(numberArgs) + " => " + result;
	}

}
