package pageObject;

import PageUI.LoginPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){

        this.driver=driver;

    }
    public HomePageObject loginAsUser(String userID, String password){
        waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
        sendKeysToElement(driver,LoginPageUI.USERID_TEXTBOX,userID);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageObjectGenerator.getHomePageObject(driver);

    }
}
