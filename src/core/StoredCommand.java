package core;

public abstract class StoredCommand {

	public static enum COMMAND_TYPE  {
			ADD, SUB, MUL, DIV, EXP, CLEAR, HIST
	}
	
	protected COMMAND_TYPE commandType;
	protected int result;
	protected int[] numberArgs;
	public StoredCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs){
		this.commandType = command;
		this.result = commandResult;
		this.numberArgs = commandArgs;
	}
	
	public abstract String toString();
}
