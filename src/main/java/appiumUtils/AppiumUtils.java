package appiumUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	public AppiumDriverLocalService appiumLocal;

	public AppiumDriverLocalService startAppiumService(String ip, int port) {
		appiumLocal = new AppiumServiceBuilder()
				.withAppiumJS(new File(System.getProperty("user.home")+
						"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ip).usingPort(port).build();
		appiumLocal.start();

		return appiumLocal;
	}

	public static List<HashMap<String, String>> getJsonData(String fileName) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\externalResources\\"+fileName+".json"), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	public String getScreenshot(String packageName,String testCaseName,AppiumDriver driver) throws IOException {
		File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File newfile=new File((System.getProperty("user.dir") + "\\results\\" +packageName + "\\" +testCaseName + ".png" ));
		FileUtils.copyFile(sourcefile,newfile);
		return System.getProperty("user.dir") + "\\results\\" +packageName + "\\" +testCaseName + ".png";
		} 

}
