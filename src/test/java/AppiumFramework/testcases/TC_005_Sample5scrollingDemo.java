package AppiumFramework.testcases;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import AppiumFramework.resources.*;

public class TC_005_Sample5scrollingDemo extends base{

	@Test
	public static void apiDemoTest()throws MalformedURLException {
		// TODO Auto-generated method stub

	      AndroidDriver<AndroidElement> driver=samplecapabilities();
	      
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	     
	     
	     
	}

}
