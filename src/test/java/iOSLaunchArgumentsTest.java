import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class iOSLaunchArgumentsTest {

    public static void main(String[] args){
        iOSLaunchArgumentsTest androidLaunchArgumentsTest = new iOSLaunchArgumentsTest();
        androidLaunchArgumentsTest.runTheTest();
    }

    URL appiumURL;

    void runTheTest(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 11");
        capabilities.setCapability("platformName", "iOS");
        //capabilities.setCapability("appPackage", "com.josh.automationtestapp");
        //capabilities.setCapability("appActivity", "MainActivity");
        capabilities.setCapability("app", "bs://5ce29412b4e981e310ed69fdd37773b47a9dda88");
        capabilities.setCapability("processArguments","{\"args\": [\n" +
                "  \"-Destination\", \"CaseDetails\"\n" +
                "]}");

        try {
            appiumURL= new URL("https://joshuastrickland1:e8s7S1S2Dzb88ypg28sV@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        AppiumDriver d = new AppiumDriver(appiumURL, capabilities);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.quit();

    }

}
