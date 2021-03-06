package ex3.setup;

import ex3.enums.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Driver extends TestProperties {

    private static AppiumDriver driverSingle;
    private static WebDriverWait waitSingle;

    // Properties to be read
    private String APP; // (mobile) app under testing
    protected String SUT; // site under testing
    private String TEST_PLATFORM;
    private String TEST_PLATFORM_VERSION;
    private String DRIVER;
    private String DEVICE_NAME;

    // Constructor initializes properties on driver creation
    protected Driver(PropertyFile propertyFile) throws IOException {
        this.propertyFile = propertyFile;

        switch (propertyFile) {
            case NATIVE:
                APP = getProp("app");
                break;
            case WEB:
                String t_sut = getProp("sut");
                SUT = t_sut == null ? null : "http://" + t_sut;
                break;
        }

        TEST_PLATFORM = getProp("platformName");
        TEST_PLATFORM_VERSION = getProp("platformVersion");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("deviceName");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     */

    void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, TEST_PLATFORM_VERSION);

        // Setup type of application: mobile, web (or hybrid)
        if (APP != null && SUT == null) {
            // Native
            File app = new File(APP);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && APP == null) {
            File file = new File("src\\main\\resources\\chromedriver.exe");
            capabilities.setCapability("chromedriverExecutableDir", file.getAbsoluteFile().getParent());
            // Web
            // Setup test platform: Android or iOS. Browser also depends on a platform.
            switch (TEST_PLATFORM) {
                case "Android":
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                    break;
                case "iOS":
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                    break;
            }
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        switch (TEST_PLATFORM) {
            case "Android":
                driverSingle = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case "iOS":
                driverSingle = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }

        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}

