package screens;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreHomeScreen extends ScreenBase {

	@AndroidFindBy(id="com.android.packageinstaller:id/permission_message")
	public MobileElement permissionMessage;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public MobileElement allowButton;
	
	
	public PreHomeScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public HomeScreen verifyPermissionPrompts() throws InterruptedException{
		
		Thread.sleep(2000);
		String prePop1 = permissionMessage.getText();
		System.out.println("prePop1: "+ prePop1);
		if (prePop1.equals("Allow IRCTC Rail Connect to make and manage calls?")) {
			selectAllowPermission();
		}
		String prePop2 = permissionMessage.getText();
		System.out.println("prePop2: "+ prePop2);
		if (prePop2.equals("Allow IRCTC Rail Connect to access photos, media contents and files on your device?")) {
			selectAllowPermission();
		}
		
		return new HomeScreen(driver);
	}
	
	public void selectAllowPermission(){
		
		allowButton.click();
	}
	
	public void selectDenyPermission(){
		
		
	}

}
