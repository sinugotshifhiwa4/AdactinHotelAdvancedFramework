package tests;

import org.testng.annotations.Test;
import pageObjects.*;
import reusableComponents.ExcelOperations;
import reusableComponents.FileGenerator;
import reusableComponents.PropertiesOperations;
import utils.MyLogger;
import utils.TestBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCases extends TestBase {

    LoginPage loginPage= new LoginPage();
    SearchHotelPage searchHotelPage = new SearchHotelPage();
    SelectHotelPage selectHotelPage = new SelectHotelPage();
    BookHotelPage bookHotelPage = new BookHotelPage();
    DeleteExistingBookingPage deleteExistingBookingPage = new DeleteExistingBookingPage();
    FileGenerator generator = new FileGenerator();
    ExcelOperations excel = new ExcelOperations();
    LogoutPage logoutPage = new LogoutPage();


    @Test
    public void bookHotel1() throws IOException {

    String  sDataSheet= PropertiesOperations.getPropertyValueByKey("dataSheet");
    String sExcelPath = PropertiesOperations.getPropertyValueByKey("excelPath");


    List<Map<String, String>> dataFromSheet = excel.readExcelData(sExcelPath, sDataSheet);


    try {
        for (Map<String, String> data : dataFromSheet) {

            loginPage.logIn(data.get(
                    "Username"),
                    data.get("Password"));

            searchHotelPage.searchHotel(
                    data.get("Location"),
                    data.get("Hotels"),
                    data.get("RoomType"),
                    data.get("NumberOfRooms"),
                    data.get("CheckInDate"),
                    data.get("CheckOutDate"),
                    data.get("AdultsPerRoom"),
                    data.get("ChildrenPerRoom"));

            selectHotelPage.selectHotel();

            bookHotelPage.bookHotel(
                    data.get("FirstName"),
                    data.get("LastName"),
                    data.get("BillingAddress"),
                    data.get("CreditCardNumber"),
                    data.get("CreditCardType"),
                    data.get("ExpiryMonth"),
                    data.get("ExpiryYear"),
                    data.get("CVV"));
            logoutPage.logOut();
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Book Hotel was successful");

    }

    @Test
    public void bookHotel2() throws IOException {

        String  sDataSheet= PropertiesOperations.getPropertyValueByKey("dataSheet");
        String sExcelPath = PropertiesOperations.getPropertyValueByKey("excelPath");


        List<Map<String, String>> dataFromSheet = excel.readExcelData(sExcelPath, sDataSheet);


        try {
            for (Map<String, String> data : dataFromSheet) {

                loginPage.logIn(data.get(
                                "Username"),
                        data.get("Password"));

                searchHotelPage.searchHotel(
                        data.get("Location"),
                        data.get("Hotels"),
                        data.get("RoomType"),
                        data.get("NumberOfRooms"),
                        data.get("CheckInDate"),
                        data.get("CheckOutDate"),
                        data.get("AdultsPerRoom"),
                        data.get("ChildrenPerRoom"));

                selectHotelPage.selectHotel();

                bookHotelPage.bookHotel(
                        data.get("FirstName"),
                        data.get("LastName"),
                        data.get("BillingAddress"),
                        data.get("CreditCardNumber"),
                        data.get("CreditCardType"),
                        data.get("ExpiryMonth"),
                        data.get("ExpiryYear"),
                        data.get("CVV"));
                logoutPage.logOut();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Book Hotel was successful");

    }

    @Test
    public void bookHotel3() throws IOException {

        String  sDataSheet= PropertiesOperations.getPropertyValueByKey("dataSheet");
        String sExcelPath = PropertiesOperations.getPropertyValueByKey("excelPath");


        List<Map<String, String>> dataFromSheet = excel.readExcelData(sExcelPath, sDataSheet);


        try {
            for (Map<String, String> data : dataFromSheet) {

                loginPage.logIn(data.get(
                                "Username"),
                        data.get("Password"));

                searchHotelPage.searchHotel(
                        data.get("Location"),
                        data.get("Hotels"),
                        data.get("RoomType"),
                        data.get("NumberOfRooms"),
                        data.get("CheckInDate"),
                        data.get("CheckOutDate"),
                        data.get("AdultsPerRoom"),
                        data.get("ChildrenPerRoom"));

                selectHotelPage.selectHotel();

                bookHotelPage.bookHotel(
                        data.get("FirstName"),
                        data.get("LastName"),
                        data.get("BillingAddress"),
                        data.get("CreditCardNumber"),
                        data.get("CreditCardType"),
                        data.get("ExpiryMonth"),
                        data.get("ExpiryYear"),
                        data.get("CVV"));
                logoutPage.logOut();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Book Hotel was successful");

    }

    //@Test(priority = 2, dependsOnMethods = "bookHotel")
    public void deleteExistingBooking() throws IOException {

    String orderNumber = generator.readFromFile();
    String  sDataSheet= PropertiesOperations.getPropertyValueByKey("dataSheet");
    String sExcelPath = PropertiesOperations.getPropertyValueByKey("excelPath");


    List<Map<String, String>> dataFromSheet = excel.readExcelData(sExcelPath, sDataSheet);


    try {
        for (Map<String, String> data : dataFromSheet) {

            loginPage.logIn(
                    data.get("Username"),
                    data.get("Password"));

        deleteExistingBookingPage.deleteExistingBooking(orderNumber);
        logoutPage.logOut();

        }

        MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

        MyLogger.info("Booked Hotel was deleted successful");

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }
}
