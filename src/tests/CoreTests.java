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
		// Will modify this after div by zero is handled 
		System.out.println("Testing \"div 1 0 0\"...");
		int [] numbers = {1, 0 ,0};
		calculator.div(numbers);
		fail();
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
		String expected = "0: MUL [22, 2, 2] => 88\n" +
"1: DIV [42, 3] => 14\n" + 
"2: EXP [4, 2, 2] => 256\n";
		int[] mulNumbers = {22, 2, 2};
		int[] divNumbers = {42, 3};
		int[] expNumbers = {4, 2, 2};
		history.add(new StoredMulCommand(StoredCommand.COMMAND_TYPE.MUL, calculator.mul(mulNumbers), mulNumbers));
		history.add(new StoredDivCommand(StoredCommand.COMMAND_TYPE.DIV, calculator.div(divNumbers), divNumbers));
		history.add(new StoredExpCommand(StoredCommand.COMMAND_TYPE.EXP, calculator.exp(expNumbers), expNumbers));
		String actual = history.printHist();
		Assert.assertEquals(expected, actual);
	}
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
	@Test 
	public void substitutionTest(){
		System.out.println("Testing \"substitution\"...");
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
	// TODO: test "hist", "clear", "!n"
}
