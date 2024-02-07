package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusableComponents.FileGenerator;
import utils.DriverFactory;
import utils.TestBase;

import java.time.Duration;

public class BookHotelPage extends TestBase {

    By firstName = By.xpath("//*[@id=\"first_name\"]");
    By lastName = By.xpath("//*[@id=\"last_name\"]");
    By billingAddress = By.xpath("//*[@id=\"address\"]");
    By creditCardNumber = By.xpath("//*[@id=\"cc_num\"]");
    By creditCardType = By.xpath("//*[@id=\"cc_type\"]");
    By expMonth = By.xpath("//*[@id=\"cc_exp_month\"]");
    By expYear = By.xpath("//*[@id=\"cc_exp_year\"]");
    By cvv = By.xpath("//*[@id=\"cc_cvv\"]");
    By bookNowBtn = By.xpath("//*[@id=\"book_now\"]");

    By s = By.xpath("//td[@colspan=\"2\" and @class=\"login_title\" and contains(text(), \"Booking Confirmation\")]\n");
    By generatedOrderNumber = By.xpath("//*[@id=\"order_no\"]");

    public void bookHotel(String FirstName, String LastName, String BillingAddress, String CreditCardNumber, String CreditCardType,
                          String ExpMonth, String ExpYear, String CVV) {

        FileGenerator generator = new FileGenerator();

        try {
            clearCustom(DriverFactory.getInstance().getDriver().findElement(firstName), "FirstName");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(firstName), "FirstName", FirstName);

            clearCustom(DriverFactory.getInstance().getDriver().findElement(lastName), "Lastname");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(lastName), "LastName", LastName);

            clearCustom(DriverFactory.getInstance().getDriver().findElement(billingAddress), "BillingAddress");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(billingAddress), "BillingAddress", BillingAddress);

            clearCustom(DriverFactory.getInstance().getDriver().findElement(creditCardNumber), "CreditCardNumber");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(creditCardNumber), "CreditCardNumber", CreditCardNumber);

            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(creditCardType), "CreditCardType", CreditCardType);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(expMonth), "ExpiryMonth", ExpMonth);
            selectDropDownByVisibleTextCustom(DriverFactory.getInstance().getDriver().findElement(expYear), "ExpiryYear", ExpYear);

            clearCustom(DriverFactory.getInstance().getDriver().findElement(cvv), "CVV");
            sendKeysCustom(DriverFactory.getInstance().getDriver().findElement(cvv), "CVV", CVV);


            clickCustom(DriverFactory.getInstance().getDriver().findElement(bookNowBtn), "BookNowButton");


            //save order number generated
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(generatedOrderNumber));

            //write to file
            WebElement orderNumber = DriverFactory.getInstance().getDriver().findElement(generatedOrderNumber);

            if(orderNumber != null){

                try {
                    String _OrderNumber = orderNumber.getAttribute("value");
                    generator.writeToFile(_OrderNumber);
                } catch (Exception e) {
                    System.out.println("Exception while getting order number value: " + e.getMessage());
                }

            } else {
                System.out.println("Order number WebElement is null. Cannot extract and write to file.");
            }


        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}