package generalStore;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import generalStorePageObjects.CartPage;
import generalStorePageObjects.FormPage;
import generalStorePageObjects.ProductCatalog;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ECommerceTest_02 extends AppiumBase {
	
	public AndroidDriver driver;
	FormPage formpage;

	
	@Test
	public void sumOfcartProducts() throws InterruptedException, IOException {
		driver=appiumInitialize("General-Store.apk");
		formpage=new FormPage(driver);
		formpage.giveName("Rahul");
		formpage.setGender("Male");
		formpage.setCountry("Australia");
		
		ProductCatalog productCatalog= formpage.letsShop();
		
		productCatalog.displayedProductAddToCart();
		CartPage cartpage=productCatalog.goToCartPage();
	
		Double sum=cartpage.cartProductPrice();
		
		Double actual=cartpage.getcartPrice();
		
		Assert.assertEquals(sum, actual);	
		
		cartpage.getTerms();
		
		cartpage.processPayment();
		
		Thread.sleep(1000);
		
		Set<String> allContext=driver.getContextHandles();
		for(String context : allContext) {
			System.out.println(context);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Planit Testing Mumbai"+Keys.ENTER);
		
		Thread.sleep(1000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

}
