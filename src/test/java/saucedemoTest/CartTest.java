package saucedemoTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.Page.BasePage;

public class CartTest extends LoginTest {

    @Test
    public void menuIsOpenedTest() {
        loginPage
                .open();
        Assert.assertTrue(
                cartPage
                        .open()
                        .isPageLoaded()
                , "Cart page is not loaded"
        );
        Assert.assertTrue(cartPage.burgerMenu.open(), "Menu is not opened");
    }
}
