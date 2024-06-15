package AppiumFramework.testcases;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Test;

import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_017_Sample11_IOS_WebBrowser_Safari {

IOSDriver driver;

@Test

public void brows() throws MalformedURLException

{

DesiredCapabilities dc = new DesiredCapabilities();

dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");</p>

dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");</p>

dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");</p>

driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("http://gmail.com");

driver.findElementByName("Email").sendKeys("rahul");

driver.findElementByName("Passwd").sendKeys("rahul");

driver.findElementByName("signIn").click();
}
}