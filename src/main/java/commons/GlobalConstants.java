package commons;

import org.testng.annotations.Test;

import java.io.File;

public class GlobalConstants extends BasePage {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadfiles";
    public static final String FIRST_NAME = "Phat";
    public static final String LAST_NAME = "Nguyen";
    public static final String EMAIL = "phatnguyen" + getRandomNumber() + "@qa.team";
    public static final String PASSWORD = "123456";
    public static final String LOGIN_PAGE = "https://demo.guru99.com/v4/";
    public static final String REGISTER_PAGE = "https://demo.guru99.com/";
    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 5;


}
