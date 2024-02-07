package utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory(){}

    private static DriverFactory instance = new DriverFactory();


    public static DriverFactory getInstance(){

        return instance;
    }


    ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public void setDriver(WebDriver driverTest){

        driver.set(driverTest);
    }

    public WebDriver getDriver(){

        return driver.get();
    }

    public void closeBrowser(){

        try {

            WebDriver currentDriver = driver.get();

            if (currentDriver != null) {

                Thread.sleep(5000);
                currentDriver.close();
                currentDriver.quit();
                driver.remove();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
