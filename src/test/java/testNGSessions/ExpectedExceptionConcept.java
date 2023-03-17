package testNGSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	@Test(expectedExceptions = NullPointerException.class)
	public void test1() {
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void test2() {
		System.out.println("login test");
		int i = 9/0;
	}
}
