import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AndroidPlayStoreTest {

    public static void main(String[] args){
        AndroidPlayStoreTest androidLaunchArgumentsTest = new AndroidPlayStoreTest();
        androidLaunchArgumentsTest.runTheTest();
    }

    URL appiumURL;

    void runTheTest(){
        // Use Java Client v6.0.0 or above
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("app", "bs://025deacca3900c8235e00d8406471bc912b3760e");
        capabilities.setCapability("browserstack.appStoreConfiguration", new HashMap<String, String>() {{ put("username", "verintmobiletestuser1@gmail.com"); put("password", "ver1nt-qa"); }});

        try {
            appiumURL= new URL("https://joshuastrickland1:e8s7S1S2Dzb88ypg28sV@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        AndroidDriver d = new AndroidDriver(appiumURL, capabilities);
        //System.out.println("Session ID: "+ d.getSessionId());
        //d.startActivity(new Activity("com.verint.xm.daksha","crc64d9654f7b9f8df9e6.ShellActivity").setOptionalIntentArguments("--es \"Destination\" \"CaseResolve\""));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.quit();

    }

}