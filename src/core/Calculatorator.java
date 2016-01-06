package core;

/**
 * SE3800-002
 * Exercise 3
 * @author sorianog, wattsz
 *
 * This class represents a Calculator object specifying certain mathematical/calculator related methods.
 */

public class Calculatorator {
	/**
	 * @author wattsz
	 * @param numbers
	 * @return returns the sum of the input numbers
	 */
	public int add(int[] numbers){
		 int result = 0;
		 for(int number : numbers){
			 result += number;
		 }
		return result;
	}
	/**
	 * @author wattsz
	 * @param numbers
	 * @return the difference of the numbers
	 */
	public int sub(int[] numbers) {
		int prevResult = numbers[0];
		 for(int i=1; i<numbers.length; i++){
			 prevResult -= numbers[i];
		 }
		return prevResult;
	}
	/**
	 * @author wattsz
	 * @param numbers
	 * @return the produt of the input numbers
	 */
	public int mul(int[] numbers) {
		int prevResult = numbers[0];
		 for(int i=1; i<numbers.length; i++){
			 prevResult *= numbers[i];
		 }
		return prevResult;
	}
	/**
	 * @author wattsz
	 * @param numbers
	 * @return the quotient of the input numbers
	 * @throws IllegalArgumentException when 0 is a divisor
	 */
	public int div(int[] numbers) throws IllegalArgumentException {
		int prevResult = numbers[0];
		 for(int i=1; i<numbers.length; i++){
			 if(numbers[i] == 0){
				 throw new IllegalArgumentException("Can't divide by 0"); 
			 }
			 else{
				 prevResult /= numbers[i];
			 }
		 }
		return prevResult;
	}
	/**
	 * @author wattsz
	 * @param numbers
	 * @return the exponentiation of the input numbers
	 */
	public int exp(int[] numbers){
		int prevResult = numbers[0];
		 for(int i=1; i<numbers.length; i++){
			 prevResult = (int) Math.pow(prevResult, numbers[i]);
		 }
		return prevResult;
	}
}
