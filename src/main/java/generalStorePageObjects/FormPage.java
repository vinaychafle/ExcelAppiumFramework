package generalStorePageObjects;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appiumUtils.AndroidActions;
import externalResources.ExcelDataRead;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	ExcelDataRead excel;
	
	public FormPage(AndroidDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		excel= new ExcelDataRead("locators");
	}

	
	
	/*private WebElement eleNameField=driver.findElement(By.id(excel.getData("formpage", "NameField", "Locator")));
	
	private WebElement eleMaleGenderButton=driver.findElement(By.xpath(excel.getData("formpage", "GenderButtonMale", "Locator")));
	
	private WebElement eleFemaleGenderButton=driver.findElement(By.xpath(excel.getData("formpage", "GenderButtonFemale", "Locator")));
	
	private WebElement eleSelectCountry=driver.findElement(By.id(excel.getData("formpage", "CountryDropDown", "Locator")));
	
	private WebElement eleShopButton=driver.findElement(By.id(excel.getData("formpage", "ShopButton", "Locator")));
	
	private WebElement eleToast=driver.findElement(By.xpath(excel.getData("formpage", "ToastMessage", "Locator")));
	*/
	public void giveName(String s) {
		//eleNameField.sendKeys(s);
		driver.findElement(By.id(excel.getData("formpage", "NameField", "Locator"))).sendKeys(s);
		driver.hideKeyboard();
	}
	
	public String getNameToastMessage() {
		//String toastName=eleToast.getAttribute("name");
		String toastName=driver.findElement(By.xpath(excel.getData("formpage", "ToastMessage", "Locator"))).getAttribute("name");
		return toastName;
	} 
	
	public void setGender(String gender) {
		if(gender.contains("female")) {
			//eleFemaleGenderButton.click();
			driver.findElement(By.xpath(excel.getData("formpage", "GenderButtonFemale", "Locator"))).click();
		}
		else 
			//eleMaleGenderButton.click();
			driver.findElement(By.xpath(excel.getData("formpage", "GenderButtonMale", "Locator"))).click();
		
	}
	
	public void setCountry(String countryName) {
		//eleSelectCountry.click();
		driver.findElement(By.id(excel.getData("formpage", "CountryDropDown", "Locator"))).click();
		scrollIntoViewGesture(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public ProductCatalog letsShop() {
		//eleShopButton.click();
		driver.findElement(By.id(excel.getData("formpage", "ShopButton", "Locator"))).click();
		
		return new ProductCatalog(driver);
	}	
	
	

}
