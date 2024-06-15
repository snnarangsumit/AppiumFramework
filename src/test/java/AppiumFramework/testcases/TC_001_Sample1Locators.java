package AppiumFramework.testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import AppiumFramework.resources.*;

import org.openqa.selenium.remote.*;

public class TC_001_Sample1Locators extends base{

	@Test
	public static void apiDemoTest()throws MalformedURLException {
		// TODO Auto-generated method stub
	
		AndroidDriver<AndroidElement> driver= samplecapabilities();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     
  //xpath id className, androidUIautomator
     /*    xpath Syntax
      *    //tagName[@attribute='value']
    
      * 
      */
     driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
     driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
     driver.findElementById("android:id/checkbox").click();
     driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
     driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
     driver.findElementsByClassName("android.widget.Button").get(1).click();
     
	}


	
	
	public static AndroidDriver<AndroidElement> samplecapabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement>  driver;

		// TODO Auto-generated method stub
	 File appDir = new File("src");
	 File app = new File(appDir, "ApiDemos-debug.apk");
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 
	 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator_SumitDeviceSample");
	 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	 capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
	
	 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	    
	    return driver;
	}

}
