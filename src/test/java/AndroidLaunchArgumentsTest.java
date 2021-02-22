import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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
        capabilities.setCapability("deviceName", "Google Pixel 3");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        //capabilities.setCapability("appPackage", "com.fsr.tracker.testApp");
        //capabilities.setCapability("appActivity", "MainActivity");
        capabilities.setCapability("app", "bs://4f3f6765a3b8c4a8cfd370c2637c5798e54c8633");

        try {
            appiumURL= new URL("https://joshuastrickland1:e8s7S1S2Dzb88ypg28sV@hub-cloud.browserstack.com/wd/hub");
            //appiumURL= new URL("http://127.0.0.1:5010/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        AndroidDriver d = new AndroidDriver(appiumURL, capabilities);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //accept local storage prompt.
        d.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

        //d.startActivity(new Activity("com.verint.xm.daksha","crc64d9654f7b9f8df9e6.ShellActivity").setOptionalIntentArguments("--es \"Destination\" \"CaseResolve\""));

        d.startActivity(new Activity("com.fsr.tracker.testApp","com.fsr.tracker.testApp.MainActivity").setOptionalIntentArguments("--es \"VRNT_status_raw\" \"{\"encodingVersion\":4,\"firstLaunchDate\":{\"date\":1613152552971},\"lastLaunchDate\":{\"date\":1613152552971},\"launchCount\":200,\"pageViews\":5,\"respondentId\":\"D4417855065E6C719FEEDCB286D95AB4\",\"significantEvents\":{},\"state\":\"PENDING_EXIT_SURVEY\",\"surveyCompleted\":false,\"surveyDeclined\":false,\"thisLaunchDate\":{\"date\":1613180144242}}\"")); //adjusted triggermeasure out

        //d.startActivity(new Activity("com.fsr.tracker.testApp","com.fsr.tracker.testApp.MainActivity")); works



        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.quit();

    }

}
