import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidLaunchArgumentsTest {

    public static void main(String[] args){
        AndroidLaunchArgumentsTest androidLaunchArgumentsTest = new AndroidLaunchArgumentsTest();
        androidLaunchArgumentsTest.runTheTest();
    }

    URL appiumURL;

    void runTheTest(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Google Pixel");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("appPackage", "com.josh.automationtestapp");
        //capabilities.setCapability("appActivity", "MainActivity");
        capabilities.setCapability("app", "bs://f7892ccef8121b8fb523f95bebcc2300e9ccc039");

        try {
            appiumURL= new URL("https://joshuastrickland1:e8s7S1S2Dzb88ypg28sV@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        AndroidDriver d = new AndroidDriver(appiumURL, capabilities);
        d.startActivity(new Activity("com.verint.xm.daksha","crc64d9654f7b9f8df9e6.ShellActivity").setOptionalIntentArguments("--es \"Destination\" \"CaseResolve\""));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.quit();

    }

}
