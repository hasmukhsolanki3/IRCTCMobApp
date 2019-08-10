package screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase {

	@AndroidFindBy(id="cris.org.in.prs.ima:id/et_username")
	public MobileElement username;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/et_password")
	public MobileElement password;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/rl_login_layout")
	public MobileElement loginBtn;
	
	
	public LoginScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public LoginScreen verifyLoginScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/rl_login_layout"), "Login Screen");
		return new LoginScreen(driver);
	}
	
	public GeneratePINScreen doLogin(String uname, String pass){
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		hideKeyboard();
		loginBtn.click();
		return new GeneratePINScreen(driver);
	}
	
	public void selectForgotPassord(){
		
		
	}
	
	public void selectRegister(){
		
		
	}

}
