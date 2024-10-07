package stockAppPageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Stock_Homepage extends AndroidActions {

	AndroidDriver driver;
	
	public Stock_Homepage (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(accessibility = "Open navigation drawer")
	private WebElement eleNavigationDrawer;
	
	
	public void goToPortfolio() {
		eleNavigationDrawer.click();
		scrollIntoViewGesture(StockConstants.Homepage_Portfolio);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_Portfolio+"']")).click();
	}
	
	public void goToWatchlist() {
		scrollIntoViewGesture(StockConstants.Homepage_Watchlist);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_Watchlist+"']")).click();
	}
	
	public void goToFindStocks() {
		scrollIntoViewGesture(StockConstants.Homepage_FindStocks);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_FindStocks+"']")).click();
	}

	public void goToTopMovers() {
		eleNavigationDrawer.click();
		scrollIntoViewGesture(StockConstants.Homepage_TopMovers);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_TopMovers+"']")).click();
	}
	
	public void goToMyAccount() {
		eleNavigationDrawer.click();
		scrollIntoViewGesture(StockConstants.Homepage_MyAccount);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_MyAccount+"']")).click();
	}
	
	public void goToTransactions() {
		eleNavigationDrawer.click();
		scrollIntoViewGesture(StockConstants.Homepage_Transactions);	
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Homepage_Transactions+"']")).click();
	}
	
	public void goToNavigationDrawer() {
		eleNavigationDrawer.click();
	}
}
