package pageObject;

import PageUI.NewCustomerPageUI;
import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class NewCustomerPageObject extends BasePage {

    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void pressTabKeyonCustomerName() {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        getWebElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX).sendKeys(Keys.TAB);
    }

    public String getCustomerNameErrorMessage() {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);

    }

    public void enterToCustomerNameTextbox(String name) {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
        sendKeysToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, name);
    }

    public void pressTabKeyonCity() {
        waitForElementClickable(driver, NewCustomerPageUI.CITY_TEXTBOX);
        getWebElement(driver, NewCustomerPageUI.CITY_TEXTBOX).sendKeys(Keys.TAB);
    }

    public String getCityErrorMessage() {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
    }

    public void enterToCityTextbox(String cityName) {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
        sendKeysToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, cityName);
    }
}
