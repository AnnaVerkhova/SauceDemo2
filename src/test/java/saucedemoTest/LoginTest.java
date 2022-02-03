package saucedemoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.Page.LoginPage;

public class LoginTest extends BaseTest {
    public void openLoginPage() {
        Assert.assertTrue(
                loginPage.open()
                        .isPageLoaded()
                        , "Login page is not loaded"
        );

    }

    @BeforeMethod
    public void validCredentialsLoginTest() {
        Assert.assertTrue(
                loginPage
                        .open()
                        .isPageLoaded()
                , "Catalog page is not loaded"


        );
        Assert.assertTrue(
                loginPage
                        .login(USERNAME, PASSWORD)
                        .isPageLoaded()
                , "Catalog page is not loaded"


        );
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
        loginPage.login(LOCKED_USER, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),
                loginPage.ERROR_MESSAGE_LOCKED,
                "Error message is incorrect");
    }

}
