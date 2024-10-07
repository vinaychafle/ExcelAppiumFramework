package apiDemosTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class clickTest extends AppiumBase{
	AndroidDriver driver;
	
	@Test
	public void wifiSettings() throws IOException {
		driver=appiumInitialize("ApiDemos-debug.apk");
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Rajput Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
	

}
