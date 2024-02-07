package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.TestBase;

import java.time.Duration;

public class SearchHotelPage extends TestBase {


    By location = By.xpath("//*[@id=\"location\"]");
    By hotels = By.xpath("//*[@id=\"hotels\"]");
    By roomType = By.xpath("//*[@id=\"room_type\"]");
    By numberOfRooms = By.xpath("//*[@id=\"room_nos\"]");
    By checkInDate = By.xpath("//*[@id=\"datepick_in\"]");
    By checkOutDate = By.xpath("//*[@id=\"datepick_out\"]");
    By adultsPerRoom = By.xpath("//*[@id=\"adult_room\"]");
    By childrenPerRoom = By.xpath("//*[@id=\"child_room\"]");
    By searchBtn = By.xpath("//*[@id=\"Submit\"]");

    //validate
    By radioBtnToSelectHotel = By.xpath("//*[@id=\"radiobutton_0\"]");


    public void searchHotel(String Location, String Hotels,  String RoomType, String NumberOfRooms, String CheckInDate,
                            String CheckOutDate, String AdultsPerRoom, String ChildrenPerRoom){

        try{
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(location), "Location", Location);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(hotels), "Hotels", Hotels);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(roomType), "RoomType", RoomType);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(numberOfRooms), "NumberOfRooms", NumberOfRooms);
            clearCustom(DriverFactory.getInstance().getDriver().findElement(checkInDate), "CheckInDate");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(checkInDate), "CheckInDate", CheckInDate);
            clearCustom(DriverFactory.getInstance().getDriver().findElement(checkOutDate), "CheckOutDate");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(checkOutDate), "CheckOutDate", CheckOutDate);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(adultsPerRoom), "AdultsPerRoom", AdultsPerRoom);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(childrenPerRoom), "ChildrenPerRoom", ChildrenPerRoom);

            clickCustom(DriverFactory.getInstance().getDriver().findElement(searchBtn), "SearchHotelButton");

            //validate
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(radioBtnToSelectHotel));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
