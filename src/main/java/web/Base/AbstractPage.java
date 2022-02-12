package web.Base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class AbstractPage extends AbstractElement{

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(baseElementLocator));
        } catch (TimeoutException timeoutException) {
            return false;
        }
        return true;
    }
}

