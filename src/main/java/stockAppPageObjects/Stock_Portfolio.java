package stockAppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Stock_Portfolio {
	AndroidDriver driver;
	
	public Stock_Portfolio (AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/totalPortfolioValue")
	private WebElement elePortValue;
	
	public String getPortValue() {
		return elePortValue.getText();
	}

}
