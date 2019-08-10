package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase {
	
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	public ScreenBase(AndroidDriver<MobileElement> driver){
		
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 60);
	}
	
	public void hideKeyboard(){
		
		driver.hideKeyboard();
	}
	
	public Boolean isElementPresent(By by, String elementName){
		
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			System.out.println(elementName+" Displayed");
		}catch(Throwable t){
			System.out.println(elementName+" Not Displayed");
		}
		
		return null;
	}
}
