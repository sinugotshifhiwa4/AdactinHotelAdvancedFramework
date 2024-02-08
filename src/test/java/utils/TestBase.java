package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

import java.io.IOException;
import java.time.Duration;

public class TestBase extends ActionEngine {


    @BeforeMethod
    public void launchApplication() {

        //BrowserFactory browserFactory = new BrowserFactory();
        SeleniumGridBrowserFactory browserFactory = new SeleniumGridBrowserFactory();

        try {

            //setup browser and url
            String sBROWSER = PropertiesOperations.getPropertyValueByKey("chooseBrowser");
            String sURL = PropertiesOperations.getPropertyValueByKey("appUrl");

            //set WebDriver
            DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(sBROWSER));
            WebDriver driver = DriverFactory.getInstance().getDriver();

            System.out.println("WebDriver instance set successfully.");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(sURL);

            System.out.println("Application launched successfully.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown(){

        DriverFactory.getInstance().closeBrowser();
    }
}

