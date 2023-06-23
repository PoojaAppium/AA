package Script;

import java.io.IOException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import POM_A.login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class Test {
	
	 private static EnhancedAndroidDriver<MobileElement> Driver;

	 @Rule
	    public TestWatcher watcher = Factory.createWatcher();
	 
	 
	@Before
public void SetUp()  {
		
		try{		
			DesiredCapabilities DC = new DesiredCapabilities();
			DC.setCapability("PlatformVersion", "12");
			DC.setCapability("deviceName", "vivo X70 Pro");
			DC.setCapability("UDID", "1361177652000IA");
			DC.setCapability("platformName", "Android");
			DC.setCapability("appActivity", "com.combitime.MainActivity");
			DC.setCapability("appPackage", "com.combitime.test");
			DC.setCapability("automationName", "UiAutomator2");
			DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			DC.setCapability("noSign", true);
			DC.setCapability("newCommandTimeout", 1000);
			DC.setCapability("autoGrantPermissions",true);
			DC.setCapability(MobileCapabilityType.FULL_RESET,true);
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			Driver = Factory.createAndroidDriver(url, DC);
			Driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS); 
			System.out.println("System Started");
			Thread.sleep(5000);
			}
			catch(Exception exe) {
				exe.printStackTrace();
			}	
		
	}
	
	
	
@org.junit.Test()


public void Launched() throws IOException, InterruptedException{
	
	 Driver.label("LAUNCHEDD");
	
	System.out.print("Launch");
	
}

@org.junit.Test

public void TC_1() throws IOException, InterruptedException{
	
	 Driver.label("TC_1");
	login L = new login(Driver);
	L.TC_1();
	
	
}

//@org.junit.Test
//
//public void TC_2() throws IOException, InterruptedException{
//	
//	 Driver.label("TC_2");
//	login L = new login(Driver);
//	L.TC_2();
//	
//	
//}
//
//@org.junit.Test
//
//public void TC_3() throws IOException, InterruptedException{
//	
//	 Driver.label("TC_3");
//	login L = new login(Driver);
//	L.TC_3();
//	
//	
//}
//
//@org.junit.Test
//
//public void TC_4() throws IOException, InterruptedException{
//	
//	 Driver.label("TC_4");
//	login L = new login(Driver);
//	L.TC_4();
//	
//	
//}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
