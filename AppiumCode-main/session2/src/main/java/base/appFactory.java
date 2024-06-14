package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.configFileReader;

import java.net.MalformedURLException;
import java.net.URL;

public class appFactory {

    public static AppiumDriver driver;

    public static utilities.configFileReader configFileReader;

    public static void initialize() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        configFileReader = new configFileReader();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getdeviceName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, configFileReader.getplatformVersion());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, configFileReader.getautomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getplatformName());
        cap.setCapability(MobileCapabilityType.TIMEOUTS, 10000);
        cap.setCapability(MobileCapabilityType.APP,configFileReader.getapp());
        driver = new AndroidDriver(new URL(configFileReader.getappiumServerPath()), cap);
        appDriver.setDriver(driver);
        System.out.println("Android driver is set");

    }

    public static void quitDriver(){
        if (null!= driver){
            driver.quit();
        }
    }
}

