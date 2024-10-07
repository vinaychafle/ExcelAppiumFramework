package generalStore;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import generalStorePageObjects.CartPage;
import generalStorePageObjects.FormPage;
import generalStorePageObjects.ProductCatalog;
import io.appium.java_client.android.AndroidDriver;

public class ECommerceTest_01 extends AppiumBase{
	public AndroidDriver driver;
	FormPage formpage;
	
	@BeforeMethod
	public void preSetup() throws IOException {
		driver=appiumInitialize("General-Store.apk");
		formpage=new FormPage(driver);
		formpage.directstartActivity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
	}
	
	
	@Test
	public void fillFormPositiveTest() throws InterruptedException, MalformedURLException {
		
		formpage.giveName("Rahul");
		formpage.setGender("Male");
		formpage.setCountry("Australia");
		ProductCatalog productCatalog= formpage.letsShop();
		
		productCatalog.selectProduct("Jordan 6 Rings");
		
		CartPage cartpage=productCatalog.goToCartPage();
		
		Assert.assertEquals(cartpage.getCartProduct(), "Jordan 6 Rings");
		
		Thread.sleep(1000);
	}

	@Test
	public void fillFormNegativeTest() throws InterruptedException, MalformedURLException {
		
		formpage.setGender("Male");
		formpage.setCountry("Australia");
		formpage.letsShop();
		
		String toastName= formpage.getNameToastMessage();
		Assert.assertEquals(toastName, "enter your name");
		
		Thread.sleep(1000);
	}
}
