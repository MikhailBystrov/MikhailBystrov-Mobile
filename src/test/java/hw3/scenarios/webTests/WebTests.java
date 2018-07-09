package hw3.scenarios.webTests;

import ex3.enums.PropertyFile;
import ex3.setup.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "web")
public class WebTests extends Hooks {

    protected WebTests() throws IOException {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website and check blocks presence")
    public void webTest() throws Exception {
        //Open site
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        System.out.println("Site opening done");

        //Check page title
        assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority");
        //Check that "Domain Names" block is displayed and have proper title
        By domainNames = By.id("home-panel-domains");
        assertTrue(driver().findElement(domainNames).isDisplayed());
        assertTrue(driver().findElement(domainNames).getText().contains("Domain Names"));
        //Check that "Number Resources" block is displayed and have proper title
        By numberResources = By.id("home-panel-numbers");
        assertTrue(driver().findElement(numberResources).isDisplayed());
        assertTrue(driver().findElement(numberResources).getText().contains("Number Resources"));
        //Check that "Protocol Assignments" block is displayed
        By protocolAssignments = By.id("home-panel-protocols");
        assertTrue(driver().findElement(protocolAssignments).isDisplayed());
        assertTrue(driver().findElement(protocolAssignments).getText().contains("Protocol Assignments"));

        System.out.println("Simplest Appium test done");
    }

}
