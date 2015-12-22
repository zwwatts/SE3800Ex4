package core;

public class StoredCommand {

	public static enum COMMAND_TYPE  {
			ADD, SUB, MUL, DIV, EXP, CLEAR, HIST
	}
	
	private COMMAND_TYPE commandType;
	private int result;
	private int[] numberArgs;
	public StoredCommand(COMMAND_TYPE command, int commandResult, int[] commandArgs){
		this.commandType = command;
		this.result = commandResult;
		this.numberArgs = commandArgs;
	}
	//TODO: we might need getters/setters?
	
	public String toString(){
		//TODO: make this elegantly handle command types
		return this.numberArgs.toString() + " => "+ this.result;
		
	}
	
}
