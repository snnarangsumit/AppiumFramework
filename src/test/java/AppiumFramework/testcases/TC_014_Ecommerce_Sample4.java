package AppiumFramework.testcases;

import java.net.MalformedURLException;

import java.util.Set;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.By.ByClassName;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;



import io.appium.java_client.MobileBy;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.android.nativekey.AndroidKey;

import io.appium.java_client.android.nativekey.KeyEvent;



import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;

import java.io.IOException;

import junit.framework.Assert;

import AppiumFramework.resources.*;

public class TC_014_Ecommerce_Sample4 extends base{



public static void main(String[] args) throws InterruptedException, IOException {

AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

     driver.hideKeyboard();

     driver.findElement(By.xpath("//*[@text='Female']")).click();

     driver.findElement(By.id("android:id/text1")).click();

     

     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

     

     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

Thread.sleep(4000);

//Mobile Gestures

WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

TouchAction t=new TouchAction(driver);

t.tap(tapOptions().withElement(element(checkbox))).perform();



driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();



Thread.sleep(7000);

Set<String> contexts=driver.getContextHandles();

for(String contextName :contexts)

{

System.out.println(contextName);

}

driver.context("WEBVIEW_com.androidsample.generalstore");

driver.findElement(By.name("q")).sendKeys("hello");

driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

driver.pressKey(new KeyEvent(AndroidKey.BACK));

driver.context("NATIVE_APP");













}

}

