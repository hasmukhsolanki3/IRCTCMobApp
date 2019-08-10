package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LaunchApp {

	public static AndroidDriver<WebElement> driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Initializing Appium Server:
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File(
						"C:\\Users\\Hasmukh Solanki\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(
						System.getProperty("user.dir") + "\\src\\test\\resources\\appiumServerLogs\\logs.txt")));

		// Starting Appium Server:
		service.start();

		// Initializing Real Device Settings:
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("appPackage", "cris.org.in.prs.ima");
		capabilities.setCapability("appActivity", "cris.org.in.ima.activities.IRCTCConnectActivity");

		// Starting Android Driver and launching Chrome:
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(5000);
		String prePop1 = driver.findElement(By.id("com.android.packageinstaller:id/permission_message")).getText();
		System.out.println("prePop1: "+ prePop1);
		if (prePop1.equals("Allow IRCTC Rail Connect to make and manage calls?")) {
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}
		String prePop2 = driver.findElement(By.id("com.android.packageinstaller:id/permission_message")).getText();
		System.out.println("prePop2: "+ prePop2);
		if (prePop2.equals("Allow IRCTC Rail Connect to access photos, media contents and files on your device?")) {
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}

		// Stopping Appium Service:
		service.stop();
	}

}