package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends  BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-complete.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text() = 'Checkout: Complete!']");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = TITLE_LOCATOR;
    }

    public void pushBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }


}
