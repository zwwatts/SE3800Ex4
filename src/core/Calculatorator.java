package core;

import java.util.List;

/**
 * SE3800-002
 * Exercise 3
 * @author sorianog, wattsz
 *
 * This class represents a Calculator object specifying certain mathematical/calculator related methods.
 */

public class Calculatorator {
	
	public int add(int[] numbers){
		 int result = 0;
		 for(int number : numbers){
			 result += number;
		 }
		return result;
	}
	
	public int sub(int[] numbers) {
		 int result = 0;
		 for(int number : numbers){
			 result -= number;
		 }
		return result;
	}
	
	public int mul(int[] numbers) {
		 int result = 0;
		 for(int number : numbers){
			 result *= number;
		 }
		return result;
	}
	
	public int div(int[] numbers) {
		 int result = 0;
		 for(int number : numbers){
			 result /= number;
		 }
		return result;
	}
	public int exp(int[] numbers){
		int result = 0;
		int prevResult = numbers[0];
		 for(int i=1; i<numbers.length; i++){
			 prevResult = (int) Math.pow(prevResult, numbers[i]);
		 }
		return result;
	}
	
	// TODO: parking the implementation of this function 
	// We discussed possibly having a History object 
	public String hist() {
		return "";
	}
	
	public void clear() {
		
	}
	
	public void pastRes() {
		
	}
}
