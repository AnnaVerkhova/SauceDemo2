package web.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import web.Base.AbstractElement;

import java.time.Duration;

public class BurgerMenuElement extends AbstractElement {

    private static final By BURGER_MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By CLOSE_MENU_BUTTON = By.id("react-burger-cross-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");

    public BurgerMenuElement(WebDriver driver) {
        super(driver);
        super.baseElementLocator = BURGER_MENU_BUTTON;
    }

    public boolean open() {
        driver.findElement(BURGER_MENU_BUTTON).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            driver.findElement(CLOSE_MENU_BUTTON).sendKeys("");
            return driver.findElement(CLOSE_MENU_BUTTON);
        });
        return driver.findElement(CLOSE_MENU_BUTTON).isDisplayed();
    }

}


