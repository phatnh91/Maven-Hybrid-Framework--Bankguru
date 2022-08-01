package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import factoryEnvironment.LocalFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest {
//    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriver driver;
    protected Log log;

    protected BaseTest(){

        log = LogFactory.getLog(getClass());
    }

    public WebDriver getDriver(){
        return this.driver;
    }
//    protected WebDriver getBrowserDriver(String browserName) {
//
//
//        if(browserName.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver.set(new FirefoxDriver());
//        }else if(browserName.equals("h_firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            //Browser options: Selenium > 3. version
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("-headless");
//            options.addArguments("window-size=1920x1080");
//            driver.set(new FirefoxDriver(options));
//        }
//
//        else if(browserName.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver.set(new ChromeDriver());
//
//        }
//        else if(browserName.equals("h_chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("-headless");
//            options.addArguments("window-size=1920x1080");
//            driver.set(new ChromeDriver(options));
//
//        }
//        else if(browserName.equals("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver.set(new EdgeDriver());
//        }else if(browserName.equals("opera")) {
//            WebDriverManager.operadriver().setup();
//            driver.set(new OperaDriver());
//        }else if(browserName.equals("coccoc")) {
//            WebDriverManager.chromedriver().driverVersion("95.0.4638.69").setup();
//            ChromeOptions options = new ChromeOptions();
//            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
//            driver.set(new ChromeDriver(options));
//        }
//        else {
//            throw new RuntimeException("Browser name is invalid");
//        }
//        driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get().manage().window().maximize();
//        driver.get().get("http://live.techpanda.org/");
//        return driver.get();
//    }

    protected WebDriver getBrowserDriver(String browserName, String pageUrl){
       driver = new LocalFactory(browserName).creatDriver();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get(pageUrl);
       return driver;
    }
//    protected WebDriver getBrowserDriver(String browserName, String urlPage) {
//
//
//        if(browserName.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + File.separator + "browserLogs" + File.separator+ "FirefoxLog.txt");
//            driver = new FirefoxDriver();
//        }else if(browserName.equals("h_firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            //Browser options: Selenium > 3. version
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("-headless");
//            options.addArguments("window-size=1920x1080");
//            driver = new FirefoxDriver(options);
//        }
//
//        else if(browserName.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            System.setProperty("webdriver.chrome.args","--disable-logging");
//            System.setProperty("webdriver.chrome.silentOutput","true");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-infobars");
//            options.addArguments("--disable-geolocation");
//            options.addArguments("--disable-notifications");
//            Map<String, Object> prefs = new HashMap<String, Object>();
//            prefs.put("credentials_enable_service",false);
//            prefs.put("profile.password_manager_enabled",false);
//            options.setExperimentalOption("prefs", prefs);
//            options.setExperimentalOption("useAutomationExtension", false);
//            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//            driver = new ChromeDriver(options);
//        }
//        else if(browserName.equals("h_chrome")) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("-headless");
//            options.addArguments("window-size=1920x1080");
//            driver = new ChromeDriver(options);
//
//        }
//        else if(browserName.equals("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }else if(browserName.equals("opera")) {
//            WebDriverManager.operadriver().setup();
//            driver = new OperaDriver();
//        }else if(browserName.equals("coccoc")) {
//            WebDriverManager.chromedriver().driverVersion("95.0.4638.69").setup();
//            ChromeOptions options = new ChromeOptions();
//            options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
//            driver = new ChromeDriver(options);
//        }
//        else {
//            throw new RuntimeException("Browser name is invalid");
//        }
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get(urlPage);
//        return driver;
//    }
    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void openLoginPage(){
        driver.get(GlobalConstants.getGlobalConstants().getLoginPageUrl());
    }

    protected int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }


}