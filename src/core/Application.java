package core;

import java.util.*;
public class Application {
	
	public static void main(String[] args){
		System.out.println("Starting Up...");
		boolean running = true;
		Calculatorator calc = new Calculatorator();
		Scanner stdIn = new Scanner(System.in);
		//TODO: figure out the best data structure for history objects
		ArrayList<StoredCommand> history = new ArrayList<StoredCommand>();
		while(running){
			System.out.println("Ready: ");
			String command = stdIn.nextLine();
			String[] parsedCommand;
			try {
				parsedCommand = command.split(" ");
				
				//TODO: Check for valid input
				String[] rawInputs = Arrays.copyOfRange(parsedCommand, 1, parsedCommand.length);
				int[] numberInputs = new int[rawInputs.length];
				parsedCommand[0] = parsedCommand[0].toLowerCase();
				for (int i = 0; i < rawInputs.length; i++) {
				    try {
				    	//TODO: validation for histNumber
				    	if(rawInputs[i].contains("$")){
				    		rawInputs[i] = rawInputs[i].replace("$", "");
				    		int histNumber = Integer.parseInt(rawInputs[i]);
				    		numberInputs[i] = history.get(histNumber).result;
				    	}else{
				    		numberInputs[i] = Integer.parseInt(rawInputs[i]);
				    	}
				    } catch (NumberFormatException nfe) {
						// TODO: Elegantly handle this ==============================================================================================
				    };
				}
				switch (parsedCommand[0]) {
				case "add":
					System.out.println(calc.add(numberInputs));
					history.add(new StoredAddCommand(StoredCommand.COMMAND_TYPE.ADD, calc.add(numberInputs), numberInputs));
					break;
				case "sub":
					System.out.println(calc.sub(numberInputs));
					history.add(new StoredSubCommand(StoredCommand.COMMAND_TYPE.SUB, calc.sub(numberInputs), numberInputs));
					break;
				case "mul":
					System.out.println(calc.mul(numberInputs));
					history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calc.mul(numberInputs), numberInputs));
					break;
				case "div":
					System.out.println(calc.div(numberInputs));
					history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calc.div(numberInputs), numberInputs));
					break;
				case "exp":
					System.out.println(calc.exp(numberInputs));
					history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calc.exp(numberInputs), numberInputs));
					break;
				case "hist":
					for(int j=0; j<history.size(); j++){
						System.out.println(j + ": " + history.get(j));
					}
					break;
				case "exit":
					System.out.println("Exiting...");
					running = false;
					break;
				default:
					break;
				}
			} catch (Exception e) {
				// TODO: Elegantly handle this ==============================================================================================
			}
		}
		stdIn.close();
	}
}
