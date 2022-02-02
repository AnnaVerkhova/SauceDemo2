package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String ERROR_MESSAGE_LOCKED = "Epic sadface: Sorry, this user has been locked out.";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = LOGIN_BUTTON;
    }

    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.tagName("h3");

    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";

    public void login(String username, String password) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getUserNamePlaceholder() {
        return driver.findElement(USERNAME_TEXT_FIELD).getAttribute("placeholder");

    }

}
