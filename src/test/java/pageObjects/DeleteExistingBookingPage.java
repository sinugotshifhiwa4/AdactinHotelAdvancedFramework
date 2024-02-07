package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utils.DriverFactory;
import utils.TestBase;

public class DeleteExistingBookingPage extends TestBase {

    By bookedItinerary = By.xpath("//a[@href=\"BookedItinerary.php\" and text()=\"Booked Itinerary\"]\n");
    By searchOrderId = By.xpath("//*[@id=\"order_id_text\"]");
    By goBtn = By.xpath("//*[@id=\"search_hotel_id\"]");
    By selectRadioBtn = By.xpath("//input[@name=\"ids[]\"]\n");
    By cancelSelectedBtn = By.xpath("//input[@name=\"cancelall\" and @type=\"submit\" and @value=\"Cancel Selected\"]\n");

    public void deleteExistingBooking(String orderId){

        try{

            clickCustom(DriverFactory.getInstance().getDriver().findElement(bookedItinerary), "BookedItinerary");
            clearCustom(DriverFactory.getInstance().getDriver().findElement(searchOrderId), "SearchOrderId");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(searchOrderId), "SearchOrderId", orderId);
            clickCustom(DriverFactory.getInstance().getDriver().findElement(goBtn), "GoButton");
            Thread.sleep(2000);

            clickCustom(DriverFactory.getInstance().getDriver().findElement(selectRadioBtn), "SelectRadioButton");
            Thread.sleep(2000);
            clickCustom(DriverFactory.getInstance().getDriver().findElement(cancelSelectedBtn), "CancelSelectedButton");
            Thread.sleep(2000);

            // alert
            Alert alert = DriverFactory.getInstance().getDriver().switchTo().alert();
            Thread.sleep(2000);
            alert.accept();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
