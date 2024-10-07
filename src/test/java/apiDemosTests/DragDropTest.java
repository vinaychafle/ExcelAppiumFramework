package apiDemosTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumResources.AppiumBase;
import appiumUtils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DragDropTest extends AppiumBase {
	AndroidDriver driver;
	AndroidActions actions;
	
	@Test
	public void testDragDrop() throws InterruptedException, IOException {
		driver=appiumInitialize("ApiDemos-debug.apk");
		actions=new AndroidActions(driver);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		actions.dragDropGesture(source, 620, 560);
		
		Thread.sleep(1000);
		
		String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	}

}
