package excelConfigTest;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import appiumUtils.AppiumUtils;
import externalResources.ExcelDataRead;
import testData.TestDataProviders;

public class ExcelTest extends AppiumUtils{
	ExcelDataRead excel;
	
	@Test()
	public void tc_01() {
		System.out.println("To be run");
	}
	
	@Test()
	public void tc_02() {
		System.out.println("NOT To be run");
	}
	
	@Test()
	public void tc_03() {
		System.out.println("To be run");
	}
	
	@Test()
	public void tc_04() {
		System.out.println("NOT To be run");
	}
	
	@Test()
	public void testData() throws IOException {
		excel= new ExcelDataRead("locators");
		//System.out.println(excel.getData("Sheet1", 1, 0));
		//System.out.println(excel.getData("Sheet1", "tc_02","Execution flag"));
		System.out.println(excel.getData("formpage", "NameField", "Locator"));
	}
	
	@Test(dataProvider = "jsonProvider", dataProviderClass = TestDataProviders.class)
	public void form(HashMap<String,String> input) {
		System.out.println(input.get("name"));
		System.out.println(input.get("gender"));
		System.out.println(input.get("country"));
		
	}
	
		

}
