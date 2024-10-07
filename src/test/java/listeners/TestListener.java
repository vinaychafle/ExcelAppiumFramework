package listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import appiumUtils.AppiumUtils;
import externalResources.ExcelDataRead;
import io.appium.java_client.AppiumDriver;
import resources.ExtendReporterNG;

public class TestListener extends AppiumUtils implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getExtendReports();
	AppiumDriver driver;
	ExcelDataRead excel;	
	public static Logger log;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String className=result.getTestClass().getRealClass().getName();
		String tcName= result.getMethod().getMethodName();
		
		test= extent.createTest(tcName);
		
		log= LogManager.getLogger(className);
				
		ThreadContext.put("threadName", tcName);
		
		log.debug(tcName +" Started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		String tcName=result.getMethod().getMethodName();
		String packageName=result.getTestClass().getRealClass().getPackageName();
		try {
			writeToExcel(packageName,tcName, "Pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(tcName +" Passed");
		
		
	}
	
	public void writeToExcel(String packageName,String tcName,String msg) throws IOException {
		excel=new ExcelDataRead("testpack");
		excel.writeExcel(packageName,tcName ,"Results" ,msg );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		test.fail(result.getThrowable());
		
		try {
			driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath=null;
		String packageName=result.getTestClass().getRealClass().getPackageName();
		String tcName=result.getMethod().getMethodName();
		try {
			writeToExcel(packageName,tcName, "Fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			filePath= getScreenshot(packageName,tcName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, tcName);
		log.warn(tcName +" failed --" +result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String tcName= result.getMethod().getMethodName();
		log.error(tcName+ " Skipped --"+ result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat " +deviceName);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
