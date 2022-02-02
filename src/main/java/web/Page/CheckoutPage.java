package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-one.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Your Information']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = TITLE_LOCATOR;
    }

    public static final By FIRST_NAME_LOCATOR = By.id("first-name");
    public static final By LAST_NAME_LOCATOR = By.id("last-name");
    public static final By ZIP_LOCATOR = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CANCEL_BUTTON = By.id("cancel");

    public void usherInField(By fieldLocator, String fieldValue) {
        driver.findElement(fieldLocator).sendKeys(fieldValue);
    }

    public void continueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void cancelInCart() {
        driver.findElement(CANCEL_BUTTON).click();

    }

}
