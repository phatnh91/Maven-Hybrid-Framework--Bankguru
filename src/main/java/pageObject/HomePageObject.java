package pageObject;

import PageUI.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void openMenuSideBarByName(String pageName){
        waitForElementVisible(driver, HomePageUI.DYNAMIC_SIDE_BAR_MENU,pageName);
        clickToElement(driver, HomePageUI.DYNAMIC_SIDE_BAR_MENU,pageName);

    }
}
