package saucedemoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;
import web.Page.CatalogPage;

import java.util.ArrayList;

public class CatalogTest extends LoginTest {

    @BeforeMethod
    private void login() {
        Assert.assertTrue(
                loginPage
                        .open()
                        .isPageLoaded()
                , "Login page is not loaded"

        );
        loginPage
                .login(USERNAME, PASSWORD);
        Assert.assertTrue(
                catalogPage.isPageLoaded()
                , "Catalog page is not loaded");
    }

    @Test (retryAnalyzer = Retry.class)
    public void sortingAtoZTest() {
        ArrayList<String> expected = catalogPage.sortProductAtoZ();
        catalogPage.setSortProduct(CatalogPage.SORT_AZ);
        Assert.assertEquals(catalogPage.getProductList(), expected, "Open sort A to Z is incorrect");
    }

    @Test
    public void sortingZtoATest() {
        ArrayList<String> expected = catalogPage.sortProductZtoA();
        catalogPage.setSortProduct(CatalogPage.SORT_ZA);
        Assert.assertEquals(catalogPage.getProductList(), expected, "Open sort Z to A is incorrect");
    }

    @Test
    public void sortingLHTest() {
        ArrayList<String> expected = catalogPage.sortProductLowToHigh();
        catalogPage.setSortProduct(CatalogPage.SORT_PRICE_LOW_TO_HIGH);
        Assert.assertEquals(catalogPage.getProductList(), expected, "Open sort low to high is incorrect");
    }

    @Test
    public void sortingHLTest() {
        ArrayList<String> expected = catalogPage.sortProductHighToLow();
        catalogPage.setSortProduct(CatalogPage.SORT_PRICE_HIGH_TO_LOW);
        Assert.assertEquals(catalogPage.getProductList(), expected, "Open sort high to low is incorrect");
    }

    @Test
    public void menuIsOpenedTest() {
        loginPage
                .open();
        Assert.assertTrue(
                catalogPage
                        .open()
                        .isPageLoaded()
                , "Catalog page is not loaded"
        );
        Assert.assertTrue(catalogPage.burgerMenu.open(), "Menu is not opened");
    }
}
