package screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashBoardScreen extends ScreenBase {

	@AndroidFindBy(uiAutomator ="new UiSelector().textContains(\"My Journey\")")
	public MobileElement planMyJourney;
	
	public DashBoardScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public DashBoardScreen verifyDashBoardScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/toolbar_title"), "DashBoard Screen");
		return new DashBoardScreen(driver);
	}
	
	public PlanMyJourneyScreen planMyJourney(){
		
		planMyJourney.click();
		return new PlanMyJourneyScreen(driver);
	}
}
