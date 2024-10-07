package stockAppTests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import stockAppPageObjects.Stock_Login;
import stockAppPageObjects.Stock_Methods;

public class Stockapp_WatchlistTest extends AppiumBase {
	public AndroidDriver driver;
	Stock_Login login;
	Stock_Methods methods;
	
	@BeforeMethod
	public void stock_Watchlist_PreSetup() throws IOException {
		driver=appiumInitialize("Stock_Trainer.apk");
		login=new Stock_Login(driver);
		methods= new Stock_Methods(driver);
	}
	
	@Test
	public void stockapp_tc_03() throws IOException {
		login.acceptTerms();
		login.anonymousLogin();
		login.versionOk();
		
		methods.addToWatchlist();
		methods.watchlistValidation();
		
	}

}
