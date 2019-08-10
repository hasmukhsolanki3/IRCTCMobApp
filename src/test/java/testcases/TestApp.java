package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import screens.DashBoardScreen;
import screens.GeneratePINScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.PlanMyJourneyScreen;
import screens.PreHomeScreen;
import screens.SelectStationScreen;
import screens.TrainListScreen;

public class TestApp extends TestBase {
	
	@Test(priority=1)
	public void testApp() throws InterruptedException{
	
		PreHomeScreen preHome = new PreHomeScreen(driver);
		HomeScreen home = preHome.verifyPermissionPrompts();
		LoginScreen login = home.selectTrainTicket();
		GeneratePINScreen pin = login.verifyLoginScreen().doLogin("Username", "Password");
		DashBoardScreen dash = pin.verifyGeneratePINScreen().doGeneratePIN("0000").rememberPINPopUp();
		PlanMyJourneyScreen plan = dash.verifyDashBoardScreen().planMyJourney();
		SelectStationScreen station = plan.verifyPlanMyJourneyScreen().closeTutorial().selectFromToStationOnPlan();
		plan = station.verifySelectStationScreen().selectFromToStation("BANDRA TERMINUS", "DELHI");
		TrainListScreen trainList = plan.selectDate("General", "Apr", "12").searchTrain();
		
		Thread.sleep(5000);
		
	}

}
