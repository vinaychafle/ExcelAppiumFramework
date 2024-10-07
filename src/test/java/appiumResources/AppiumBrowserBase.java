package appiumResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import appiumUtils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumBrowserBase extends AppiumUtils{

	AndroidDriver driver;
	AppiumDriverLocalService appiumLocal;
	
	
	public AndroidDriver AppiumBase() throws IOException {
		Properties prop=new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		
		String ip=prop.getProperty("ip");
		int port=Integer.parseInt(prop.getProperty("port"));
		
		appiumLocal=startAppiumService(ip,port);
		
		UiAutomator2Options op=new UiAutomator2Options();
		op.setDeviceName(prop.getProperty("deviceName"));
		op.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\main\\java\\Tools and Drivers\\chromedriver.exe");
		op.setCapability("browserName", "Chrome");
		
		
		driver= new AndroidDriver(appiumLocal.getUrl(), op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		appiumLocal.stop();
		
	}
}