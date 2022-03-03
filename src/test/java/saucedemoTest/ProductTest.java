package saucedemoTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.Page.CheckoutPage;

public class ProductTest extends LoginTest {
    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";
    public static final String TEST_PRODUCT2_TITLE = "Sauce Labs Onesie";
    public static final String TEST_PRODUCT3_TITLE = "Искусственный провал теста";

    @Test(description = "Тестирование полного цикла покупки товара")
    public void addProduct() {

        catalogPage
                .addProductToCart(TEST_PRODUCT_TITLE);
        cartPage
                .open()
                .isPageLoaded();
        cartPage.continueShopping();
        catalogPage
                .addProductToCart(TEST_PRODUCT2_TITLE);
        cartPage
                .open()
                .isPageLoaded();
        cartPage.removeProduct(TEST_PRODUCT_TITLE)
                .pushCheckout();
        checkoutPage
                .usherInField(CheckoutPage.FIRST_NAME_LOCATOR, FIRST_NAME_VALUE)
                .usherInField(CheckoutPage.LAST_NAME_LOCATOR, LAST_NAME_VALUE)
                .usherInField(CheckoutPage.ZIP_LOCATOR, ZIP_VALUE)
                .continueButton();
        checkoutOverviewPage
                .pushFinish();
        checkoutCompletePage
                .pushBackHomeButton();
        Assert.assertTrue(
                catalogPage
                        .isPageLoaded()
                , "Catalog is not loaded");
    }

}

