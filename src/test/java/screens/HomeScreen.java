package screens;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class HomeScreen extends ScreenBase {

	@AndroidFindBy(id="cris.org.in.prs.ima:id/rl_train_ticket")
	public MobileElement trainTicket;
	
	public HomeScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public void verifyHomeScreen(){
		
		
	}
	
	public LoginScreen selectTrainTicket() {
		
		//trainTicket.click();
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(550, 550)).perform();
		
		return new LoginScreen(driver);		
	}

}
