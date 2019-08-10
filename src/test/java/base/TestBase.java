package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utilities.AppiumServer;
import utilities.CommonUtils;
import utilities.ExcelReader;

public class TestBase {
	
	public static AndroidDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android.properties";
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp() throws IOException{
		
		if(driver == null){
			AppiumServer.start();
			log.debug("Appium Server Started");
			
			if(loadPropertyFile.startsWith("Android")){
				
				CommonUtils.loadAndroidConfigProperties(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
				
			}else if(loadPropertyFile.startsWith("IOS")){
				
				/*CommonUtils.loadIOSConfigProperties(loadPropertyFile);
				CommonUtils.setIOSCapabilities();
				driver = CommonUtils.getIOSDriver();*/
			}
			
		}
	}
	
	@AfterSuite
	public void teardown(){
		
		driver.quit();
		AppiumServer.stop();
		log.debug("Appium Server Stopped");
	}

}
