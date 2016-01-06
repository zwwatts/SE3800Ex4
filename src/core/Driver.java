package core;

import java.util.Scanner;

/**
 * 
 * @author wattsz
 * Driver Class for the Application
 */
public class Driver {
	
	public static void main(String[] args) {
		boolean running = true;
		Scanner stdIn = new Scanner(System.in);
		Application app = new Application();
		System.out.println("Starting Up...");
		while(running){
			System.out.println("Ready: ");
			String command = stdIn.nextLine();
			Integer result = app.parseCommand(command);
			if(result != null){
				System.out.println(result);
			}
		}
		stdIn.close();
	}
	
}
