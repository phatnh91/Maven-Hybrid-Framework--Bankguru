package pageObject;

import PageUI.RegisterPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver){

        this.driver = driver;
    }

    public void sendKeysToEmailTextBox(String email){

        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,email);

    }
    public void clickToSubmitButton(){

        waitForElementClickable(driver,RegisterPageUI.SUBMIT_BUTTON);
        clickToElement(driver,RegisterPageUI.SUBMIT_BUTTON);

    }
    public String getUserID(){
        waitForElementVisible(driver, RegisterPageUI.USER_ID);
        return getElementText(driver, RegisterPageUI.USER_ID);
    }
    public String getUserPassword(){
        waitForElementVisible(driver, RegisterPageUI.PASSWORD);
        return getElementText(driver, RegisterPageUI.PASSWORD);
    }



}
