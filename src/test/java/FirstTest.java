import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    public static void main(String[] args){
        FirstTest firstTest = new FirstTest();
        firstTest.runTheTest();
    }

    URL appiumURL;

    void runTheTest(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.josh.automationtestapp");
        capabilities.setCapability("appActivity", "MainActivity");

        try {
            appiumURL= new URL("http://127.0.0.1:" + 5010 + "/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        AppiumDriver driver = new AppiumDriver(appiumURL, capabilities);

        driver.findElement(By.id("editTextFieldId")).sendKeys("Test!");

    }

}
