package NewCustomer;

import com.relevantcodes.extentreports.LogStatus;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.*;
import reportConfig.ExtentTestManager;
import java.lang.reflect.Method;

public class New_Customer_01 extends BaseTest {

    private WebDriver driver;
    String userID, password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName,pageUrl);
        registerPage = PageObjectGenerator.getRegisterPageObject(driver);
        registerPage.sendKeysToEmailTextBox(registerPage.getRandomEmail());
        registerPage.clickToSubmitButton();
        userID = registerPage.getUserID();
        password = registerPage.getUserPassword();


    }

    @Test
    public void New_Customer_01_Verify_When_Login_Successfull(Method method) {

        ExtentTestManager.startTest(method.getName(), "New_Customer_01_Verify_When_Login_Successfull");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_When_Login_Successfull - Step 01: Open Login Page");
        openLoginPage();
        loginPage = PageObjectGenerator.getLoginPageObject(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_When_Login_Successfull - Step 02: Enter "+userID+password +"to Username and Password text box and click to Login button");
        homePage = loginPage.loginAsUser(userID, password);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_When_Login_Successfull - Step 02: Verify user is redirected to Managerhomepage");
        verifyEquals(homePage.getPageUrl(driver),"https://demo.guru99.com/v4/manager/Managerhomepage.php");
        ExtentTestManager.endTest();
    }

    @Test
    public void New_Customer_02_Verify_Webhub(Method method) {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    HomePageObject homePage;
}
