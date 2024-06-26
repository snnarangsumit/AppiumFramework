package AppiumFramework.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;



import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import junit.framework.Assert;
import AppiumFramework.resources.*;


public class TC_011_Ecommerce_Sample1 extends base{

public static void main(String[] args) throws IOException, InterruptedException {

AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

    // driver.hideKeyboard();

     driver.findElement(By.xpath("//*[@text='Female']")).click();

     driver.findElement(By.id("android:id/text1")).click();

     

     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");



System.out.println(toastMessage);

Assert.assertEquals("Please enter your name", toastMessage);//Actual validation

//name attribute for toast messages will have content



     

     

     

     

     

}

}

