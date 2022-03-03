package web.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import web.Elements.BurgerMenuElement;
import web.Elements.CartElement;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogPage extends BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");
    private static final By PRODUCTS_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private static final By SORT_PRODUCYS = By.cssSelector(".product_sort_container");
    public static String SORT_AZ = "A to Z";
    public static String SORT_ZA = "Z to A";
    public static String  SORT_PRICE_LOW_TO_HIGH ="low to high";
    public static String  SORT_PRICE_HIGH_TO_LOW ="high to low";
    public static String SORT_PATTERN_NAME = "//option[contains(text(), '')]";
    public static final String REMOVE_BUTTON = "Remove";
    private static final String ADD_TO_CART = "ADD TO CART";
    public BurgerMenuElement burgerMenu;
    public CartElement cartElement;
    public static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";


    public CatalogPage(WebDriver driver) {
        super(driver);
        this.cartElement= new CartElement(driver);
        this.burgerMenu = new BurgerMenuElement(driver);
        this.baseUrl = BASE_URL;
        this.baseElementLocator = TITLE_LOCATOR;
    }

    public CatalogPage addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
        return this;

    }

    public void openSortProduct(){
        driver.findElement(SORT_PRODUCYS).click();
    }

    public CatalogPage setSortProduct(String partialSortProduct){
        openSortProduct();
        driver.findElement(By.xpath(String.format(SORT_PATTERN_NAME,partialSortProduct))).click();
        return this;
    }

    public ArrayList<String> getProductList(){
        ArrayList<String>list = new ArrayList<>();
        List<WebElement>productList =driver.findElements(PRODUCTS_NAME_LOCATOR);
        for (WebElement product: productList){
            list.add(product.getText());
            return list;
        }
        return list;
    }

    public ArrayList<String> sortProductAtoZ(){
        ArrayList<String>sortList =new ArrayList<>();
        for (String sort: getProductList()){
            sortList.add(sort);
        }
        Collections.sort(sortList);
        return sortList;
    }

    public ArrayList<String> sortProductZtoA(){
        ArrayList<String>sortList =new ArrayList<>();
        for (String sort: getProductList()){
            sortList.add(sort);
        }
        Collections.reverse(sortList);
        return sortList;
    }

    public ArrayList<String> sortProductLowToHigh(){
        ArrayList<String>sortList =new ArrayList<>();
        for (String sort: getProductList()){
            sortList.add(sort);
        }
        Collections.sort(sortList);
        return sortList;
    }
    public ArrayList<String> sortProductHighToLow(){
        ArrayList<String>sortList =new ArrayList<>();
        for (String sort: getProductList()){
            sortList.add(sort);
        }
        Collections.reverse(sortList);
        return sortList;
    }
    @Override
    public CatalogPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_LOCATOR));
        } catch (TimeoutException timeoutException) {
            return null;
        }
        return this ;
    }
    @Override
    public CatalogPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}


