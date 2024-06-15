package AppiumFramework.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class base {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	  public static String  serviceUrl;
	

	  
	  public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	
	System.out.println("flag: " +flag);
	
	if(!flag)
	{
		
		//service=AppiumDriverLocalService.buildDefaultService();
		//service.start();
		

		//Build the Appium service
		       // AppiumServiceBuilder builder;
			//	builder = new AppiumServiceBuilder();
				//builder.withIPAddress("127.0.0.1");
				//builder.usingPort(4723);
              //  AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
              //  service.start();
                  //your test scripts logic...
               // service.stop();


		//service = AppiumDriverLocalService
			//	.buildService(new AppiumServiceBuilder()
			//			.usingDriverExecutable(new File("C:/Program Files/nodejs/node"))
				//		.withAppiumJS(
				//				new File(
				//						"C:/Users/Sumit/AppData/Local/Programs/Appium/resources/app/node_modules/appium/lib/appium.js"))
				//		.withIPAddress("127.0.0.1").usingPort(4723));
		
		
		
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:/Users/Sumit/AppData/Local/Programs/Appium/resources/app/node_modules/appium/build/lib/main.js"))
				.withArgument(GeneralServerFlag.LOG_LEVEL, "info")
				.usingAnyFreePort();
		
		service = builder.build();
		service.start();
		serviceUrl = service.getUrl().toString();
		
	}
		return service;
		
	}
	
	
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
			
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}


public static void startEmulator() throws IOException, InterruptedException
{

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\java\\AppiumFramework\\resources\\startEmulator.bat");
	Thread.sleep(20000);
	System.out.println("Emulator started");
	Thread.sleep(10000);
}

	public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\AppiumFramework\\resources\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
	

		// TODO Auto-generated method stub
	 File appDir = new File("src");
     File app = new File(appDir, (String) prop.get(appName));
     
     
     DesiredCapabilities capabilities = new DesiredCapabilities();
     String device=(String) prop.get("device");
    //String device= System.getProperty("deviceName");
    System.out.println("Device: " +device);
  
    
  if(device.contains("emulator"))
  {
  startEmulator();
  }
  
  
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
     capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,25);
     
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
     
    
     driver = new AndroidDriver<AndroidElement>(new URL(serviceUrl), capabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
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