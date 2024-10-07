package stockAppTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import stockAppPageObjects.StockConstants;
import stockAppPageObjects.Stock_Login;

public class Stockapp_LoginTest extends AppiumBase{
	
	public AndroidDriver driver; 
	Stock_Login login;
	
	@BeforeMethod
	public void stock_Login_PreSetup() throws IOException {
		driver=appiumInitialize("Stock_Trainer.apk");
		login=new Stock_Login(driver);
	}
	
	@Test
	public void stockapp_tc_01() {
		login.acceptTerms();
		login.loginRegister();
		
		String emailDisplayed=login.getDisplayedEmail();
		Assert.assertEquals(emailDisplayed, StockConstants.LoginRegister_Email);
		
		login.submitGreat();
		login.versionOk();
		
	}
	
	@Test
	public void stockapp_tc_02() {
		login.acceptTerms();
		login.anonymousLogin();
		login.versionOk();
	}
	
}
