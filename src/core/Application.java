package core;

import java.util.*;
public class Application {
	
	public static void main(String[] args){
		boolean running = true;
		Calculatorator calc = new Calculatorator();
		Scanner stdIn = new Scanner(System.in);
		while(running){
			String command = stdIn.next();
			String[] parsedCommand;
			try {
				parsedCommand = command.split(" ");
				
				switch (parsedCommand[0]) {
				case "add":
					calc.add();
					break;

				default:
					break;
				}
			} catch (Exception e) {
				// TODO: Elegantly handle this ==============================================================================================
			}
		}
	}
}
