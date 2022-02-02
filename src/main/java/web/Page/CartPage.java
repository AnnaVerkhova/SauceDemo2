package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends  BasePage{
    public static final String BASE_URL = "https://www.saucedemo.com/cart.html";
    public static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING = By.id("continue-shopping");
    public static final By PRODUCT_IN_CAR = By.xpath("//div[@class='inventory_item_name' and " +
            "text() = 'Test.allTheThings() T-Shirt (Red)']");
    public static final String REMOVE_BUTTON = "//div[@class ='item_pricebar']//button";

    public CartPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = TITLE_LOCATOR;
    }

    public boolean validateAddedProducts(List<String> partialTitles) {
        List<WebElement> products = driver.findElements(PRODUCT_IN_CAR);

        if (products.isEmpty()) {
            return false;
        }

        for (WebElement product : products) {
            if (!partialTitles.contains(PRODUCT_IN_CAR)) {
                return false;
            }
        }
        return true;
    }

    public void removeProduct(String partialRemoveTitle){
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,partialRemoveTitle))).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void pushCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }


}
