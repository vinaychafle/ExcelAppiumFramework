package stockAppPageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import appiumUtils.AndroidActions;
import externalResources.ExcelDataRead;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Stock_Methods extends AndroidActions{
	AndroidDriver driver;
	Stock_Homepage homepage;
	Stock_Buttons buttons;
	Stock_Portfolio portfolio;
	ExcelDataRead excel;	
	
	public Stock_Methods (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		homepage=new Stock_Homepage(driver);
		buttons= new Stock_Buttons(driver);
		portfolio= new Stock_Portfolio(driver);
	}
	
	public void addToWatchlist() throws IOException {
		homepage.goToFindStocks();
		excel= new ExcelDataRead("stockapp_data");
		for(int i=1; i<=excel.getLastRowNum("stocks");i++) {
			buttons.searchStock(excel.getData("stocks", i, 0));
			driver.findElement(By.xpath(excel.getData("stocks", i, 1))).click();
			buttons.watchStock();
			buttons.goBack();
			buttons.clearSearch();
		}
	}
	
	public void watchlistValidation() throws IOException {
		homepage.goToWatchlist();
		excel= new ExcelDataRead("stockapp_data");
		for(int i=1; i<=excel.getLastRowNum("stocks");i++) {
			System.out.println(driver.findElement(By.xpath(excel.getData("stocks", i, 1))).isDisplayed());
		}
	}
	
	public void portfolioValidation() throws IOException {
		homepage.goToPortfolio();
		excel= new ExcelDataRead("stockapp_data");
		for(int i=1; i<=excel.getLastRowNum("stocks");i++) {
			System.out.println(driver.findElement(By.xpath(excel.getData("stocks", i, 2))).isDisplayed());
		}
	}
	
	public void getPortfolioValue() {
		homepage.goToMyAccount();
		System.out.println(portfolio.getPortValue());		
	}
	
	public void buyStock() throws IOException, InterruptedException {
		homepage.goToWatchlist();
		excel= new ExcelDataRead("stockapp_data");
		for(int i=1; i<=excel.getLastRowNum("stocks");i++) {
			driver.findElement(By.xpath(excel.getData("stocks", i, 1))).click();
			buttons.buyStock();
			buttons.stockNumber(StockConstants.BuySell_Num);
			buttons.buyStock();
			if(buttons.watchAd()) {
				buttons.buyStock();
				buttons.stockNumber(StockConstants.BuySell_Num);
				buttons.buyStock();
			}
			buttons.goBack();
		}
	}
	
	public void sellStock() throws IOException, InterruptedException {
		homepage.goToPortfolio();
		excel= new ExcelDataRead("stockapp_data");
		for(int i=1; i<=excel.getLastRowNum("stocks");i++) {
			driver.findElement(By.xpath(excel.getData("stocks", i, 2))).click();
			buttons.sellStock();
			buttons.stockNumber(StockConstants.BuySell_Num);
			buttons.sellStock();
			if(buttons.watchAd()) {
				buttons.sellStock();
				buttons.stockNumber(StockConstants.BuySell_Num);
				buttons.sellStock();
			}
			buttons.goBack();
		}
	}
}
