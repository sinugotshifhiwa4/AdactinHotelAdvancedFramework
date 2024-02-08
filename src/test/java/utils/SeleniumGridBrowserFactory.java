package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridBrowserFactory {

    public WebDriver createBrowserInstance(String browser) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setBrowserName("chrome");
                break;
            case "firefox":
                capabilities.setBrowserName("firefox");
                break;
            case "edge":
                capabilities.setBrowserName("MicrosoftEdge");
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }

        return new RemoteWebDriver(capabilities);
    }
}
