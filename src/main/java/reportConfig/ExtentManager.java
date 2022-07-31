package reportConfig;
import com.relevantcodes.extentreports.ExtentReports;
import commons.GlobalConstants;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(GlobalConstants.getGlobalConstants().getProjectPath() + "\\ExtentReports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
