package core;

import java.util.*;
public class Application {
	
	public static void main(String[] args){
		
		boolean running = true;
		Calculatorator calc = new Calculatorator();
		Scanner stdIn = new Scanner(System.in);
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
					break;
				case "sub":
					calc.sub(numberInputs);
					break;
				case "mul":
					calc.mul(numberInputs);
					break;
				case "div":
					calc.div(numberInputs);
					break;
				case "exp":
					calc.exp(numberInputs);
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
