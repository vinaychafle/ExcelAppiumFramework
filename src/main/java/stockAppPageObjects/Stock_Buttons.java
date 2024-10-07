package stockAppPageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Stock_Buttons{

	AndroidDriver driver;
	
	public Stock_Buttons (AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath="//*[@text='Search']")
	private WebElement eleSearch;
	
	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement eleGoBack;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/watchStockButton")
	private WebElement eleStockWatch;
	
	@AndroidFindBy(xpath = "//*[@text='SELL']")
	private WebElement eleStockSell;
	
	@AndroidFindBy(xpath = "//*[@text='BUY']")
	private WebElement eleStockBuy;	
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/textfield_et_label_input")
	private WebElement eleStockNum;
	
	@AndroidFindBy(accessibility = "Search")
	private WebElement eleSearchClear;
	
	@AndroidFindBy(xpath = "//*[@text='WATCH AD']")
	private List<WebElement> eleWatchAd;
	
	public void searchStock(String s) {
		eleSearch.sendKeys(s);
	}
	
	public void clearSearch() {
		eleSearchClear.click();
	}
	
	public void goBack() {
		eleGoBack.click();
	}
	
	public void watchStock() {
		eleStockWatch.click();
	}
	
	public void sellStock() {
		eleStockSell.click();
	}
	
	public void buyStock() {
		eleStockBuy.click();
	}
	
	public void stockNumber(String num) {
		eleStockNum.sendKeys(num);
	}
	
	public boolean watchAd() throws InterruptedException {
		if(eleWatchAd.size()>0) {
			eleWatchAd.get(0).click();
			Thread.sleep(32000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			return true;
		}else{
			return false;			
		}
	}
}
