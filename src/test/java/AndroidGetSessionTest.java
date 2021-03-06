import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidGetSessionTest {

    public static void main(String[] args){
        AndroidGetSessionTest androidLaunchArgumentsTest = new AndroidGetSessionTest();
        androidLaunchArgumentsTest.runTheTest();
    }

    URL appiumURL;

    void runTheTest(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Google Pixel");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("appPackage", "com.josh.automationtestapp");
        //capabilities.setCapability("appActivity", "MainActivity");
        capabilities.setCapability("app", "bs://8dbe821600b237cdf0df4b17e30e836feb3d30ef");
        capabilities.setCapability("browserstack.networkLogs",true);

        try {
            appiumURL= new URL("https://joshuastrickland1:e8s7S1S2Dzb88ypg28sV@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        AndroidDriver d = new AndroidDriver(appiumURL, capabilities);
        System.out.println("Session ID: "+ d.getSessionId());
        //d.startActivity(new Activity("com.verint.xm.daksha","crc64d9654f7b9f8df9e6.ShellActivity").setOptionalIntentArguments("--es \"Destination\" \"CaseResolve\""));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.quit();

    }

}
