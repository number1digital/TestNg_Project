package swaglab_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swaglab_pages.LoginPage;

import org.testng.Assert;


@Listeners(Listener.class)

public class LoginTest extends BaseClass {

	@Test (priority = 0)
	public void LoginSuccessTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_sauce");
		
		WebElement ProductTitle = driver.findElement(By.className("title"));
		Assert.assertEquals(ProductTitle.getText(), "Products");
		
	}

	@Test (priority = 1)
	public void LoginFailureTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_test");
		
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test (priority = 2)
	public void LockedUserLoginFailureTest() {
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction("locked_out_user", "secret_sauce");
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");
		
	}
	
	@Test 
	public void LoginFailureTestFromExcel() {
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction(UserNameVal, PasswordVal);
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
		
		sheet.getRow(3).createCell(2).setCellValue("DONE");
	
	}
	
	

}
