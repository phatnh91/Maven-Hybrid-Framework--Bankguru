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

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {

        driver = getBrowserDriver(browserName,pageUrl);
        registerPage = PageObjectGenerator.getRegisterPageObject(driver);
        registerPage.sendKeysToEmailTextBox(registerPage.getRandomEmail());
        registerPage.clickToSubmitButton();
        String userID = registerPage.getUserID();
        String password = registerPage.getUserPassword();
        openLoginPage();
        loginPage = PageObjectGenerator.getLoginPageObject(driver);
        homePage = loginPage.loginAsUser(userID, password);


    }

    @Test
    public void New_Customer_01_Verify_Name_Field(Method method) {
        String invalidName1 = "1234";
        String invalidName2 = "abc123";
        String invalidName3 = "name!@#";
        String invalidName4 = "!@#";

        ExtentTestManager.startTest(method.getName(), "New_Customer_01_Verify_Name_Field");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 01: Open 'New Customer' page");
        homePage.openMenuSideBarByName("New Customer");
        newCustomerPage = PageObjectGenerator.getNewCustomerPageObject(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 02: Click on Customer Name and Press TAB key");
        newCustomerPage.pressTabKeyonCustomerName();
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 03: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "Customer name must not be blank");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 04: Enter numberic value '" + invalidName1 + "' in NAME field");
        newCustomerPage.enterToCustomerNameTextbox(invalidName1);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 05: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "Numbers are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 06: Enter numberic value '" + invalidName2 + "' in NAME field");
        newCustomerPage.enterToCustomerNameTextbox(invalidName2);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 07: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "Numbers are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 08: Enter numberic value '" + invalidName3 + "' in NAME field");
        newCustomerPage.enterToCustomerNameTextbox(invalidName3);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 09: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "Special characters are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 10: Enter numberic value '" + invalidName4 + "' in NAME field");
        newCustomerPage.enterToCustomerNameTextbox(invalidName4);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 11: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "Special characters are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 12: Enter a space in NAME field");
        newCustomerPage.enterToCustomerNameTextbox(" ");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_01_Verify_Name_Field - Step 13: Verify the Customer Name Error Message");
        verifyEquals(newCustomerPage.getCustomerNameErrorMessage(), "First character can not have space");
        ExtentTestManager.endTest();

    }

    @Test
    public void New_Customer_02_Verify_City_Field(Method method) {

        String invalidCity1 = "1234";
        String invalidCity2 = "City123";
        String invalidCity3 = "City!@#";
        String invalidCity4 = "!@#";

        ExtentTestManager.startTest(method.getName(), "New_Customer_02_Verify_City_Field");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 01: Open 'New Customer' page");
        homePage.openMenuSideBarByName("New Customer");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 02: Click on City and Press TAB key");
        newCustomerPage.pressTabKeyonCity();
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 03: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "City Field must not be blank");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 04: Enter numberic value '" + invalidCity1 + "' in City field");
        newCustomerPage.enterToCityTextbox(invalidCity1);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 05: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "Numbers are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 06: Enter numberic value '" + invalidCity2 + "' in City field");
        newCustomerPage.enterToCityTextbox(invalidCity2);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 07: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "Numbers are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 08: Enter numberic value '" + invalidCity3 + "' in City field");
        newCustomerPage.enterToCityTextbox(invalidCity3);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 09: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "Special characters are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 10: Enter numberic value '" + invalidCity4 + "' in City field");
        newCustomerPage.enterToCityTextbox(invalidCity4);
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 11: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "Special characters are not allowed");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 12: Enter a space in City field");
        newCustomerPage.enterToCityTextbox(" ");
        ExtentTestManager.getTest().log(LogStatus.INFO, "New_Customer_02_Verify_City_Field - Step 13: Verify the City Error Message");
        verifyEquals(newCustomerPage.getCityErrorMessage(), "First character can not have space");

        ExtentTestManager.endTest();

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        driver.quit();

    }

    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    HomePageObject homePage;
    NewCustomerPageObject newCustomerPage;
}
