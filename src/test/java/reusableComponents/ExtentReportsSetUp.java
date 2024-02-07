package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsSetUp {

    static ExtentReports extentReports;

    public static ExtentReports setUpExtentReports() throws Exception {

        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();

        String actualDate = formatDate.format(date);

        String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("DocumentTitle");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("ReportName");

        extentReports.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("appUrl"));
        extentReports.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("chooseBrowser"));
        extentReports.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extentReports.setSystemInfo("Executed on User: ", System.getProperty("user.name"));

        return extentReports;
    }
}
