package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeTest (alwaysRun = true)
	public void method3() {
		System.out.println("Inside Before Test");
	}
	
	@AfterTest (alwaysRun = true)
	public void method4() {
		System.out.println("Inside After Test");
	}
	
	
	@BeforeMethod
	public void method1() {
		System.out.println("Inside Before Method Test");
	}
	

	@AfterMethod
	public void method2() {
		System.out.println("Inside After Method Test");
	}
	
	
}
