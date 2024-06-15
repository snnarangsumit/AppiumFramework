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


public class TC_013_Ecommerce_Sample3 extends base{



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

     



     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

     

int count=    driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

   

     

    for(int i=0;i<count;i++)

    {

    String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

   

    if(text.equalsIgnoreCase("Jordan 6 Rings"))

    {

   

driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

break;

    }

   

   

    }

   

    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

     

String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

Assert.assertEquals("Jordan 6 Rings", lastpageText);

     

     

     

}

}

