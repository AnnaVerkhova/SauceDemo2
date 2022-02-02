package web.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.Base.AbstractElement;

public class CartElement extends AbstractElement {
    private static final By CART_ELEMENT=By.id("shopping_cart_container");


    public CartElement(WebDriver driver) {
        super(driver);
        super.baseElementLocator= CART_ELEMENT ;
    }

}
