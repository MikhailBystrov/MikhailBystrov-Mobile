package hw3.scenarios.nativeTests;

import ex3.enums.PropertyFile;
import ex3.setup.Hooks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

@Test(groups = "native")
public class NativeTests extends Hooks {

    protected NativeTests() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Just click on button 'Add contact' and check fields")
    public void simplestTest() throws Exception {
        String xPathTitle = "//android.widget.TextView[@content-desc=";
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        // Check that keyboard is presented
        assertTrue(((AndroidDriver) driver()).isKeyboardShown());

        // Check that other fields are displayed
        // Check 'target account' field presence and have proper text.
        By targetAccount = By.id(app_package_name + "accountSpinner");
        assertTrue(driver().findElement(targetAccount).isDisplayed());
        By targetAccountTitle = By.xpath(xPathTitle + "\"Target Account\"]");
        assertTrue(driver().findElement(targetAccountTitle).getText().contains("Target Account"));
        // Check 'contact name' field presence and have proper text.
        By contactName = By.id(app_package_name + "contactNameEditText");
        assertTrue(driver().findElement(contactName).isDisplayed());
        By contactNameTitle = By.xpath(xPathTitle + "\"Contact Name\"]");
        assertTrue(driver().findElement(contactNameTitle).getText().contains("Contact Name"));
        // Check 'contact phone' field presence and have proper text.
        By contactPhone = By.id(app_package_name + "contactPhoneEditText");
        assertTrue(driver().findElement(contactPhone).isDisplayed());
        By contactPhoneTitle = By.xpath(xPathTitle + "\"Contact Phone\"]");
        assertTrue(driver().findElement(contactPhoneTitle).getText().contains("Contact Phone"));
        // Check 'target account' field presence and have proper text.
        By contactEmail = By.id(app_package_name + "contactEmailEditText");
        assertTrue(driver().findElement(contactEmail).isDisplayed());
        By contactEmailTitle = By.xpath(xPathTitle + "\"Contact Email\"]");
        assertTrue(driver().findElement(contactEmailTitle).getText().contains("Contact Email"));

        System.out.println("Simplest Appium test done");
    }
}


