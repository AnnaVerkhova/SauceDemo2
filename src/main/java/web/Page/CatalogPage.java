package web.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogPage extends BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");
    private static final By BURGER_MENU_BUTTUN = By.id("react-burger-menu-btn");
    private static final By CLOSSES_MENU_BUTTON = By.id("react-burger-cross-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");
    private static final By PRODUCTS_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private static final By SORT_PRODUCYS = By.cssSelector(".product_sort_container");
    public static String SORT_AZ = "A to Z";
    public static String SORT_ZA = "Z to A";
    public static String  SORT_PRICE_LOW_TO_HIGH ="low to high";
    public static String  SORT_PRICE_HIGH_TO_LOW ="high to low";
    public static String SORT_PATTERN_NAME = "//option[contains(text(), '')]";
    public static final String REMOVE_BUTTON = "Remove";
    private static final String ADD_TO_CART = "ADD TO CART";



    public static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElement = TITLE_LOCATOR;
    }

    public void addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();

    }

    public boolean openBurgerMenu() {
        driver.findElement(BURGER_MENU_BUTTUN).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            driver.findElement(BURGER_MENU_BUTTUN).sendKeys("");
            return driver.findElement(BURGER_MENU_BUTTUN);
        });
        return crossButton.isDisplayed();
    }

    public void closeBurgerMenu() {
        openBurgerMenu();
        driver.findElement(CLOSSES_MENU_BUTTON).click();
    }

    public void Logout(){
        openBurgerMenu();
        driver.findElement(LOGOUT).click();
    }
    public void openSortProduct(){
        driver.findElement(SORT_PRODUCYS).click();
    }

    public void setSortProduct(String partialSortProduct){
        openSortProduct();
        driver.findElement(By.xpath(String.format(SORT_PATTERN_NAME,partialSortProduct))).click();
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
        Collections.reverse(sortList);
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
        Collections.reverse(sortList);
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

}


