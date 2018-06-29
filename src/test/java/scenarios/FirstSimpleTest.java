package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Mikhail on 28.06.2018
 */
public class FirstSimpleTest extends DriverSetup {

    @BeforeMethod(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareAndroidNativePhys();
//        prepareAndroidWebPhys();
//        prepareAndroidNative();
//        prepareAndroidWeb();
    }

    @AfterMethod(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest(){
//        String app_package_name = "com.example.android.contactmanager:id/";
//        By add_btn = By.id(app_package_name + "addContactButton");          //in case of using 'id' identifier
//        driver.findElement(add_btn).click();
        By add_btn_xPath = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
        driver.findElement(add_btn_xPath).click();
        System.out.println("Simplest Appium test done");
    }

//    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        System.out.println("Site opening done");
    }
}
