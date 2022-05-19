package Testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase2  {

	@Test
	public void doLogin() {
		System.out.println("login is successfull");
		
	}
	@Test
	public void UserRegister() {
		//System.out.println("User register is failed");
		Assert.fail("User register is failed");
	}
	@Test
	public void isSkip() {
		throw new SkipException("test is Skipped");
	}
	
}
