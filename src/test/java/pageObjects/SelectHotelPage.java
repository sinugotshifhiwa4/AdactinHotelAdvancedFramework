package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.TestBase;

import java.time.Duration;

public class SelectHotelPage extends TestBase {

    By selectRadioBtn = By.xpath("//*[@id=\"radiobutton_0\"]");
    By continueBtn = By.xpath("//*[@id=\"continue\"]");

    By bookHotelTitle = By.xpath("//td[@colspan=\"2\" and @class=\"login_title\" and contains(text(), \"Book A Hotel\")]\n");



    public void selectHotel(){

        try{
            clickCustom(DriverFactory.getInstance().getDriver().findElement(selectRadioBtn), "SelectHotel");
            clickCustom(DriverFactory.getInstance().getDriver().findElement(continueBtn), "ContinueButton");

            explicitWaitCustom(DriverFactory.getInstance().getDriver().findElement(bookHotelTitle), Duration.ofSeconds(10));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
