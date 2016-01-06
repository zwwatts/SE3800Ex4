package core;

import java.util.*;
public class Application {
	History history;
	Calculatorator calc;
	public Application(){
		history = new History();
		calc = new Calculatorator();
	}
	public Integer parseCommand(String command){
			String[] parsedCommand;
			try {
				parsedCommand = command.split(" ");
				
				String[] rawInputs = Arrays.copyOfRange(parsedCommand, 1, parsedCommand.length);
				int[] numberInputs = new int[rawInputs.length];
				parsedCommand[0] = parsedCommand[0].toLowerCase();
				for (int i = 0; i < rawInputs.length; i++) {
				    try {
				    	if(rawInputs[i].contains("!")){
				    		numberInputs[i] = history.substitute(rawInputs[i]);
				    	}else{
				    		numberInputs[i] = Integer.parseInt(rawInputs[i]);
				    	}
				    } catch (Exception nfe) {
						System.err.println("Invalid history number detected!");
				    };
				}
				switch (parsedCommand[0]) {
				case "add":					
					history.add(new StoredAddCommand(StoredCommand.COMMAND_TYPE.ADD, calc.add(numberInputs), numberInputs));
					return (Integer)(calc.add(numberInputs));
				case "sub":					
					history.add(new StoredSubCommand(StoredCommand.COMMAND_TYPE.SUB, calc.sub(numberInputs), numberInputs));
					return (Integer)(calc.sub(numberInputs));
				case "mul":				
					history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calc.mul(numberInputs), numberInputs));
					return (Integer)(calc.mul(numberInputs));
				case "div":					
					history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calc.div(numberInputs), numberInputs));
					return (Integer)(calc.div(numberInputs));
				case "exp":
					history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calc.exp(numberInputs), numberInputs));
					return (Integer)(calc.exp(numberInputs));
				case "hist":
					if (history.isEmpty()){
						System.out.println("No saved calculations!");
					} else {
						System.out.println(history.printHist());
					}
					return null;
				case "clear":
					history.clear();
					System.out.println("All saved calculations have been removed!");
					return null;
				case "exit":
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.err.println("Invalid command detected!");
					return null;
				}
			} catch (Exception e) {
				System.err.println("Invalid command detected!");
				return null;
			}
		
		
	}
}
