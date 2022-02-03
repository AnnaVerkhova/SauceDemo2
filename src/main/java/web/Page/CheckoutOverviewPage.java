package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.Elements.CartElement;

public class CheckoutOverviewPage extends  BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text() = 'Checkout: Overview' ]");
    public static final By FINISH_BUTTON = By.id("finish");
    public CartElement cartElement;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.cartElement= new CartElement(driver);
        this.baseUrl = BASE_URL;
        this.baseElementLocator = TITLE_LOCATOR;
    }

    public void pushFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_LOCATOR));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this ;
    }
    @Override
    public CheckoutOverviewPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}
