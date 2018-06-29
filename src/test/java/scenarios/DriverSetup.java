package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mikhail on 28.06.2018
 */
public class DriverSetup {
    protected AndroidDriver driver;

    /**
     * Set of capabilities to test Android native app
     * @throws MalformedURLException
     */
    protected void prepareAndroidNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // mandatory capabilities
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");

        // path to app
        File appDir = new File("C:\\Users\\Mikhail\\Desktop\\EPAM Systems\\Automation Testing" +
                "\\MikhailBystrovMobile\\src\\main\\resources");
        File app = new File(appDir, "ContactManager.apk");

        // other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    /**
     * Set of capabilities to test Android web app
     * @throws MalformedURLException
     */
    protected void prepareAndroidWeb() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // mandatory capabilities
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");

        // other caps
        capabilities.setCapability("chromedriverExecutableDir",
                "C:\\Users\\Mikhail\\Desktop\\EPAM Systems\\Automation Testing" +
                        "\\MikhailBystrovMobile\\src\\main\\resources");
        capabilities.setCapability("browserName", "Chrome");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

     /**
     * Set of capabilities to test Android native app with real physical device
     * @throws MalformedURLException
     */
    protected void prepareAndroidNativePhys() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // mandatory capabilities
        capabilities.setCapability("deviceName", "c21b9a8d7d94");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.2");

        // path to app
        File appDir = new File("C:\\Users\\Mikhail\\Desktop\\EPAM Systems\\Automation Testing" +
                "\\MikhailBystrovMobile\\src\\main\\resources");
        File app = new File(appDir, "ContactManager.apk");

        // other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    /**
     * Set of capabilities to test Android web app with real physical device
     * @throws MalformedURLException
     */
    protected void prepareAndroidWebPhys() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // mandatory capabilities
        capabilities.setCapability("deviceName", "c21b9a8d7d94");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.2");

        // other caps
        capabilities.setCapability("chromedriverExecutableDir",
                "C:\\Users\\Mikhail\\Desktop\\EPAM Systems\\Automation Testing" +
                        "\\MikhailBystrovMobile\\src\\main\\resources");
        capabilities.setCapability("browserName", "Chrome");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}

