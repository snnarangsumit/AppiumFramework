package AppiumFramework.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import AppiumFramework.resources.*;

public class TC_007_Sample7miscelleanous extends base {

	@Test     
	public static void apiDemoTest()throws MalformedURLException {
		// TODO Auto-generated method stub

	      AndroidDriver<AndroidElement> driver=samplecapabilities();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     System.out.println(driver.currentActivity());
	     System.out.println(driver.getContext());
	     //views - Native , Hybrid, Webview
	     System.out.println(driver.getOrientation());
	     System.out.println(driver.isDeviceLocked());
	   //  driver.hideKeyboard();
	 	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	 	driver.pressKeyCode(AndroidKeyCode.BACK);
	     
	}

}
