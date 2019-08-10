package screens;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrainListScreen extends ScreenBase {

	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_station_name")
	public List<MobileElement> stationsName;
	
	public TrainListScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public TrainListScreen verifyTrainListScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/tv_title_name"), "Train List Screen");
		return new TrainListScreen(driver);
	}
}
