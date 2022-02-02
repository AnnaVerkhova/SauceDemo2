package web.Page;

import org.openqa.selenium.WebDriver;
import web.Base.AbstractPage;

public abstract class BasePage extends AbstractPage {

    protected String baseUrl;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage open() {
        driver.get(baseUrl);

        return this;
    }
    public abstract BasePage isPageOpened();
    public abstract BasePage openPage();
}




