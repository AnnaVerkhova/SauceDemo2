package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends  BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text() = 'Checkout: Overview' ]");
    public static final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = TITLE_LOCATOR;
    }

    public void pushFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

}
