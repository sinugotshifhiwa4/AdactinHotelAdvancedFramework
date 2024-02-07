package reusableComponents;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverFactory;
import utils.ExtentFactory;

public class ActionEngine {

    public void sendKeysCustom(WebElement element, String fieldName, String valueToBeSent){
        try{
            element.sendKeys(valueToBeSent);
            // Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully entered value '" + valueToBeSent + "' in the field: " + fieldName);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Failed to enter value in the field: " + fieldName + ". Exception: " + e.getMessage());
        }
    }

    public void clickCustom(WebElement element, String fieldName){
        try{
            element.click();
            // Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully clicked on '" + fieldName + "'");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Failed to click on '" + fieldName + "'. Exception: " + e.getMessage());
        }
    }

    public void clearCustom(WebElement element, String fieldName){
        try{
            element.clear();
            // Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Data cleared successfully for field: '" + fieldName + "'");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to clear data for field: " + fieldName + "'. Exception: " + e.getMessage());
        }
    }

    public void moveToElementCustom(WebElement element, String fieldName){
        try {
            JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            Actions actions = new Actions(DriverFactory.getInstance().getDriver());
            actions.moveToElement(element).build().perform();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Mouse hovered successfully on: '" + fieldName + "'");
            Thread.sleep(1000);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to hover mouse on field: " + fieldName + "'. Exception: " + e.getMessage());
        }
    }

    public boolean isElementPresent(WebElement element, String fieldName){
        boolean flag = false;
        try{
            // Log success message in extent report
            flag = element.isDisplayed();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Presence of field '" + fieldName + "' is: " + flag);
            return flag;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Checking for presence of field: " + fieldName + "'. Exception: " + e.getMessage());
            return flag;
        }
    }

    public void selectDropDownByVisibleTextCustom(WebElement element, String fieldName, String ddVisibleText) throws Throwable{
        try{
            Select select = new Select(element);
            select.selectByVisibleText(ddVisibleText);
            // Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown value selected by visible text for field: '" + fieldName + "'");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " + fieldName + "'. Exception: " + e.getMessage());
        }
    }

    public void selectDropDownByValueCustom(WebElement element, String fieldName, String ddVisibleText) throws Throwable{
        try{
            Select select = new Select(element);
            select.selectByValue(ddVisibleText);
            // Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown value selected by value text for field: '" + fieldName + "'");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " + fieldName + "'. Exception: " + e.getMessage());
        }
    }

    public void assertEqualsStringCustom(String expectedValue, String actualValue, String locatorName) throws Throwable{
        try{
            // Log success message in extent report
            Assert.assertEquals(expectedValue, actualValue);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "String assertion is successful for field: '" + locatorName + "'");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String assertion failed for field: " + locatorName + "'. Exception: " + e.getMessage());
        }
    }

    public String getTextCustom(WebElement element, String fieldName){
        String text = "";
        try{
            // Log success message in extent report
            text = element.getText();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Text retrieved for field: '" + fieldName + "' is: " + text);
            return text;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Text not retrieved for field: " + fieldName + "'. Exception: " + e.getMessage());
            return text;
        }
    }


}
