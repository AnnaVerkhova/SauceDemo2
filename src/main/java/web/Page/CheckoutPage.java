package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.Elements.CartElement;

public class CheckoutPage extends BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-one.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Your Information']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.cartElement= new CartElement(driver);
        this.baseUrl = BASE_URL;
        this.baseElementLocator = TITLE_LOCATOR;
    }

    public static final By FIRST_NAME_LOCATOR = By.id("first-name");
    public static final By LAST_NAME_LOCATOR = By.id("last-name");
    public static final By ZIP_LOCATOR = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CANCEL_BUTTON = By.id("cancel");
    public CartElement cartElement;

    public CheckoutPage usherInField(By fieldLocator, String fieldValue) {
        driver.findElement(fieldLocator).sendKeys(fieldValue);
        return this;
    }

    public void continueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void cancelInCart() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Override
    public CheckoutPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_LOCATOR));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this ;
    }

    @Override
    public CheckoutPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}

