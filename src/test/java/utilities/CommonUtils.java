package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static String APP_PATH;
	public static String BASE_PACKAGE;
	public static String APP_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_SERVER_PORT;
	public static int IMPLICIT_WAIT;
	public static int EXPLICIT_WAIT;
	public static URL serverURL;
	
	private static Properties properties = new Properties();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static AndroidDriver<MobileElement> driver;
	
	//loadIOSConfigProperties
	public static void loadAndroidConfigProperties(String propertyFileName) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+propertyFileName);
		properties.load(fis);
		
		APP_PATH = properties.getProperty("application.path");
		BASE_PACKAGE = properties.getProperty("base.package");
		APP_ACTIVITY = properties.getProperty("application.activity");
		BROWSER_NAME = properties.getProperty("browser.name");
		PLATFORM_NAME = properties.getProperty("platform.name");
		PLATFORM_VERSION = properties.getProperty("platform.version");
		DEVICE_NAME = properties.getProperty("device.name");
		APPIUM_SERVER_PORT = properties.getProperty("appium.server.port");
		IMPLICIT_WAIT = Integer.parseInt(properties.getProperty("implicit.wait"));
		EXPLICIT_WAIT = Integer.parseInt(properties.getProperty("explicit.wait"));
	}
	
	//setIOSCapabilities
	public static void setAndroidCapabilities(){
		
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PACKAGE);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		
	}
	
	//getIOSDriver
	public static AndroidDriver<MobileElement> getAndroidDriver() throws MalformedURLException{
		
		serverURL = new URL("http://localhost:"+APPIUM_SERVER_PORT+"/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverURL, capabilities);
		
		return driver;
	}
}
