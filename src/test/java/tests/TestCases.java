package tests;

import org.testng.annotations.Test;
import pageObjects.*;
import reusableComponents.FileGenerator;
import utils.MyLogger;
import utils.TestBase;

public class TestCases extends TestBase {

    LoginPage loginPage= new LoginPage();
    SearchHotelPage searchHotelPage = new SearchHotelPage();
    SelectHotelPage selectHotelPage = new SelectHotelPage();
    BookHotelPage bookHotelPage = new BookHotelPage();
    DeleteExistingBookingPage deleteExistingBookingPage = new DeleteExistingBookingPage();
    FileGenerator generator = new FileGenerator();

@Test(priority = 1)
    public void bookHotelSuccessfully(){

        loginPage.logIn("User9609", "password");
        searchHotelPage.searchHotel(
                "London",
                "Hotel Sunshine",
                "Deluxe",
                "4 - Four",
                "07/02/2024",
                "14/02/2024",
                "2 - Two",
                "1 - One");
        selectHotelPage.selectHotel();
        bookHotelPage.bookHotel(
                "John",
                "Doe",
                "123 Avenue, Sandton, 2196",
                "4012888888881881",
                "VISA",
                "October",
                "2026",
                "123"
        );

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Book Hotel was successful");

    }

    @Test(priority = 2, dependsOnMethods = "bookHotelSuccessfully")
    public void deleteExistingBooking(){

    String orderNumber = generator.readFromFile();

    try{
        loginPage.logIn("user9609", "password");
        deleteExistingBookingPage.deleteExistingBooking(orderNumber);

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Booked Hotel was deleted successful");

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }
}
