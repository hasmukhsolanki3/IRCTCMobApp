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

public class SelectStationScreen extends ScreenBase {
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_search_text")
	public MobileElement searchStation;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_station_name")
	public List<MobileElement> fromStationsName;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_station_name")
	public List<MobileElement> toStationsName;
	
	public SelectStationScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public SelectStationScreen verifySelectStationScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/tv_title_name"), "Select Station Screen");
		return new SelectStationScreen(driver);
	}
	
	public PlanMyJourneyScreen selectFromToStation(String fromStation, String toStation){
		
		searchStation.sendKeys(fromStation);
		for(MobileElement fromStationName: fromStationsName){
			System.out.println("hiii1 -->"+fromStationName.getText());
			if(fromStationName.getText().equals(fromStation)){
				fromStationName.click();
			}
		}
		isElementPresent(By.id("cris.org.in.prs.ima:id/to_divider"), "Select To Station Screen");
		searchStation.sendKeys(toStation);
		for(MobileElement toStationName: toStationsName){
			System.out.println("hiii2 -->"+toStationName.getText());
			if(toStationName.getText().equals(toStation)){
				System.out.println("hiii3 clicking -->"+toStationName.getText());
				toStationName.click();
				System.out.println("hiii4 clicked -->"+toStationName.getText());
				break;
			}
		}
		System.out.println("bye");
		return new PlanMyJourneyScreen(driver);
	}
}
