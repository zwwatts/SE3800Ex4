package tests;
import core.*;
import org.junit.Assert;
import org.junit.*;

/**
 * This class is responsible for specifying the tests for the Caculatorator project  
 * @author sorianog, wattsz
 *
 */
public class CoreTests {
	
	private Calculatorator calculator;
	
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
	@Test 
	public void divTest2() {
		// Will modify this after div by zero is handled 
		System.out.println("Testing \"div 1 0 0\"...");
		Object expected = null;
		int [] numbers = {1, 0 ,0};
		int actual = calculator.div(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	/** 
	 * Test the "exp" command
	 * @athor sorianog 
	 */
	@Test
	public void expTest(){
		System.out.println("Testing \"exp\"...");
		int expected = 16;
		int[] numbers = {2, 2, 2};
		int actual = calculator.exp(numbers);
		Assert.assertEquals(expected, actual);
	}
	
	// TODO: test "hist", "clear", "!n"
}
