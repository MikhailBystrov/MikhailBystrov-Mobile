package ex3.setup;

import ex3.enums.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;

import java.io.IOException;

/**
 * Created by Mikhail on 07.07.2018
 */
public class Hooks extends Driver {

    protected Hooks(PropertyFile propertyFile) throws IOException {
        super(propertyFile);
    }

    @BeforeGroups(groups = {"web"}, description = "Prepare driver to run test(s)")
    public void setUpNative() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for native app");
    }

    @BeforeGroups(groups = {"native"}, description = "Prepare driver to run test(s)")
    public void setUpWeb() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for web");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
