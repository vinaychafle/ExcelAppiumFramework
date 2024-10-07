package listeners;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import externalResources.ExcelDataRead;
import resources.Constants;

public class AnnotationsTransformer implements IAnnotationTransformer{
	ExcelDataRead excel;

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		
		String tcName= testMethod.getName();
		String packageName=testMethod.getDeclaringClass().getPackageName();
		try {
			if(toBeExecuted(packageName,tcName)) {
				annotation.setEnabled(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean toBeExecuted(String packageName,String tcName) throws IOException {
		
		excel =new ExcelDataRead("testpack");
		String executionFlag=excel.getData(packageName, tcName,"Execution flag");
		if(executionFlag.equalsIgnoreCase("n")) {
			return true;
		}
		return false;
		
	}
	
}
