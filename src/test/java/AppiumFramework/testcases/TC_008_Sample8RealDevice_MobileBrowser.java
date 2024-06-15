package AppiumFramework.testcases;

import java.net.MalformedURLException;

import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import AppiumFramework.resources.*;

public class TC_008_Sample8RealDevice_MobileBrowser extends baseChrome {

	@Test
	public static void apiDemoTest()throws MalformedURLException {
		// TODO Auto-generated method stub

	      AndroidDriver<AndroidElement> driver=capabilities();
	      
	      
/* driver.get("http://facebook.com");
driver.findElementByXPath("//*[@id='u_0_1']/div[1]/div/input").sendKeys("qwerty");
driver.findElementByName("pass").sendKeys("12345");
driver.findElementByXPath("//button[@value='Log In']").click();*/
//rahulonlinetutor@gmail.com

driver.get("http://cricbuzz.com");
driver.findElementByXPath("//a[@href='#menu']").click();
driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
System.out.println(driver.getCurrentUrl());
JavascriptExecutor jse = (JavascriptExecutor) driver;
   jse.executeScript("window.scrollBy(0,480)", "");
   Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
   


//adb devices- Unauthorized
//adb kill-server
//adb start-server
//adb devices


}

}