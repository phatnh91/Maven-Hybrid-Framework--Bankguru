package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class FirefoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.getGlobalConstants().getProjectPath() + File.separator + "browserLogs" + File.separator+ "FirefoxLog.txt");
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", GlobalConstants.getGlobalConstants().getUploadFileFolder());
        options.addPreference("browser.download.useDownloadDir",true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk","multipart/x-zip, application/zip, application/x-zip-compressed, application/x-compressed, application/msword, application/csv,text/csv, image/png, image/jpeg, application/pdf, text/html,text/plain, application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
        options.addPreference("pdfjs.disabled",true);
        return new FirefoxDriver();
    }
}
