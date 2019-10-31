package Utils;


import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class SimpleReportFactory {

    private static ExtentReports reporter;

    BaseTest bt=new BaseTest();

    // method for report generation
    public static synchronized ExtentReports getReporter(String browser) {

        // only one object of reporter
        if (reporter == null) {
            reporter = new ExtentReports("/Users/apple/Desktop/Vineet Gulati/Desktop/Main Selenium/Selenium/Teamie/src/Screenshots23"+"_"+browser+"_"+CommonUtils.ft.format(CommonUtils.dNow)+".html", true, DisplayOrder.NEWEST_FIRST);
        }
        return reporter;
    }

    // closing reporter
    public static synchronized void closeReporter() {
        reporter.flush();
        reporter.close();
    }
}

