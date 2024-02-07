package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverFactory;
import utils.TestBase;

import java.time.Duration;

public class LoginPage extends TestBase {

    By usernameTextBox = By.xpath("//*[@id=\"username\"]");
    By passwordTextBox = By.xpath("//*[@id=\"password\"]");
    By loginBtn = By.xpath("//*[@id=\"login\"]");

    //validation
    By userProfile = By.xpath("//*[@id=\"username_show\"]");


    public void logIn(String Username, String Password){

        try {
            clearCustom(DriverFactory.getInstance().getDriver().findElement(usernameTextBox), "LoginUsernameField");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(usernameTextBox), "LoginUsernameField", Username);
            clearCustom(DriverFactory.getInstance().getDriver().findElement(passwordTextBox), "LoginPasswordField");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(passwordTextBox), "LoginPasswordField", Password);
            clickCustom(DriverFactory.getInstance().getDriver().findElement(loginBtn), "LoginButton");

            //validate
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(userProfile));

            Assert.assertTrue(isElementPresent(DriverFactory.getInstance().getDriver().findElement(userProfile), "User Profile"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
