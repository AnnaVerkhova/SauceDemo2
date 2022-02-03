package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.Elements.CartElement;

public class CheckoutCompletePage extends  BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-complete.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text() = 'Checkout: Complete!']");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");
    public CartElement cartElement;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        this.cartElement= new CartElement(driver);
        this.baseUrl = BASE_URL;
        this.baseElementLocator = TITLE_LOCATOR;
    }


    public CatalogPage pushBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
        return new CatalogPage(driver);
    }
    @Override
    public CheckoutCompletePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_LOCATOR));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this ;
    }
    @Override
    public CheckoutCompletePage openPage() {
        driver.get(BASE_URL);
        return this;
    }



}
