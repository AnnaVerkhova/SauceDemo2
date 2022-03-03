package saucedemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;
import web.Page.*;
import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    //public static final String USERNAME = "standard_user";
   // public static final String PASSWORD = "secret_sauce";
    public static final String LOCKED_OUT_USER = "locked user name";
    public static final String FIRST_NAME_VALUE = "firstname";
    public static final String LAST_NAME_VALUE = "lastname";
    public static final String ZIP_VALUE = "postcode";
    public static String USERNAME;
    public static String PASSWORD;

    public void initParams() {
        USERNAME = System.getProperty("username");
        PASSWORD = System.getProperty("password");
    }

    @BeforeMethod
    public void setup() {
        initParams();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/win/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
