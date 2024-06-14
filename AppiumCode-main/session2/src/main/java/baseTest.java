import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import jdk.internal.jline.internal.TestAccessible;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.configFileReader;

import java.net.MalformedURLException;
import java.net.URL;


public class baseTest {
    public static AppiumDriver driver;

    public static utilities.configFileReader configFileReader;
    @Test
    public void initialize() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        configFileReader = new configFileReader();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getdeviceName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, configFileReader.getplatformVersion());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, configFileReader.getautomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getplatformName());
        cap.setCapability(MobileCapabilityType.TIMEOUTS, 10000);
        cap.setCapability(MobileCapabilityType.APP,configFileReader.getapp());
        URL url = new URL(configFileReader.getappiumServerPath());
        driver = new AppiumDriver(url, cap);
    }
}
