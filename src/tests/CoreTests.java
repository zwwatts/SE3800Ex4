package tests;
import static org.junit.Assert.*;
import core.*;

import org.junit.*;

/**
 * This class is responsible for specifying the tests for the Caculatorator project  
 * @author sorianog, wattsz
 *
 */
public class CoreTests {
	
	private Calculatorator calculator;
	private History history;
	
	// @author sorianog 
	@BeforeClass
	public static void beforeClass(){
		System.out.println("**********************************");
		System.out.println("Initiating core tests...");
	}
	
	// @author sorianog 
	@Before
	public void beforeTests(){
		System.out.println("**********************************");
		System.out.println("Creating a new Calculator...");
		calculator = new Calculatorator();
		history = new History();
	}
	
	/** 
	 * @author sorianog 
	 */
	@AfterClass
	public static void afterClass(){
		System.out.println("**********************************");
		System.out.println("Testing complete!");
		System.out.println("**********************************");
	}
	
	/** 
	 * Test the "add" command
	 * @author sorianog 
	 */
	@Test
	public void addTest(){
		System.out.println("Testing \"add\"...");
		int expected = 6;
		int[] numbers = {1, 2, 3};
		int actual = calculator.add(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test the "sub" command 
	 * @author sorianog 
	 */
	@Test
	public void subTest(){
		System.out.println("Testing \"sub\"...");
		int expected = 0;
		int[] numbers = {3, 2, 1};
		int actual = calculator.sub(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/** 
	 * Test the "mul" command
	 * @author sorianog 
	 */
	@Test
	public void mulTest(){
		System.out.println("Testing \"mul\"...");
		int expected = 343;
		int[] numbers = {7, 7, 7};
		int actual = calculator.mul(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/** 
	 * Test the "div" command
	 * @author sorianog 
	 */
	@Test
	public void divTest(){
		System.out.println("Testing \"div\"...");
		int expected = 17;
		int[] numbers = {102, 2, 3};
		int actual = calculator.div(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test input "div 1 0 0"
	 * @author sorianog
	 */
	@Test (expected=IllegalArgumentException.class)
	public void divTest2() {
		System.out.println("Testing \"div 1 0 0\"...");
		int [] numbers = {1, 0 ,0};
		calculator.div(numbers);
	}
	
	/** 
	 * Test the "exp" command
	 * @author sorianog 
	 */
	@Test
	public void expTest(){
		System.out.println("Testing \"exp\"...");
		int expected = 16;
		int[] numbers = {2, 2, 2};
		int actual = calculator.exp(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/** 
	 * Test the "hist" command
	 * @author sorianog 
	 */
	@Test
	public void histTest(){
		System.out.println("Testing \"hist\"...");
		String expected = "0: ADD [1, 1, 1] => 3\n" +
				"1: SUB [3, 2, 1] => 0\n" + 
				"2: MUL [22, 2, 2] => 88\n" +
				"3: DIV [42, 3] => 14\n" +
				"4: EXP [4, 2, 2] => 256\n";
		int[] addNumbers = {1, 1, 1};
		int[] subNumbers = {3, 2, 1};
		int[] mulNumbers = {22, 2, 2};
		int[] divNumbers = {42, 3};
		int[] expNumbers = {4, 2, 2};
		history.add(new StoredAddCommand(StoredCommand.COMMAND_TYPE.ADD, calculator.add(addNumbers), addNumbers));
		history.add(new StoredSubCommand(StoredCommand.COMMAND_TYPE.SUB, calculator.sub(subNumbers), subNumbers));
		history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calculator.mul(mulNumbers), mulNumbers));
		history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calculator.div(divNumbers), divNumbers));
		history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calculator.exp(expNumbers), expNumbers));
		String actual = history.printHist();
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test the "clear" command
	 * @author wattsz
	 */
	@Test 
	public void clearTest(){
		System.out.println("Testing \"clear\"...");
		
		int[] mulNumbers = {22, 2, 2};
		int[] divNumbers = {42, 3};
		int[] expNumbers = {4, 2, 2};
		history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calculator.mul(mulNumbers), mulNumbers));
		history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calculator.div(divNumbers), divNumbers));
		history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calculator.exp(expNumbers), expNumbers));
		
		Assert.assertFalse(history.isEmpty());
		history.clear();
		Assert.assertTrue(history.isEmpty());
	}
	
	/**
	 * Test the substitution command ("!n")
	 * @author wattsz
	 */
	@Test 
	public void substitutionTest(){
		System.out.println("Testing \"substitution (!n)\"...");
		int expected  = 14;
		int[] mulNumbers = {22, 2, 2};
		int[] divNumbers = {42, 3};
		int[] expNumbers = {4, 2, 2};
		history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calculator.mul(mulNumbers), mulNumbers));
		history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calculator.div(divNumbers), divNumbers));
		history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calculator.exp(expNumbers), expNumbers));
		int actual = history.substitute("!1");
		Assert.assertEquals(expected, actual);
	}
}
