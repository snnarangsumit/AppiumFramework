package AppiumFramework.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import AppiumFramework.resources.*;
import AppiumFramework.resources.base;

public class TC_002_Sample2Uiautomaortest extends base {
	@Test
	public static void apiDemoTest()throws MalformedURLException {
		// TODO Auto-generated method stub

	      AndroidDriver<AndroidElement> driver=samplecapabilities();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //driver.findElementByAndroidUIAutomator("attribute("value")")
	     
	      driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	     
	    //driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	     
	   //Validate clickable feature for all options
	   //  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");  
	     System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()); 
	     
	}

}
