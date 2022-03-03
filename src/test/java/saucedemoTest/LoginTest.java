package saucedemoTest;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.Page.LoginPage;

import java.io.File;
import java.io.FileOutputStream;


public class LoginTest extends BaseTest {


    @Step("Second step {keyword}")
    public void productPageOpenStep(String keyword){
        Assert.fail("Искусственный провал теста");
    }

    @Step("Открывается страница логина")
    public void openLoginPage() {
        Assert.assertTrue(
                loginPage.open()
                        .isPageLoaded()
                , "Login page is not loaded"
        );

    }

    @BeforeMethod
    @Link("https://www.saucedemo.com/")
    public void validCredentialsLoginTest() {
        Assert.assertTrue(
                loginPage
                        .open()
                        .isPageLoaded()
                , "Login page is not loaded"
        );
        loginPage
                .login(USERNAME, PASSWORD);
        ;
        byte[] screenshotByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File screenshot = new File("screenshot.jpg");
        try (FileOutputStream outputStream = new FileOutputStream(screenshot)) {
            outputStream.write(screenshotByte);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(catalogPage.isPageLoaded(), "Login page is not loaded");
    }

    @Test
    public void usernamePlaceholderTest() {
        openLoginPage();
        Assert.assertEquals(loginPage.getUserNamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid");
        loginPage.getUserNamePlaceholder();
    }

    @Test
    public void lockedUserTest() {
        openLoginPage();
        loginPage.login(LOCKED_OUT_USER, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),
                loginPage.ERROR_MESSAGE_MISMATCH,
                "Error message is incorrect");
    }

}
