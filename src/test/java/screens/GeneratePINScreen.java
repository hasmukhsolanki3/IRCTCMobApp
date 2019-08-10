package screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneratePINScreen extends ScreenBase {
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/et_pin")
	public MobileElement enterPIN;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/et_re_enter_pin")
	public MobileElement reEnterPIN;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_submit")
	public MobileElement submitBtn;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement okRememberPIN;
	
	public GeneratePINScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public GeneratePINScreen verifyGeneratePINScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/tv_title_name"), "Generate PIN Screen");
		return new GeneratePINScreen(driver);
	}
	
	public GeneratePINScreen doGeneratePIN(String pin){
		
		enterPIN.sendKeys(pin);
		reEnterPIN.sendKeys(pin);
		hideKeyboard();
		submitBtn.click();
		return new GeneratePINScreen(driver);
	}
	
	public DashBoardScreen rememberPINPopUp(){
		
		isElementPresent(By.id("android:id/alertTitle"), "Remember PIN PopUp");
		okRememberPIN.click();
		return new DashBoardScreen(driver);
	}

}
