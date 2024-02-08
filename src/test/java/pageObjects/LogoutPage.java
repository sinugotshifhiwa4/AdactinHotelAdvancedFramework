package pageObjects;

import org.openqa.selenium.By;
import utils.DriverFactory;
import utils.TestBase;

public class LogoutPage extends TestBase {

    By logoutTab = By.xpath("//a[text()='Logout' and @href='Logout.php']\n");
    By linkToLoginAgain = By.xpath("//a[text()='Click here to login again' and @href='index.php']\n");


    public void logOut(){

        try{
            clickCustom(DriverFactory.getInstance().getDriver().findElement(logoutTab), "Logout");
            clickCustom(DriverFactory.getInstance().getDriver().findElement(linkToLoginAgain), "LinkToLoginAgain");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
