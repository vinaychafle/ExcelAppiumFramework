package apiDemosTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import appiumUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LongPressTest extends AppiumBase {
	AndroidDriver driver;
	AndroidActions actions;
	
	@Test
	public void TestLongPress() throws InterruptedException, IOException {
		driver=appiumInitialize("ApiDemos-debug.apk");
		actions=new AndroidActions(driver);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		actions.longPressGesture(ele);
		
		Thread.sleep(1000);
	
	}

}
