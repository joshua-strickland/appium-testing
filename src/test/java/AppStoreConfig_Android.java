import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppStoreConfig_Android {

    public static String userName = "joshuastrickland1";
    public static String accessKey = "e8s7S1S2Dzb88ypg28sV";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        MobileElement ele = null;
        AppiumDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("project", "Test Run");
        caps.setCapability("build", "Build v1");
        caps.setCapability("name", "Test: AppStore Login - Other Creds");

        caps.setCapability("device", "Google Pixel");
        caps.setCapability("os_version", "8.0");

        // REF- https://www.browserstack.com/app-automate/rest-api#app-upload
        caps.setCapability("app", "bs://025deacca3900c8235e00d8406471bc912b3760e");

        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.deviceLogs", "true");

        // REF- https://www.browserstack.com/app-automate/capabilities#test-configuration-capabilities
        Map<String, String> creds = new HashMap<String, String>();
        creds.put("username", "verintmobiletestuser1@gmail.com");
        creds.put("password", "ver1nt-qa");

        caps.setCapability("browserstack.appStoreConfiguration", creds);

        try {

            driver = new AndroidDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

            ele = (MobileElement) driver.findElement(MobileBy.xpath(".//android.widget.Button[@text='CLICK']"));
            ele.click();
            Thread.sleep(3000);
            take_screenshot(driver);

            try {
                ele = (MobileElement) driver.findElement(MobileBy.xpath(".//android.widget.Button[@text='SIGN IN']"));
                ele.click();
                Thread.sleep(3000);
                take_screenshot(driver);
                System.out.println("NO ERROR - SIGN IN BUTTON DISPLAYED");
            } catch (Exception e) {
                System.out.println("ERROR_SIGN_IN_BTN");
            }

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            if(driver != null){
                driver.quit();
            }
        } // TRY END
    } // FUNC END

    public static void take_screenshot(WebDriver webDriver){
        try {
            TakesScreenshot scrShot =((TakesScreenshot)webDriver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//			File DestFile=new File("/Users/test/Documents/test.png");
//			FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // FUNC END

} // CLASS END