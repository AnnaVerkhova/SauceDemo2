package saucedemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.PropertiesUtils;
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
    public void setup(ITestContext context) {
        initParams();
        String driverPath = PropertiesUtils.getEnv("driver_path");
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--ignore-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        setDriverAttribute(context);

    }

    private void setDriverAttribute(ITestContext context) {
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestContext context) {
        driver.close();
        driver.quit();
    }
}
