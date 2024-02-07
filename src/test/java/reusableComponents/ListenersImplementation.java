package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ExtentFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenersImplementation implements ITestListener {

    static ExtentReports reports;
    ExtentTest test;

    public void onTestStart(ITestResult result){

        //before each test case
        test = reports.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    public void onTestSuccess(ITestResult result){

        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: " + result.getMethod().getMethodName()+ " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();

    }

    public void onTestFailure(ITestResult result){

        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName()+ " is Failed.");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

        //add screenshot for failed test
        File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();

        String actualDate = formattedDate.format(date);

        String screenshotPath = System.getProperty("user.dir")+"/reports/screenshot/"+actualDate+".jpeg";
        File file = new File(screenshotPath);

        try{

            FileUtils.copyFile(src, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{

            ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
            ExtentFactory.getInstance().removeExtentObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result){

        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName()+ " is Skipped.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestTestFailedButWithinSuccessPercentage(ITestResult result){

    }

    public void onTestFailedWithTimeout(ITestResult result){
    }

    public void onStart(ITestContext context){

        try{
            reports = ExtentReportsSetUp.setUpExtentReports();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context){

        //close extent
        reports.flush();
    }

}
