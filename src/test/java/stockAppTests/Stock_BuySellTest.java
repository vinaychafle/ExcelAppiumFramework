package stockAppTests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import stockAppPageObjects.Stock_Login;
import stockAppPageObjects.Stock_Methods;

public class Stock_BuySellTest extends AppiumBase{
	
	public AndroidDriver driver; 
	Stock_Login login;
	Stock_Methods methods;
	
	@BeforeMethod
	public void stock_BuySell_PreSetup() throws IOException {
		driver=appiumInitialize("Stock_Trainer.apk");
		login=new Stock_Login(driver);
		methods= new Stock_Methods(driver);
	}
	
	@Test
	public void stockapp_tc_04() throws IOException, InterruptedException {
		login.acceptTerms();
		login.anonymousLogin();
		login.versionOk();
		
		methods.addToWatchlist();
		methods.watchlistValidation();
		
		methods.buyStock();
		methods.portfolioValidation();
		methods.getPortfolioValue();
		
		methods.sellStock();
		methods.getPortfolioValue();
		
	}
	

}
