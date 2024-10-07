package stockAppPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Stock_Login extends AndroidActions{
	AndroidDriver driver;
	
	public Stock_Login (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath="//*[@text='I ACCEPT THE TERMS']")
	private WebElement eleAcceptTerms;
	
	
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/anonymousLoginButton")
	private WebElement eleAnyLogin;
	
	@AndroidFindBy(xpath = "//*[@text='SELECT']")
	private WebElement eleAnyCountryOk;
		
	
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/registrationLink")
	private WebElement eleRegister;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_nameValue")
	private WebElement eleRegName;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_emailValue")
	private WebElement eleRegEmail;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_passwordValue")
	private WebElement eleRegPass;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_confirmPasswordValue")
	private WebElement eleRegConfmPass;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/countrySpinner")
	private WebElement eleRegCountry;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/securityQuestionOne")
	private WebElement eleRegSecQues1;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_firstSecurityAnswer")
	private WebElement eleRegSecQues1Ans;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/securityQuestionTwo")
	private WebElement eleRegSecQues2;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_secondSecurityAnswer")
	private WebElement eleRegSecQues2Ans;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/securityQuestionThree")
	private WebElement eleRegSecQues3;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/inputId_thirdSecurityAnswer")
	private WebElement eleRegSecQues3Ans;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/registerButton")
	private WebElement eleRegNewSubmit;
	
	@AndroidFindBy(id = "com.alifesoftware.stocktrainer:id/md_content")
	private WebElement eleRegSuccessContent;
	
	@AndroidFindBy(xpath = "//*[@text='GREAT']")
	private WebElement eleRegGreat;
	
	@AndroidFindBy(xpath = "//*[@text='OK']")
	private WebElement eleVersionOk;
		
	
	public void acceptTerms() {
		eleAcceptTerms.click();
	}
	
	public void loginRegister() {
		eleRegister.click();
		eleRegName.sendKeys(StockConstants.LoginRegister_Name);
		eleRegEmail.sendKeys(StockConstants.LoginRegister_Email);
		eleRegPass.sendKeys(StockConstants.LoginRegister_Pass);
		eleRegConfmPass.sendKeys(StockConstants.LoginRegister_Pass);
		eleRegCountry.click();
		scrollIntoViewGesture(StockConstants.Login_Country);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Login_Country+"']")).click();
		
		scrollIntoViewGesture("REGISTER NEW ACCOUNT");
		
		eleRegSecQues1.click();
		scrollIntoViewGesture(StockConstants.LoginRegister_SecQues1);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.LoginRegister_SecQues1+"']")).click();
		eleRegSecQues1Ans.sendKeys(StockConstants.LoginRegister_SecQues1Ans);
		
		eleRegSecQues2.click();
		scrollIntoViewGesture(StockConstants.LoginRegister_SecQues2);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.LoginRegister_SecQues2+"']")).click();
		eleRegSecQues2Ans.sendKeys(StockConstants.LoginRegister_SecQues2Ans);
		
		eleRegSecQues3.click();
		scrollIntoViewGesture(StockConstants.LoginRegister_SecQues3);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.LoginRegister_SecQues3+"']")).click();
		eleRegSecQues3Ans.sendKeys(StockConstants.LoginRegister_SecQues3Ans);
		
		eleRegNewSubmit.click();
		
	}
	
	public String getDisplayedEmail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(eleRegGreat));
		
		return eleRegSuccessContent.getText().split("Your email ")[1].split(" is")[0];
	}
	
	public void submitGreat() {
		eleRegGreat.click();
	}
	
	public void versionOk() {
		eleVersionOk.click();
	}
	
	public void anonymousLogin() {
		eleAnyLogin.click();
		scrollIntoViewGesture(StockConstants.Login_Country);
		driver.findElement(By.xpath("//*[@text='"+StockConstants.Login_Country+"']")).click();
		eleAnyCountryOk.click();
	}
	

}
