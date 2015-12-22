package core;

import java.util.*;
public class Application {
	
	public static void main(String[] args){
		
		boolean running = true;
		Calculatorator calc = new Calculatorator();
		Scanner stdIn = new Scanner(System.in);
		//TODO: figure out the best data structure for history objects
		ArrayList<StoredCommand> history = new ArrayList<StoredCommand>();
		while(running){
			String command = stdIn.nextLine();
			String[] parsedCommand;
			try {
				parsedCommand = command.split(" ");
				
				//TODO: Check for valid input
				String[] rawInputs = Arrays.copyOfRange(parsedCommand, 1, parsedCommand.length);
				int[] numberInputs = new int[rawInputs.length];

				for (int i = 0; i < rawInputs.length; i++) {
				    try {
				        numberInputs[i] = Integer.parseInt(rawInputs[i]);
				    } catch (NumberFormatException nfe) {
						// TODO: Elegantly handle this ==============================================================================================
				    };
				}
				switch (parsedCommand[0]) {
				case "add":
					System.out.println(calc.add(numberInputs));
					history.add(new StoredCommand(StoredCommand.COMMAND_TYPE.ADD, calc.add(numberInputs), numberInputs));
					break;
				case "sub":
					calc.sub(numberInputs);
					history.add(new StoredCommand(StoredCommand.COMMAND_TYPE.SUB, calc.sub(numberInputs), numberInputs));
					break;
				case "mul":
					calc.mul(numberInputs);
					history.add(new StoredCommand(StoredCommand.COMMAND_TYPE.MUL, calc.mul(numberInputs), numberInputs));
					break;
				case "div":
					calc.div(numberInputs);
					history.add(new StoredCommand(StoredCommand.COMMAND_TYPE.DIV, calc.div(numberInputs), numberInputs));
					break;
				case "exp":
					calc.exp(numberInputs);
					history.add(new StoredCommand(StoredCommand.COMMAND_TYPE.EXP, calc.exp(numberInputs), numberInputs));
					break;
				case "exit":
					for(StoredCommand c: history){
						System.out.println(c);
					}
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
