package testData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import appiumUtils.AppiumUtils;

public class TestDataProviders extends AppiumUtils {
	
	@DataProvider
	public static Object[][] jsonProvider() throws IOException{
		
		List<HashMap<String, String>> data =getJsonData("eCommerce");
		
		Object[][] obj = new Object[data.size()][];

		int i= 0;

		for (Map<String, String> next : data) {

		obj[i++] = new Object[] {next};

		}

		return obj;
	}

}
