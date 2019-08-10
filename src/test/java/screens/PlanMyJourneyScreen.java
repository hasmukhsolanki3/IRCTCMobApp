package screens;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlanMyJourneyScreen extends ScreenBase {
	
	//--- Plan My Journey Screen ---//
	@AndroidFindBy(uiAutomator ="new UiSelector().textContains(\"My Journey\")")
	public MobileElement planMyJourney;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/got_it")
	public MobileElement gotItBtn;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/fromStn_code")
	public MobileElement fromToStation;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tomorrow_date")
	public MobileElement tomorrowDate;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/journey_date")
	public MobileElement journeyDate;
	
	@AndroidFindBy(id="cris.org.in.prs.ima:id/tv_search")
	public MobileElement searchTrainBtn;
	
	//--- Calandar ---//
	@AndroidFindBy(id="android:id/date_picker_header_date")
	public MobileElement checkMonthCal;
	
	@AndroidFindBy(id="android:id/next")
	public MobileElement nextCal;
	
	@AndroidFindBys({
			@AndroidBy(id="android:id/month_view", priority = 1),
			@AndroidBy(className="android.view.View", priority = 2)})
	public List<MobileElement> datesCal;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement okCal;
	
	public PlanMyJourneyScreen(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	public PlanMyJourneyScreen verifyPlanMyJourneyScreen(){
		
		isElementPresent(By.id("cris.org.in.prs.ima:id/toolbar_title"), "Plan My Journey Screen");
		return new PlanMyJourneyScreen(driver);
	}
	
	public PlanMyJourneyScreen closeTutorial(){
		
		gotItBtn.click();
		return new PlanMyJourneyScreen(driver);
	}
	
	public SelectStationScreen selectFromToStationOnPlan(){
		
		fromToStation.click();
		return new SelectStationScreen(driver);
	}
	
	public PlanMyJourneyScreen selectDate(String type, String month, String date){
		
		if(type.equalsIgnoreCase("General")){
			journeyDate.click();
			selectDateFromDatePicker(month, date);
		}else if(type.equalsIgnoreCase("Tatkal") || type.equalsIgnoreCase("Premium")){
			tomorrowDate.click();
		}  
		return new PlanMyJourneyScreen(driver);
	}
	
	public void selectDateFromDatePicker(String month, String date){
		
		while(!checkMonthCal.getText().contains(month)){
			nextCal.click();
		
			for(MobileElement dateCal:datesCal){
				if(dateCal.getText().contains(date)){
					dateCal.click();
				}
			}
		}
		okCal.click();
	}
	
	public TrainListScreen searchTrain(){
		
		searchTrainBtn.click();
		return new TrainListScreen(driver);
	}

}
